package com.prosayj.springboot.test;

import org.apache.poi.hslf.record.Slide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.sl.usermodel.SlideShow;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/20 14:34
 * @since 1.0.0
 */
public class FileUtils {
    private static POIFSFileSystem fs;
    private static HSSFWorkbook wb;
    private static HSSFSheet sheet;
    private static HSSFRow row;

    /**
     * 读取Excel表格表头的内容
     * @param
     * @return String 表头内容的数组
     */
    public static String[] readExcelTitle(String filePath) {
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        row = sheet.getRow(0);
        // 标题总列数
        int colNum = row.getPhysicalNumberOfCells();
        System.out.println("colNum:" + colNum);
        String[] title = new String[colNum];
        for (int i = 0; i < colNum; i++) {
            //title[i] = getStringCellValue(row.getCell((short) i));
            title[i] = getCellFormatValue(row.getCell((short) i));
        }
        return title;
    }

    /**
     * 读取Excel数据内容
     * @param
     * @return Map 包含单元格数据内容的Map对象
     */
    public static Map readExcelContent(String filePath) {
        InputStream is = null;
        Map content = new HashMap();
        String str = "";
        try {
            is = new FileInputStream(filePath);
            fs = new POIFSFileSystem(is);
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = wb.getSheetAt(0);
        // 得到总行数
        int rowNum = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int colNum = row.getPhysicalNumberOfCells();
        // 正文内容应该从第二行开始,第一行为表头的标题
        for (int i = 1; i <= rowNum; i++) {
            row = sheet.getRow(i);
            int j = 0;
            while (j < colNum) {
                // 每个单元格的数据内容用"-"分割开，以后需要时用String类的replace()方法还原数据
                // 也可以将每个单元格的数据设置到一个javabean的属性中，此时需要新建一个javabean
                // str += getStringCellValue(row.getCell((short) j)).trim() +
                // "-";
                str += getCellFormatValue(row.getCell((short) j)).trim() + "    ";
                j++;
            }
            content.put(i, str);
            str = "";
        }
        return content;
    }


    /**
     * 根据HSSFCell类型设置数据
     * @param cell
     * @return
     */
    private static String getCellFormatValue(HSSFCell cell) {
        String cellvalue = "";
        if (cell != null) {
            // 判断当前Cell的Type
            switch (cell.getCellType()) {
                // 如果当前Cell的Type为NUMERIC
                case HSSFCell.CELL_TYPE_NUMERIC:
                case HSSFCell.CELL_TYPE_FORMULA: {
                    // 判断当前的cell是否为Date
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        // 如果是Date类型则，转化为Data格式

                        //方法1：这样子的data格式是带时分秒的：2011-10-12 0:00:00
                        //cellvalue = cell.getDateCellValue().toLocaleString();

                        //方法2：这样子的data格式是不带带时分秒的：2011-10-12
                        Date date = cell.getDateCellValue();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        cellvalue = sdf.format(date);

                    }
                    // 如果是纯数字
                    else {
                        // 取得当前Cell的数值
                        cellvalue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                // 如果当前Cell的Type为STRIN
                case HSSFCell.CELL_TYPE_STRING:
                    // 取得当前的Cell字符串
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                // 默认的Cell值
                default:
                    cellvalue = " ";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;

    }

    public static String readPPT(String filePath) {
        String str = "";
        InputStream is = null;
//            PowerPointExtractor extractor = null;
        try {
            is = new FileInputStream(filePath);
            SlideShow ss = new SlideShow(new HSLFSlideShow(is));
            Slide[] slides = ss.getSlides();
            for (int i = 0; i paras = doc.getParagraphs();
            for (XWPFParagraph para : paras) {
                //当前段落的属性
                str = str + para.getText();
            }
            //获取文档中所有的表格
            List tables = doc.getTables();
            List rows;
            List cells;
            for (XWPFTable table : tables) {
                //获取表格对应的行
                rows = table.getRows();
                for (XWPFTableRow row : rows) {
                    //获取行对应的单元格
                    cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        str = str + cell.getText();
                    }
                }
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }
    public static String readXls(String filePath) {
        Map content = readExcelContent(filePath);
        String[] title = readExcelTitle(filePath);
        String str = "";
        for (int index = 0; index < title.length; index++) {
            str += title[index];
        }
        content.keySet().forEach(keys->{
            str = str + content.get(keys);
        }});
       /* Iterator iterator = content.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry map = iterator.next();
            String value = map.getValue();
            str = str + value;
        }*/
        return str;
    }
    public static String readXlsx(String filePath ) {
        String str = "";
        try{
            InputStream is = new FileInputStream(filePath);
            // 构造 XSSFWorkbook 对象，strPath 传入文件路径
            XSSFWorkbook xwb = new XSSFWorkbook(is);
            // 读取第一章表格内容
            XSSFSheet sheet = xwb.getSheetAt(0);
            // 定义 row、cell
            XSSFRow row;
            String cell;
            // 循环输出表格中的内容
            for (int i = sheet.getFirstRowNum()+1; i < sheet.getPhysicalNumberOfRows(); i++) {
                row = sheet.getRow(i);
                for (int j = row.getFirstCellNum(); j < row.getPhysicalNumberOfCells(); j++) {
                    // 通过 row.getCell(j).toString() 获取单元格内容，
                    cell = row.getCell(j).toString();
                    str = str+cell;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("已运行xlRead() : " + e );
        }finally {
            return str;
        }
}
