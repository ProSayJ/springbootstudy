package com.prosayj.springboot.poi;

import org.apache.poi.hslf.usermodel.HSLFTable;
import org.apache.poi.hslf.usermodel.HSLFTableCell;
import org.apache.poi.hslf.usermodel.HSLFTextShape;
import org.apache.poi.sl.usermodel.*;
import org.apache.poi.xslf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/15 19:16
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
//        SlideShow slideShow = null;
        File sakuraFile = new File(Main.class.getResource("/data/123.pptx").getFile());
        FileInputStream fileInputStream = new FileInputStream(sakuraFile);

        if (sakuraFile.getName().endsWith(".ppt")) {
        } else if (sakuraFile.getName().endsWith(".pptx")) {
            //幻灯片总页数
            SlideShow slideShow = new XMLSlideShow(fileInputStream);
            if (slideShow != null) {
                // 文本内容
                StringBuilder content = new StringBuilder();
                // 一页一页读取
                List<Slide> slides = slideShow.getSlides();
                for (int j = 0; j < slides.size(); j++) {
                    List shapes = slides.get(j).getShapes();
                    if (shapes != null && j == 4) {
                        for (int i = 0; i < shapes.size(); i++) {
                            Shape shape = (Shape) shapes.get(i);
                            if (shape instanceof HSLFTextShape) {// 文本框
                                String text = ((HSLFTextShape) shape).getText();
                                content.append(text);
                                System.out.println(text);
                            }
                            if (shape instanceof XSLFTextShape) {// 文本框
                                String text = ((XSLFTextShape) shape).getText();
                                content.append(text);
                                System.out.println(text);
                            }
                            if (shape instanceof HSLFTable) {// 表格
                                int rowSize = ((HSLFTable) shape).getNumberOfRows();
                                int columnSize = ((HSLFTable) shape).getNumberOfColumns();
                                for (int rowNum = 0; rowNum < rowSize; rowNum++) {
                                    for (int columnNum = 0; columnNum < columnSize; columnNum++) {
                                        HSLFTableCell cell = ((HSLFTable) shape).getCell(rowNum, columnNum);
                                        if (cell != null) {
                                            String text = cell.getText();
                                            content.append(text);
                                            System.out.println(text);
                                        }
                                    }
                                }
                            }
                            if (shape instanceof XSLFTable) {// 表格
                                int rowSize = ((XSLFTable) shape).getNumberOfRows();
                                int columnSize = ((XSLFTable) shape).getNumberOfColumns();
                                for (int rowNum = 0; rowNum < rowSize; rowNum++) {
                                    for (int columnNum = 0; columnNum < columnSize; columnNum++) {
                                        XSLFTableCell cell = ((XSLFTable) shape).getCell(rowNum, columnNum);
                                        if (cell != null) {
                                            String text = cell.getText();
                                            content.append(text);
                                            System.out.println(text);
                                        }
                                    }
                                }
                            }
                            if (shape instanceof XSLFGraphicFrame) {
//                                ShapeType shapeType = ((XSLFGraphicFrame) shape).getShapeType();
//                                int shapeId = ((XSLFGraphicFrame) shape).getShapeId();
//                                String shapeName = ((XSLFGraphicFrame) shape).getShapeName();
                                XSLFSheet sheet = ((XSLFGraphicFrame) shape).getSheet();
                                XMLSlideShow slideShow1 = sheet.getSlideShow();
                                XSLFNotesMaster notesMaster = slideShow1.getNotesMaster();
                                MasterSheet<XSLFShape, XSLFTextParagraph> masterSheet = notesMaster.getMasterSheet();
                                masterSheet.forEach(data->{
                                    data.getShapeId();
                                });
                            }
                        }
                    }
                    if (content.length() > 0) {
//                        System.out.println(content);
                        content.delete(0, content.length());
                    }
                    // 图片内容
                    List pictures = slideShow.getPictureData();
                    for (int i = 0; i < pictures.size(); i++) {
                        PictureData picture = (PictureData) pictures.get(i);
                        /*
                        byte[] data = picture.getData();
                        FileOutputStream out = new FileOutputStream("D:\\temp\\temp\\" + UUID.randomUUID() + ".jpg");
                        out.write(data);
                        out.close();
                        */
                    }
                }
            }
        }

    }


      /*  if (sakuraFile.getName().endsWith(".ppt")) {
            slideShow = new HSLFSlideShow(fileInputStream);
        } else if (sakuraFile.getName().endsWith(".pptx")) {
            slideShow = new XMLSlideShow(fileInputStream);
        }


        SlideShow xmlSlideShow = new XMLSlideShow(fileInputStream);
        XSLFSlide[] slides = xmlSlideShow.getSlides();
        for (int i = 0; i < slides.length; i++) {
            if (i == 2) {
                XSLFSlide slide = slides[i];
                String title = slide.getTitle();
                XSLFBackground background = slide.getBackground();
                XSLFComments comments = slide.getComments();
                boolean followMasterGraphics = slide.getFollowMasterGraphics();
                XSLFSlideLayout masterSheet = slide.getMasterSheet();
                XSLFNotes notes = slide.getNotes();
                XSLFSlideLayout slideLayout = slide.getSlideLayout();
                XSLFSlideMaster slideMaster = slide.getSlideMaster();
                XSLFTheme theme = slide.getTheme();
                CTSlide xmlObject = slide.getXmlObject();
                System.out.println(xmlObject.toString());
            }
        }

        Dimension pageSize = xmlSlideShow.getPageSize();
        Dimension size = pageSize.getSize();
        System.out.println(size.toString());

*/
}
