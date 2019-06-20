package com.prosayj.springboot.poi;


import org.apache.poi.sl.usermodel.*;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.xslf.usermodel.*;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.List;

/**
 * @author yangjian
 * @description PowerPoint文件工具基类
 * 通用的PowerPoint文件工具基类，可用于从PowerPoint文档中抽取文本信息
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/15 21:41
 * @since 1.0.0
 */
public class BasePowerPointFileUtil {
    /**
     * <p>读取PowerPoint文件中的幻灯片对象
     *
     * @param slideShow SlideShow对象
     * @return 读取出的工作薄列表
     */
    public static List readSlideShow(SlideShow slideShow) {

        List slideList = null;
        if (slideShow != null) {

            slideList = new ArrayList();
            List slides = slideShow.getSlides();
            for (int i = 0; i < slides.size(); i++) {
                slideList.add(BasePowerPointFileUtil.readSlide((Slide) slides.get(i)));
            }
        }
        return slideList;
    }

    /**
     * <p>读取指定的Slide中的数据
     *
     * @param slide Slide对象
     * @return 读取出的Slide数据列表
     */
    public static List readSlide(Slide slide) {

        List shapeList = null;
        if (slide != null) {

            shapeList = new ArrayList();
            List shapes = slide.getShapes();
            for (int i = 0; i < shapes.size(); i++) {
                shapeList.add(BasePowerPointFileUtil.readShape((Shape) shapes.get(i)));
            }
        }
        return shapeList;
    }

    /**
     * <p>读取指定的图形的数据
     *
     * @param shape Slide中的图形对象
     * @return 读取出的图形数据
     */
    public static Object readShape(Shape shape) {

        String returnValue = null;
        if (shape != null) {

            if (shape instanceof TextShape) {
                try {

                    returnValue = ((TextShape) shape).getText();
                } catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        }
        return returnValue;
    }

    public static void renderShape(Shape shape, Map<String, Object> data, XMLSlideShow ppt, int i) throws IOException {
        if (shape instanceof TextShape) {
            BasePowerPointFileUtil.replace(shape, data, ppt, i);
        } else if (shape instanceof GroupShape) {
            Iterator groupShapes = ((GroupShape) shape).iterator();
            while (groupShapes.hasNext()) {
                Shape groupShape = (Shape) groupShapes.next();
                BasePowerPointFileUtil.renderShape(groupShape, data, ppt, i);
            }
        } else if (shape instanceof TableShape) {
            TableShape tableShape = ((TableShape) shape);
            int column = tableShape.getNumberOfColumns();
            int row = tableShape.getNumberOfRows();
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < column; c++) {
                    BasePowerPointFileUtil.replace(tableShape.getCell(r, c), data, ppt, i);
                }
            }
        }
//        else if (shape instanceof PictureShape) {
//            PictureShape pictureShape = ((PictureShape) shape);
//            PictureData pictureData = pictureShape.getPictureData();
//            String url = "http://img.atme8.com/Fi8XLHpB-XYOq7NJHIVCA2OqysTN";
//            byte[] btImg = getImageFromNetByUrl(url);
//            pictureData.setData(btImg);
//            byte[] b = pictureData.getData();
//            System.out.println(pictureShape);
//        }
    }

    /**
     * 根据地址获得数据的字节流
     *
     * @param strUrl 网络连接地址
     * @return
     */
    private static byte[] getImageFromNetByUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5 * 1000);
            InputStream inStream = conn.getInputStream();//通过输入流获取图片数据
            byte[] btImg = readInputStream(inStream);//得到图片的二进制数据
            return btImg;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 从输入流中获取数据
     *
     * @param inStream 输入流
     * @return
     * @throws Exception
     */
    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        return outStream.toByteArray();
    }

    public static void replace(Shape shape, Map<String, Object> data, XMLSlideShow ppt, int i) throws IOException {
        if (data == null) {
            data = new HashMap<>();
        }
        if (shape instanceof TextShape) {
            TextShape textShape = (TextShape) shape;
            String text = textShape.getText();
            List<String> keys = DealStrSubUtil.getSubUtil(text, "\\$\\{(.+?)\\}");
            Map<String, Object> map = (Map<String, Object>) data;
            for (String key : keys) {
                Object value = map.get(key);
                if (value != null) {
                    if (key.contains("text")) {
                        text = text.replaceAll("\\$\\{" + key + "\\}", value.toString());
//                        text = text.replaceAll("\\r\\n|\\r|\\n|\\n\\r", "");
                        textShape.setText(text);
//                        for(int j = 0 ; j < textShape.getTextParagraphs().size() ; j ++) {
//                            XSLFTextParagraph xh = (XSLFTextParagraph) textShape.getTextParagraphs().get(j);
//
//                            XSLFTextRun xslfTextRun = xh.getTextRuns().get(0);
//                            if (j % 2 != 0){
//                                xslfTextRun.setFontSize(12d);
//                            }
//
////                            for (int k = 0; k < xh.getTextRuns().size(); k++) {
////                                XSLFTextRun xslfTextRun = xh.getTextRuns().get(k);
////                                if (j % 2 != 0)
////                                    xslfTextRun.setFontSize(12d);
////                            }
//                        }
                    }
                    if (key.contains("Img")) {
                        if (!"null".equals(value)) {
                            //图片替换区域
                            byte[] btImg = getImageFromNetByUrl(value.toString());
                            XSLFPictureData idx = ppt.addPicture(btImg, XSLFPictureData.PictureType.JPEG);
                            List<XSLFSlide> slides = ppt.getSlides();
                            XSLFSlide slide = slides.get(i);
                            XSLFPictureShape pic = slide.createPicture(idx);
                            Rectangle2D anchor = shape.getAnchor();
                            // 设置XSLFPictureShape的位置信息
                            pic.setAnchor(anchor);
                            // 移除XSLFTextShape
                            slide.removeShape((XSLFShape) shape);
                        } else {
//                            text = text.replaceAll("\\$\\{" + key + "\\}", ProductContant.NULL_PICTURE_TEXT_NOTICE);
                            text = text.replaceAll("\\$\\{" + key + "\\}", "NULL_PICTURE_TEXT_NOTICE");
                            textShape.setText(text);
                            for (int j = 0; j < textShape.getTextParagraphs().size(); j++) {
                                XSLFTextParagraph xh = (XSLFTextParagraph) textShape.getTextParagraphs().get(j);
                                XSLFTextRun xslfTextRun = xh.getTextRuns().get(0);
                                xslfTextRun.setFontSize(18d);
                                xslfTextRun.setFontColor(Color.red);
                            }
                        }
                    }
                    if (key.contains("table")) {
                        Object[][] objects = (Object[][]) value;
                        if ("page_5_table_1".equals(key) && objects[0][0].equals("null")) {
//                            text = text.replaceAll("\\$\\{" + key + "\\}", ProductContant.NULL_Table_TEXT_TAX_NOTICE);
                            text = text.replaceAll("\\$\\{" + key + "\\}", "NULL_Table_TEXT_TAX_NOTICE");
                            textShape.setText(text);
                            for (int j = 0; j < textShape.getTextParagraphs().size(); j++) {
                                XSLFTextParagraph xh = (XSLFTextParagraph) textShape.getTextParagraphs().get(j);
                                XSLFTextRun xslfTextRun = xh.getTextRuns().get(0);
                                xslfTextRun.setFontSize(18d);
                                xslfTextRun.setFontColor(new Color(1, 4, 8));
                                xslfTextRun.setBold(true);
                            }
                            textShape.setHorizontalCentered(true);
                            textShape.setVerticalAlignment(VerticalAlignment.TOP);
                        } else if ("page_6_table_1".equals(key) && objects[0][0].equals("null")) {
//                            text = text.replaceAll("\\$\\{" + key + "\\}", ProductContant.NULL_TABLE_TEXT_TAX_CREDITS_NOTICE);
                            text = text.replaceAll("\\$\\{" + key + "\\}", "NULL_TABLE_TEXT_TAX_CREDITS_NOTICE");
                            textShape.setText(text);
                            for (int j = 0; j < textShape.getTextParagraphs().size(); j++) {
                                XSLFTextParagraph xh = (XSLFTextParagraph) textShape.getTextParagraphs().get(j);
                                XSLFTextRun xslfTextRun = xh.getTextRuns().get(0);
                                xslfTextRun.setBold(true);
                                xslfTextRun.setFontSize(18d);
                                xslfTextRun.setFontColor(new Color(1, 4, 8));
                            }
                            textShape.setHorizontalCentered(true);
                            textShape.setVerticalAlignment(VerticalAlignment.TOP);
                        } else {
                            Object[][] datas = (Object[][]) value;
                            /** 创建表格**/
                            XSLFSlide slide = ppt.getSlides().get(i);
                            XSLFTable table = slide.createTable();
                            /** 设置表格 x ,y ,width,height **/
                            Rectangle2D rectangle2D = new Rectangle2D.Double(30, 150, 900, 500);
                            //                        Rectangle2D rectangle2D = shape.getAnchor();
                            table.setAnchor(rectangle2D);
                            for (int x = 0; x < datas.length; x++) {
                                XSLFTableRow tableRow = table.addRow(); //创建表格行
                                for (int y = 0; y < datas[x].length; y++) {
                                    tableRow.setHeight(20);
                                    XSLFTableCell tableCell = tableRow.addCell();//创建表格单元格
                                    XSLFTextParagraph p = tableCell.addNewTextParagraph();
                                    XSLFTextRun tr = p.addNewTextRun();
                                    tr.setBold(true);
                                    if (x == 0) {
                                        tr.setFontSize(10d);
                                        p.setTextAlign(TextParagraph.TextAlign.CENTER);
                                    } else {
                                        tr.setFontSize(10d);
                                    }
                                    tr.setText(String.valueOf(datas[x][y]));
                                    tableCell.setBorderColor(TableCell.BorderEdge.bottom, new Color(134, 134, 134));
                                    tableCell.setBorderColor(TableCell.BorderEdge.top, new Color(134, 134, 134));
                                    tableCell.setBorderColor(TableCell.BorderEdge.left, new Color(134, 134, 134));
                                    tableCell.setBorderColor(TableCell.BorderEdge.right, new Color(134, 134, 134));
                                    StrokeStyle style = new StrokeStyle() {
                                        @Override
                                        public PaintStyle getPaint() {
                                            return null;
                                        }

                                        @Override
                                        public LineCap getLineCap() {
                                            return null;
                                        }

                                        @Override
                                        public LineDash getLineDash() {
                                            return null;
                                        }

                                        @Override
                                        public LineCompound getLineCompound() {
                                            return null;
                                        }

                                        @Override
                                        public double getLineWidth() {
                                            return 0.11d;
                                        }
                                    };
                                    table.setColumnWidth(y, 900 / datas[x].length);
                                }
                            }
                            text = text.replaceAll("\\$\\{" + key + "\\}", "");
                            textShape.setText(text);
                        }
                    }
                }
                if (value == null && key.contains("Img")) {
                    text = text.replaceAll("\\$\\{" + key + "\\}", "");
                    textShape.setText(text);
                }
            }
        }
    }
}
