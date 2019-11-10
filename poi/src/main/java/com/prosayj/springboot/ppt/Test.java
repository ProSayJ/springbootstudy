package com.prosayj.springboot.ppt;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hslf.model.OLEShape;
import org.apache.poi.hslf.record.ExOleObjStg;
import org.apache.poi.hslf.usermodel.HSLFObjectData;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFSlideShowImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Shape;
import org.apache.poi.sl.usermodel.Slide;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static void main(String[] args) throws IOException {
        //把ppt文件放到resource文件夹下即可
        URL resource = Thread.currentThread().getContextClassLoader().getResource("Historic2019-PPT.ppt");
        File pptFile = new File(resource.getPath());
        String extension = FilenameUtils.getExtension(pptFile.getName());
        if (StringUtils.equalsIgnoreCase("ppt", extension)) {
            //Office2003版文件处理
            SlideShow slideShow = new HSLFSlideShow(new HSLFSlideShowImpl(pptFile.getCanonicalPath()));
            if (slideShow != null) {
                List slides = slideShow.getSlides();
                for (int i = 0; i < slides.size(); i++) {
                    Slide slide = (Slide) slides.get(i);
                    if (slide != null) {
                        List shapes = slide.getShapes();
                        for (int z = 0; z < shapes.size(); z++) {
                            Shape shapeInner = (Shape) shapes.get(z);
                            if (shapeInner != null && z != 0) {
                                //https://www.iteye.com/problems/97150
                                if (shapeInner instanceof OLEShape) {
                                    OLEShape oleShape = (OLEShape) shapeInner;
                                    //getExOleObjStg(oleShape);
                                    //getObjectData(oleShape);
                                    getObjectDataAndDealDate(oleShape);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void getObjectData(OLEShape oleShape) throws IOException {
        AtomicInteger targetSize = new AtomicInteger(0);
        HSLFObjectData objectData = oleShape.getObjectData();
        InputStream inputStreamDate = objectData.getData();
        HSSFWorkbook wb = new HSSFWorkbook(inputStreamDate);
        StringBuffer stringBuffer = new StringBuffer();
        wb.forEach(sheets -> {
            ////只获取第二页的excle数据
            if (targetSize.getAndIncrement() == 1) {
                sheets.forEach(rows -> {
                    rows.forEach(cell -> {
                        stringBuffer.append(cell.toString()).append("    ");
                    });
                    System.out.println(stringBuffer.toString());
                    stringBuffer.delete(0, stringBuffer.length());
                });
            }
        });
    }

    private static void getObjectDataAndDealDate(OLEShape oleShape) throws IOException {
        List<String> result = new ArrayList<>();
        HSLFObjectData objectData = oleShape.getObjectData();
        InputStream inputStreamDate = objectData.getData();
        HSSFWorkbook wb = new HSSFWorkbook(inputStreamDate);
        //获取第二页excel
        HSSFSheet sheetAt = wb.getSheetAt(1);
        //获取该eccle的总行数
        int lastRowNum = sheetAt.getLastRowNum();
        //第二行开始遍历(应为excel表格中第一行是标题行：如：Chemical Activity Barometer Recession)
        for (int i = 1; i <= lastRowNum; i++) {
            //第n + 1行
            HSSFRow row = sheetAt.getRow(i);
            //获得第(n + 1)行的第一个单元格
            HSSFCell firstCell = row.getCell(0);
            //获得第(n + 1)行的第二个单元格
            HSSFCell secondCell = row.getCell(1);
            //收集数据
            result.add(firstCell + "-" + secondCell);
        }
        //处理数据
        dealData(result);


    }

    private static void dealData(List<String> result) {
        //年
        String year = "";
        //月(12个月一个周期)
        int month = 0;
        for (int i = 0; i < result.size(); i++) {
            //月++
            month++;
            String value = result.get(i).split("-")[1];
            //表数据归路12个月会有一个年
            if ((i % 12) == 0) {
                year = result.get(i).split("-")[0];
            }
            Double yearDouble = Double.valueOf(year.toString());
            if (yearDouble < 100 && yearDouble > 47) {
                System.out.println("19" + autoGenericCode(yearDouble.intValue()) + autoGenericCode(month) + "   " + value);
            } else if (yearDouble < 47) {
                System.out.println("20" + autoGenericCode(yearDouble.intValue()) + autoGenericCode(month) + "   " + value);
            }
            //月计数器清零
            if (month % 12 == 0) {
                month = 0;
            }
        }
    }

    /**
     * 月不够位数的在前面补0，
     *
     * @param
     * @return
     */
    private static String autoGenericCode(int monthOrYear) {
        return String.valueOf(monthOrYear).length() < 2 ? "0" + monthOrYear : String.valueOf(monthOrYear);
    }


    private static void getExOleObjStg(OLEShape oleShape) throws IOException {
        HSLFObjectData objectData = oleShape.getObjectData();
        ExOleObjStg exOleObjStg = objectData.getExOleObjStg();
        InputStream inputStreamDate = exOleObjStg.getData();
        HSSFWorkbook wb = new HSSFWorkbook(inputStreamDate);
        Iterator<Sheet> sheetIterator = wb.sheetIterator();
        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            //遍历行row
            for (int rownum = 0; rownum <= sheet.getLastRowNum(); rownum++) {
                Row sheetRow = sheet.getRow(rownum);
                if (sheetRow == null) {
                    continue;
                }
                //遍历列cell
                for (int cellnum = 0; cellnum <= sheetRow.getLastCellNum(); cellnum++) {
                    Cell cell = sheetRow.getCell(cellnum);
                    if (cell == null) {
                        continue;
                    }
                    System.out.print(" " + getValue(cell));
                }
            }
        }
    }

    private static String getValue(Cell hssfCell) {
        if (hssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return String.valueOf(hssfCell.getBooleanCellValue());
        } else if (hssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            return String.valueOf(hssfCell.getNumericCellValue());
        } else {
            return String.valueOf(hssfCell.getStringCellValue());
        }
    }
}