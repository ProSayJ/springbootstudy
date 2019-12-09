package com.prosayj.springboot;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Calendar.FRIDAY;

/**
 * @author yangjian
 * @description
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/12/7 下午 06:35
 * @since 1.0.0
 */
public class ExcleGen {
    public static final short DEFAULT_FONT_SIZE = (short) 11;
    public static final short HEAD_FONT_SIZE = (short) 20;
    public static final short TEXT_FONT_SIZE = (short) 10;
    private static final List<String> ZBBMLIST = new ArrayList<String>() {{
        add("ZBCRD0002DD");
        add("ZBCRD0001DD");
        add("ZBCRD0019AD");
        add("ZBCRD0003AD");
        add("ZBOIL0001AD");
        add("ZBOIL0005AD");
        add("ZBOIL0009AD");
        add("ZBOIL0024BD");

        add("ZBGAS0075DD");
        add("ZBGAS0002DD");
        add("ZBGAS0358DD");
        add("ZBCHE0007AD");
        add("ZBCHE0009AD");

        //单独的sql2);
        add("ZBCHE0006AD");
    }};

    private static final Map<String, String> KEY_VALUE = new HashMap<String, String>() {{
        put("ZBCRD0002DD", "WTI(美元/桶)");
        put("ZBCRD0001DD", "布伦特(美元/桶)");
        put("ZBCRD0019AD", "阿曼(美元/桶)");
        put("ZBCRD0003AD", "迪拜(美元/桶)");
        put("ZBOIL0001AD", "新加坡汽油(美元/桶)");
        put("ZBOIL0005AD", "新加坡柴油(美元/桶)");
        put("ZBOIL0009AD", "新加坡航煤(美元/桶)");
        put("ZBOIL0024BD", "新加坡石脑油");

        put("ZBGAS0075DD", "Henry Hub(USD/mmbtu )");
        put("ZBGAS0002DD", "东北亚LNG到岸(USD/mmbtu )");
        put("ZBGAS0358DD", "中国LNG出厂价格指数(元/吨)");
        put("ZBCHE0007AD", "苯（FOB韩国）");
        put("ZBCHE0009AD", "对二甲苯（FOB韩国）");

        //单独的sql2
        put("ZBCHE0006AD", "乙烯（CFR东北亚）");


        put("beforeMonthAvg", "上月");
        put("subWithLastWeek", "与上周比");
        put("subWithLastMonth", "与上月比");
    }};

    private static SXSSFWorkbook wb = new SXSSFWorkbook();
    private static SXSSFSheet sheet = null;

    public static void main(String[] args) throws IOException {
        //一：创建表头和表格布局
        SXSSFSheet sheet01 = wb.createSheet("表头和文字");
        createTableHeader(sheet01);

        //二：创建国际市场价格原油表
        SXSSFSheet sheet02 = wb.createSheet("折线图");
        createSheetOil(sheet02);

        //三：油种价格表
//        SXSSFSheet sheet03 = wb.createSheet("油种价格表");
        youzhongjiage(sheet01, 16, 1);

        //四：结算价格预测表格
//        SXSSFSheet sheet04 = wb.createSheet("结算价格预测");
//        jiesuanjiageyuce(sheet04);


        //导出到文件
        //FileOutputStream out = new FileOutputStream(new File("D:/" + System.currentTimeMillis() + ".xlsx"));
        String fileName = "股份公司主要原料及产品价格周报" + DateUtils.formatDataFullSting(DateUtils.getBeforeWeekday(new Date(), FRIDAY)) + "逻辑说明书.xlsx";
        String fileUri = ResourceUtils.getURL("classpath:").getPath() + fileName;
        FileOutputStream out = new FileOutputStream(new File(fileUri));
        wb.write(out);
        out.close();

    }


    private static void youzhongjiage(SXSSFSheet sheet, int startX, int startY) {
        // 模拟获取数据
        List<Map<String, Object>> dataList = mockData03();

        //处理数据生成excle表格
        //处理数据，确定待生成的excle表格有多少行数据
        Map<String, Object> totalDataRows = new HashMap<>();
        dataList.forEach(totalDataRows::putAll);

        //行计数器
        AtomicInteger rowcount = new AtomicInteger(startX);
        //第一行的所有列名的集合。
        List<String> findKeys = new ArrayList<>();
        totalDataRows.forEach((key, value) -> {
            //第几行
            int rowNumber = rowcount.getAndIncrement();
            //第几列
            int columnIndex;
            //第一行为标题行
            if (rowNumber == startX) {
                SXSSFRow rowFirst = sheet.createRow(rowNumber);
                cellNoBorderAndCenter(sheet, rowFirst, false, true, TEXT_FONT_SIZE, IndexedColors.BLACK, startY, "油种");
                cellNoBorderAndCenter(sheet, rowFirst, false, true, TEXT_FONT_SIZE, IndexedColors.BLACK, startY + 1, KEY_VALUE.get("beforeMonthAvg"));
                findKeys.add("油种");
                findKeys.add("beforeMonthAvg");
                //循环赋值有几个（周一~周五）
                List<List<String>> columns = DateUtils.getMondayAndFridayFullMonth(new Date());
                for (int i = 0; i < columns.size(); i++) {
                    cellNoBorderAndCenter(sheet, rowFirst, false, true, TEXT_FONT_SIZE, IndexedColors.BLACK, 2 + startY + i, columns.get(i).get(2));
                    findKeys.add(columns.get(i).get(2));
                }
                columnIndex = columns.size() + 2;
                //判断是否需要"与上周比这一列"
                if (columns.size() > 1) {
                    cellNoBorderAndCenter(sheet, rowFirst, false, true, TEXT_FONT_SIZE, IndexedColors.BLACK, columnIndex + startY, KEY_VALUE.get("subWithLastWeek"));
                    findKeys.add("subWithLastWeek");
                    columnIndex += 1;
                }
                //与上月比
                cellNoBorderAndCenter(sheet, rowFirst, false, true, TEXT_FONT_SIZE, IndexedColors.BLACK, columnIndex + startY, KEY_VALUE.get("subWithLastMonth"));
                findKeys.add("subWithLastMonth");

            } else {
                //数据行渲染
                SXSSFRow rowi = sheet.createRow(rowNumber);
                Map<String, Object> cellDate = (HashMap<String, Object>) value;
                for (int i = 0; i < findKeys.size(); i++) {
                    String cellText;
                    if (i == 0) {
                        cellText = KEY_VALUE.get(key);
                        cellNoBorderAndLeftAndFontIsBlack(sheet, true, TEXT_FONT_SIZE, true, rowi, i + startY, cellText);
                    } else {
                        cellText = cellDate.get(findKeys.get(i)).toString();
                        cellNoBorderAndCenter(sheet, rowi, false, false, TEXT_FONT_SIZE, IndexedColors.BLACK, i + startY, cellText);
                    }

                }
            }

        });
    }

    /**
     * 获取hana数据
     * <p>
     * 注意:返回值说明:
     * 1:list数据结构:一个list代表excle表格中的一行数据.
     * 2:list中的map:key代表指标编码,value为excle中各列数据的key-value形式的数据.
     *
     * @return result
     */
    private static List<Map<String, Object>> mockData03() {
        List<Map<String, Object>> rusult = new ArrayList<>();
        //获取获取周一和周五的时间List
        List<List<String>> mondayAndFridayFullMonth = DateUtils.getMondayAndFridayFullMonth(new Date());
        System.out.println(mondayAndFridayFullMonth);


        //以zbbm为维度，查询各个时间区间的数据,横向渲染表格数据
        for (int i = 0; i < ZBBMLIST.size(); i++) {
            final String zbbm = ZBBMLIST.get(i);

            //上个月的开始时间
            List<String> beforeMonthStartTimeAndEndTime = DateUtils.getBeforeMonthStartTimeAndEndTime(new Date());
            String startTimeBeforeMonth = beforeMonthStartTimeAndEndTime.get(0);
            String endTimeBeforeMonth = beforeMonthStartTimeAndEndTime.get(1);

            //TODO 查询HANA访问hana执行sql,查询上个月的平均值
            String sqlStingBeforeMonth = getQuerySqlSting(zbbm, startTimeBeforeMonth, endTimeBeforeMonth);
//            Map<String, Object> sqlStingBeforeMonthMap = HanaDButilwy.executeQueryForListPublic(sqlStingBeforeMonth, null);
//            List<Map<String, Object>> beforeMonthMap = (List<Map<String, Object>>) sqlStingBeforeMonthMap.get("dataList");


            //mockHanaResult---start
            List<Map<String, Object>> beforeMonthMap = new ArrayList<Map<String, Object>>() {{
                add(new HashMap<String, Object>() {{
                    put("avg", 67);
                }});
            }};
            //mockHanaResult---end


            //保存上月平均值
            Map<String, String> queryResult = new HashMap<>();
            queryResult.put("beforeMonthAvg", beforeMonthMap.get(0).get("avg").toString());


            for (int j = 0; j < mondayAndFridayFullMonth.size(); j++) {
                List<String> list = mondayAndFridayFullMonth.get(j);
                String finalStartTime = list.get(0);
                String finalEndTime = list.get(1);
                String timeTitle = list.get(2);


//                String sqlSting = getQuerySqlSting(zbbm, finalStartTime, finalEndTime);
//                //TODO 查询HANA访问hana执行sql
//                Map<String, Object> map1 = HanaDButilwy.executeQueryForListPublic(sqlSting, null);
//                List<Map<String, Object>> thisMonthMap = (List<Map<String, Object>>) map1.get("dataList");


                //mockHanaResult---start
                List<Map<String, Object>> thisMonthMap = new ArrayList<Map<String, Object>>() {{
                    add(new HashMap<String, Object>() {{
                        //put("avg", 56.90);
                        put("avg", 57);
                    }});
                }};
                //mockHanaResult---end


                //保存周一到周五的平均值
                queryResult.put(timeTitle, thisMonthMap.get(0).get("avg").toString());
                queryResult.put(timeTitle, thisMonthMap.get(0).get("avg") == null ? "" : thisMonthMap.get(0).get("avg").toString());
            }


            String currentTimeTitle = mondayAndFridayFullMonth.get(mondayAndFridayFullMonth.size() - 1).get(2);

            //保存与上周比:
            if (mondayAndFridayFullMonth.size() > 1) {
                String beforeTimeTitle = mondayAndFridayFullMonth.get(mondayAndFridayFullMonth.size() - 2).get(2);
                double subWithLastWeek = Double.valueOf(queryResult.get(currentTimeTitle)) - Double.valueOf(queryResult.get(beforeTimeTitle));
                queryResult.put("subWithLastWeek", Double.toString(subWithLastWeek));

            }

            //保存与上月比
            double subWithLastMonth = Double.valueOf(queryResult.get(currentTimeTitle)) - Double.valueOf(queryResult.get("beforeMonthAvg"));
            queryResult.put("subWithLastMonth", Double.toString(subWithLastMonth));

            //保存zbbm 和该指标编码查询的数据
            rusult.add(new HashMap<String, Object>() {{
                put(zbbm, queryResult);
            }});

        }

        return rusult;

    }

    private static void createTableHeader(SXSSFSheet sheet01) {
        //创建表头
        SXSSFRow row1 = sheet01.createRow(1);
        SXSSFCell headCell = cellNoBorderAndCenter(sheet01, row1, true, true, HEAD_FONT_SIZE, IndexedColors.RED, 1, "股份公司主要原料及产品价格周报");
        // 开始行，结束行，开始列，结束列。
        sheet01.addMergedRegion(new CellRangeAddress(1, 1, 1, 8));
        // 设置列宽
        Integer width = (Integer) getCellInfo(headCell).get("width") / 10 / 2;
        row1.setHeight(width.shortValue());


        //3行1列为表明   3行八列为当前时间的上周五
        SXSSFRow row3 = sheet01.createRow(3);
        cellNoBorderAndLeftAndFontIsBlack(sheet01, true, DEFAULT_FONT_SIZE, true, row3, 1, "中国石化股份财务价格处");
        cellNoBorderAndLeftAndFontIsBlack(sheet01, true, DEFAULT_FONT_SIZE, true, row3, 8, DateUtils.formatDataSting(DateUtils.getBeforeWeekday(new Date(), FRIDAY)));

        SXSSFRow row4 = sheet01.createRow(4);
        cellNoBorderAndLeftAndFontIsBlack(sheet01, false, DEFAULT_FONT_SIZE, true, row4, 1, "一、国际市场价格");


        SXSSFRow row5 = sheet01.createRow(5);
        cellNoBorderAndCenter(sheet01, row5, true, true, TEXT_FONT_SIZE, IndexedColors.BLACK, 1, "国际市场综述");
        sheet01.addMergedRegion(new CellRangeAddress(5, 5, 1, 8));
        SXSSFRow row6 = sheet01.createRow(6);
        //跨5行，8列
        // 开始行，结束行，开始列，结束列。
        sheet01.addMergedRegion(new CellRangeAddress(6, 9, 1, 8));
        cellNoBorderAndLeftAndFontIsBlack(sheet01, true, TEXT_FONT_SIZE, false, row6, 1, "国际市场综述的内容。。。。");


        SXSSFRow row10 = sheet01.createRow(10);
        //跨1行，8列
        sheet01.addMergedRegion(new CellRangeAddress(10, 10, 1, 8));
        cellNoBorderAndCenter(sheet01, row10, true, true, TEXT_FONT_SIZE, IndexedColors.BLACK, 1, "国际原油市场综述");
        SXSSFRow row11 = sheet01.createRow(11);
        //跨5行，8列
        // 开始行，结束行，开始列，结束列。
        sheet01.addMergedRegion(new CellRangeAddress(11, 14, 1, 8));
        cellNoBorderAndLeftAndFontIsBlack(sheet01, true, TEXT_FONT_SIZE, false, row11, 1, "国际原油市场综述。。。。");
    }


    private static String getQuerySqlSting(String zbbm, String startTime, String endTime) {
        if (zbbm.equals("ZBCHE0006AD")) {
            //乙烯CFR东北亚
            return "SELECT\n" +
                    " ROUND(AVG(CASE WHEN KSXNSL <> 0 AND GSJGXL ='N00000006' THEN (KSBJDZ3 + KSBJGZ3) / (2 * KSXNSL) ELSE NULL END)) AS avg --乙烯CFR东北亚\n" +
                    "FROM\n" +
                    " \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_SF020_HGWBSC\"\n" +
                    "WHERE\n" +
                    "GSJGXL ='N00000006'\n" +
                    "and   CALDAY  BETWEEN '" + startTime + "'  AND '" + endTime + "'\n";
        } else {
            return "select avg(value1) as avg \n" +
                    "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                    "zbbm in ('" + zbbm + "')\n" +
                    "--and caltime between '20191104' AND '20191108'\n" +
                    "and caltime between '" + startTime + "'  AND '" + endTime + "'\n" +
                    "and value1<>0";
        }
    }

    private static void createSheetOil(SXSSFSheet sheet03) {
        // 字段名
        List<String> fldNameArr = new ArrayList<String>() {{
            add("value");
            add("value");
            add("value");
            add("value");
        }};
        // 标题
        List<String> titleArr = new ArrayList<String>() {{
            add("类型");
            add("买入");
            add("卖出");
            add("分红");
        }};
        // 模拟数据
        List<Map<String, Object>> dataList = mockData();
        drawSheet3Map(sheet03, "line", fldNameArr, dataList, titleArr);
//        sheet03.getRow(0).setZeroHeight(true);
    }


    //结算价格预测
    private static void jiesuanjiageyuce(SXSSFSheet sheet) {
        //mock数据
        List<Map<String, Object>> dataList = mockData2();
        //处理数据，确定待生产的excle表格有多少行数据
        Map<String, Object> totalData = new HashMap<>();
        dataList.forEach(map -> {
            totalData.putAll(map);
        });

        //设置第一列的列宽
        sheet.setColumnWidth(1, "结算价格预测".getBytes().length * 2 * 256);
        //第一行第一个单元格为标题
        SXSSFRow row0 = sheet.createRow(0);
        row0.createCell(1).setCellValue("二、结算价格预测(元/吨)");
        //第二行空行
        //第三行为表头
        SXSSFRow row2 = sheet.createRow(2);
        cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, row2, 1, "项目");
        cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, row2, 2, "11月");
        cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, row2, 3, "12月预计");
        cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, row2, 4, "环比");

        //行计数器
        AtomicInteger rowcount = new AtomicInteger();
        totalData.forEach((key, value) -> {
            int rowNumber = rowcount.getAndIncrement();
            //第四行开始渲染数据
            SXSSFRow rowi = sheet.createRow(rowNumber + 3);
            Map<String, Object> cellDate = (HashMap<String, Object>) value;
            for (int k = 0; k <= cellDate.size(); k++) {
                int columnIndex = k + 1;
                if (k == 0) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + key + "(" + KEY_VALUE.get(key) + ")");
                    cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, rowi, columnIndex, KEY_VALUE.get(key));
                }
                //上月
                if (k == 1) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("lastMonth"));
                    cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, rowi, columnIndex, cellDate.get("lastMonth").toString());
                }
                //当月
                if (k == 2) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("currMonth"));
                    cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, rowi, columnIndex, cellDate.get("currMonth").toString());

                }
                //环比
                if (k == 3) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("value"));
                    cellHasBorderAndCenterFontIsBlack(sheet, true, DEFAULT_FONT_SIZE, rowi, columnIndex, cellDate.get("value").toString());
                }
            }

        });
    }


    /**
     * 设置合并单元格边框 - 线条
     */
    private static void setBorderStyle(Sheet sheet, CellRangeAddress region) {
        // 合并单元格左边框样式
        RegionUtil.setBorderLeft(BorderStyle.THICK.ordinal(), region, sheet, wb);
        RegionUtil.setLeftBorderColor(IndexedColors.BLUE.getIndex(), region, sheet, wb);

        // 合并单元格上边框样式
        RegionUtil.setBorderTop(BorderStyle.DASH_DOT_DOT.ordinal(), region, sheet, wb);
        RegionUtil.setTopBorderColor(IndexedColors.LIGHT_ORANGE.getIndex(), region, sheet, wb);

        // 合并单元格右边框样式
        RegionUtil.setBorderRight(BorderStyle.SLANTED_DASH_DOT.ordinal(), region, sheet, wb);
        RegionUtil.setRightBorderColor(IndexedColors.RED.getIndex(), region, sheet, wb);

        // 合并单元格下边框样式
        RegionUtil.setBorderBottom(BorderStyle.MEDIUM_DASHED.ordinal(), region, sheet, wb);
        RegionUtil.setBottomBorderColor(IndexedColors.GREEN.getIndex(), region, sheet, wb);
    }

    /**
     * 初始单元格化样式
     *
     * @param sxssfWorkbook
     * @param bold                是否加粗  true 是
     * @param fontSize            字体大小
     * @param fontColor           字体颜色（IndexedColors.BLACK、IndexedColors.RED）
     * @param horizontalAlignment 文字位置(居中还是居左)
     * @return
     */
    private static Map<String, CellStyle> getCellStyle(SXSSFWorkbook sxssfWorkbook, boolean bold, short fontSize, IndexedColors fontColor, HorizontalAlignment horizontalAlignment) {
        Map<String, CellStyle> cellStyleMap = new HashMap<>();

        //表格单元格样式(有边框不加粗)
        CellStyle tableCellHasBorder = sxssfWorkbook.createCellStyle();
        tableCellHasBorder.setAlignment((short) HorizontalAlignment.CENTER.ordinal());
        tableCellHasBorder.setBorderTop((short) BorderStyle.THICK.ordinal());
        tableCellHasBorder.setTopBorderColor(IndexedColors.BLACK.getIndex());
        tableCellHasBorder.setBorderBottom((short) BorderStyle.THICK.ordinal());
        tableCellHasBorder.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        tableCellHasBorder.setBorderLeft((short) BorderStyle.THICK.ordinal());
        tableCellHasBorder.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        tableCellHasBorder.setBorderRight((short) BorderStyle.THICK.ordinal());
        tableCellHasBorder.setRightBorderColor(IndexedColors.BLACK.getIndex());
        //设置单元格背景填充颜色为白色
        tableCellHasBorder.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        tableCellHasBorder.setFillPattern((short) FillPatternType.SOLID_FOREGROUND.ordinal());


        //表格单元格样式(无边框加粗、宋体、黑色、11)
        Font cellFont1 = sxssfWorkbook.createFont();
        cellFont1.setFontHeightInPoints(fontSize);
        cellFont1.setColor(fontColor.getIndex());
        cellFont1.setFontName("宋体");
        //是否是粗体显示
        cellFont1.setBold(bold);
        CellStyle tableCellNoBorderAndOverstriking = sxssfWorkbook.createCellStyle();
        //水平居中左、右或者中
        tableCellNoBorderAndOverstriking.setAlignment((short) horizontalAlignment.ordinal());
        //垂直居中对齐
        tableCellNoBorderAndOverstriking.setVerticalAlignment((short) VerticalAlignment.CENTER.ordinal());
        tableCellNoBorderAndOverstriking.setFont(cellFont1);
        //自动换行
        tableCellNoBorderAndOverstriking.setWrapText(true);


        //表头样式设置(宋体、红色)
        Font headerFont = sxssfWorkbook.createFont();
        headerFont.setFontHeightInPoints(fontSize);
        headerFont.setColor(fontColor.getIndex());
        headerFont.setFontName("宋体");
        //粗体显示
        headerFont.setBold(bold);
        CellStyle headerCellStyle = sxssfWorkbook.createCellStyle();
        //水平居中对齐
        headerCellStyle.setAlignment((short) horizontalAlignment.ordinal());
        //垂直居中对齐
        headerCellStyle.setVerticalAlignment((short) VerticalAlignment.CENTER.ordinal());
        headerCellStyle.setFont(headerFont);
        //自动换行
        headerCellStyle.setWrapText(true);


        //放入容器
        cellStyleMap.put("header", headerCellStyle);
        cellStyleMap.put("tableCellStyle", tableCellHasBorder);
        cellStyleMap.put("tableCellNoBorderAndOverstriking", tableCellNoBorderAndOverstriking);
        return cellStyleMap;
    }


    /**
     * 获取单元格及合并单元格的宽度
     *
     * @param cell
     * @return
     */
    private static Map<String, Object> getCellInfo(SXSSFCell cell) {
        SXSSFSheet sheet = cell.getSheet();
        int rowIndex = cell.getRowIndex();
        int columnIndex = cell.getColumnIndex();


        boolean isPartOfRegion = false;
        int firstColumn = 0;
        int lastColumn = 0;
        int firstRow = 0;
        int lastRow = 0;
        int sheetMergeCount = sheet.getNumMergedRegions();
        for (int i = 0; i < sheetMergeCount; i++) {
            CellRangeAddress ca = sheet.getMergedRegion(i);
            firstColumn = ca.getFirstColumn();
            lastColumn = ca.getLastColumn();
            firstRow = ca.getFirstRow();
            lastRow = ca.getLastRow();
            if (rowIndex >= firstRow && rowIndex <= lastRow) {
                if (columnIndex >= firstColumn && columnIndex <= lastColumn) {
                    isPartOfRegion = true;
                    break;
                }
            }
        }
        Map<String, Object> map = new HashMap<>();
        Integer width = 0;
        Integer height = 0;
        boolean isPartOfRowsRegion = false;
        if (isPartOfRegion) {
            for (int i = firstColumn; i <= lastColumn; i++) {
                width += sheet.getColumnWidth(i);
            }
            for (int i = firstRow; i <= lastRow; i++) {
                height += sheet.getRow(i).getHeight();
            }
            if (lastRow > firstRow) {
                isPartOfRowsRegion = true;
            }
        } else {
            width = sheet.getColumnWidth(columnIndex);
            height += cell.getRow().getHeight();
        }
        map.put("isPartOfRowsRegion", isPartOfRowsRegion);
        map.put("firstRow", firstRow);
        map.put("lastRow", lastRow);
        map.put("width", width);
        map.put("height", height);
        return map;
    }

    /**
     * 设置指定的行指定的列填充的文本，并设置样式： 居中、字体是黑色
     *
     * @param sheet
     * @param bold        是否加粗  true 是
     * @param fontSize    字体大小
     * @param row         行
     * @param columnIndex 列
     * @param string      填充内容
     */
    private static void cellHasBorderAndCenterFontIsBlack(SXSSFSheet sheet, boolean bold, short fontSize, SXSSFRow row, int columnIndex, String string) {
        SXSSFCell cell0 = row.createCell(columnIndex);
        cell0.setCellValue(string);
        cell0.setCellStyle(getCellStyle(wb, bold, fontSize, IndexedColors.BLACK, HorizontalAlignment.CENTER).get("tableCellStyle"));
        sheet.setColumnWidth(columnIndex, string.getBytes().length * 2 * 256);
//        sheet.setColumnWidth(columnIndex, string.getBytes().length * 2 + 40);
    }


    /**
     * 设置指定的行指定的列填充的文本，并设置样式：没有边框、文字居左、黑色
     * <p>
     * 无边框、文字居左
     *
     * @param row         行
     * @param bold        是否加粗  true 是
     * @param autoWide    是否按按照填充数据自适应宽度  true 是
     * @param columnIndex 列
     * @param string      填充内容
     */
    private static void cellNoBorderAndLeftAndFontIsBlack(SXSSFSheet sheet, boolean bold, short fontSize, boolean autoWide, SXSSFRow row, int columnIndex, String string) {
        SXSSFCell cell0 = row.createCell(columnIndex);
        cell0.setCellValue(string);
        cell0.setCellStyle(getCellStyle(wb, bold, fontSize, IndexedColors.BLACK, HorizontalAlignment.LEFT).get("tableCellNoBorderAndOverstriking"));
        if (autoWide) {
            sheet.setColumnWidth(columnIndex, string.getBytes().length * 400);
        }
    }


    /**
     * 设置指定的行指定的列填充的文本，并设置样式：
     * <p>
     * 无边框、文字居中
     *
     * @param row
     * @param bold
     * @param fontSize
     * @param columnIndex
     * @param string
     * @return
     */
    private static SXSSFCell cellNoBorderAndCenter(SXSSFSheet sheet, SXSSFRow row, boolean bold, boolean autoWide, short fontSize, IndexedColors fontColor, int columnIndex, String string) {
        SXSSFCell cell = row.createCell(columnIndex);
        cell.setCellValue(string);
        CellStyle header = getCellStyle(wb, bold, fontSize, fontColor, HorizontalAlignment.CENTER).get("header");
        cell.setCellStyle(header);
        if (autoWide) {
            sheet.setColumnWidth(columnIndex, string.getBytes().length * 256 + 20);
        }
        return cell;
    }

    /**
     * 生成折线图
     *
     * @param sheet      页签
     * @param type       类型:line=普通折线图,line-bar=折线+柱状图
     * @param fldNameArr X轴标题
     * @param dataList   填充数据
     * @param titleArr   图例标题
     * @return
     */
    private static boolean drawSheet3Map(SXSSFSheet sheet, String type, List<String> fldNameArr,
                                         List<Map<String, Object>> dataList, List<String> titleArr) {
        // 获取sheet名称
        String sheetName = sheet.getSheetName();
        drawSheet0Table(sheet, titleArr, fldNameArr, dataList);
        // 创建一个画布
        Drawing drawing = sheet.createDrawingPatriarch();
        // 画一个图区域
        /**
         * 第五个参数：图表左上开始x轴
         * 第六个参数：图表图表左上开始y轴
         * 第七个参数：图表的x轴宽度
         * 第八个参数：图表y轴高度
         */
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 8, 25);
        // 创建一个chart对象
        Chart chart = drawing.createChart(anchor);
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        if (type.equals("line-bar")) {
            CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
            CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
            ctBarChart.getVaryColors().setVal(true);
            // 设置类型
            ctBarChart.addNewGrouping().setVal(STBarGrouping.CLUSTERED);
            ctBoolean.setVal(true);
            ctBarChart.addNewBarDir().setVal(STBarDir.COL);
            // 是否添加左侧坐标轴
            ctChart.addNewDispBlanksAs().setVal(STDispBlanksAs.ZERO);
            ctChart.addNewShowDLblsOverMax().setVal(true);
            // 创建序列,并且设置选中区域
            for (int i = 0; i < fldNameArr.size() - 1; i++) {
                CTBarSer ctBarSer = ctBarChart.addNewSer();
                CTSerTx ctSerTx = ctBarSer.addNewTx();
                // 图例区
                CTStrRef ctStrRef = ctSerTx.addNewStrRef();
                // 选定区域第0行,第1,2,3列标题作为图例 //1 2 3
                String legendDataRange = new CellRangeAddress(0, 0, i + 1, i + 1).formatAsString(sheetName, true);
                ctStrRef.setF(legendDataRange);
                ctBarSer.addNewIdx().setVal(i);
                // 横坐标区
                CTAxDataSource cttAxDataSource = ctBarSer.addNewCat();
                ctStrRef = cttAxDataSource.addNewStrRef();
                // 选第0列,第1-6行作为横坐标区域
                String axisDataRange = new CellRangeAddress(1, dataList.size(), 0, 0).formatAsString(sheetName, true);
                ctStrRef.setF(axisDataRange);
                // 数据区域
                CTNumDataSource ctNumDataSource = ctBarSer.addNewVal();

                CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
                // 选第1-6行,第1-3列作为数据区域 //1 2 3
                String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName, true);
                System.out.println(numDataRange);
                ctNumRef.setF(numDataRange);
                ctBarSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});
                // 设置负轴颜色不是白色
                ctBarSer.addNewInvertIfNegative().setVal(false);
                // 设置标签格式
                ctBoolean.setVal(false);
                CTDLbls newDLbls = ctBarSer.addNewDLbls();
                newDLbls.setShowLegendKey(ctBoolean);
                ctBoolean.setVal(true);
                newDLbls.setShowVal(ctBoolean);
                ctBoolean.setVal(false);
                newDLbls.setShowCatName(ctBoolean);
                newDLbls.setShowSerName(ctBoolean);
                newDLbls.setShowPercent(ctBoolean);
                newDLbls.setShowBubbleSize(ctBoolean);
                newDLbls.setShowLeaderLines(ctBoolean);
            }
            // telling the BarChart that it has axes and giving them Ids
            ctBarChart.addNewAxId().setVal(123456);
            ctBarChart.addNewAxId().setVal(123457);
            // cat axis
            CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
            ctCatAx.addNewAxId().setVal(123456); // id of the cat axis
            CTScaling ctScaling = ctCatAx.addNewScaling();
            ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
            ctCatAx.addNewAxPos().setVal(STAxPos.B);
            ctCatAx.addNewCrossAx().setVal(123457); // id of the val axis
            ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
            // val axis
            CTValAx ctValAx = ctPlotArea.addNewValAx();
            ctValAx.addNewAxId().setVal(123457); // id of the val axis
            ctScaling = ctValAx.addNewScaling();
            ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
            ctValAx.addNewAxPos().setVal(STAxPos.L);
            ctValAx.addNewCrossAx().setVal(123456); // id of the cat axis
            ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        }
        // 折线图
        CTLineChart ctLineChart = ctPlotArea.addNewLineChart();
        CTBoolean ctBoolean = ctLineChart.addNewVaryColors();
        ctLineChart.addNewGrouping().setVal(STGrouping.STANDARD);
        // 创建序列,并且设置选中区域
        for (int i = 0; i < fldNameArr.size() - 1; i++) {
            CTLineSer ctLineSer = ctLineChart.addNewSer();
            CTSerTx ctSerTx = ctLineSer.addNewTx();
            // 图例区
            CTStrRef ctStrRef = ctSerTx.addNewStrRef();
            // 选定区域第0行,第1,2,3列标题作为图例 //1 2 3
            String legendDataRange = new CellRangeAddress(0, 0, i + 1, i + 1).formatAsString(sheetName, true);
            ctStrRef.setF(legendDataRange);
            ctLineSer.addNewIdx().setVal(i);
            // 横坐标区
            CTAxDataSource cttAxDataSource = ctLineSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            // 选第0列,第1-6行作为横坐标区域
            String axisDataRange = new CellRangeAddress(1, dataList.size(), 0, 0).formatAsString(sheetName, true);
            ctStrRef.setF(axisDataRange);
            // 数据区域
            CTNumDataSource ctNumDataSource = ctLineSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
            // 选第1-6行,第1-3列作为数据区域 //1 2 3
            String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName,
                    true);
            System.out.println(numDataRange);
            ctNumRef.setF(numDataRange);
            // 设置标签格式
            ctBoolean.setVal(false);
            CTDLbls newDLbls = ctLineSer.addNewDLbls();
            newDLbls.setShowLegendKey(ctBoolean);
            ctBoolean.setVal(false);//;//设置曲线上是否显示y轴对应的列名称
            newDLbls.setShowVal(ctBoolean);
            ctBoolean.setVal(false);
            newDLbls.setShowCatName(ctBoolean);
            newDLbls.setShowSerName(ctBoolean);
            newDLbls.setShowPercent(ctBoolean);
            newDLbls.setShowBubbleSize(ctBoolean);
            newDLbls.setShowLeaderLines(ctBoolean);
            // 是否是平滑曲线
            CTBoolean addNewSmooth = ctLineSer.addNewSmooth();
            addNewSmooth.setVal(false);
            // 是否是堆积曲线
            CTMarker addNewMarker = ctLineSer.addNewMarker();
            CTMarkerStyle addNewSymbol = addNewMarker.addNewSymbol();
            addNewSymbol.setVal(STMarkerStyle.NONE);
        }
        // telling the BarChart that it has axes and giving them Ids
        ctLineChart.addNewAxId().setVal(123456);
        ctLineChart.addNewAxId().setVal(123457);
        // cat axis
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); // id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); // id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        // val axis
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); // id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); // id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        // 是否删除主左边轴
        ctValAx.addNewDelete().setVal(false);//显示y轴

        // 是否删除横坐标
        ctCatAx.addNewDelete().setVal(false);//显示x轴
        //if (type.equals("line-bar")) {
        //    ctCatAx.addNewDelete().setVal(true);
        //}


        //设置是否显示图例
        //CTLegend ctLegend = ctChart.addNewLegend();
        //ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        //ctLegend.addNewOverlay().setVal(false);
        return true;
    }

    /**
     * 生成数据表
     *
     * @param sheet      sheet页对象
     * @param titleArr   表头字段
     * @param fldNameArr 左边标题字段
     * @param dataList   数据
     * @return 是否生成成功
     */
    private static boolean drawSheet0Table(SXSSFSheet sheet, List<String> titleArr, List<String> fldNameArr,
                                           List<Map<String, Object>> dataList) {
        // 测试时返回值
        boolean result = true;
        // 初始化表格样式
        List<CellStyle> styleList = tableStyle();
        // 根据数据创建excel第一行标题行
        SXSSFRow row0 = sheet.createRow(0);
        for (int i = 0; i < titleArr.size(); i++) {
            // 设置标题
            row0.createCell(i).setCellValue(titleArr.get(i));
            // 设置标题行样式
            row0.getCell(i).setCellStyle(styleList.get(0));
        }
        // 填充数据
        for (int i = 0; i < dataList.size(); i++) {
            // 获取每一项的数据
            Map<String, Object> data = dataList.get(i);
            // 设置每一行的字段标题和数据
            SXSSFRow rowi = sheet.createRow(i + 1);
            for (int j = 0; j < data.size(); j++) {
                // 判断是否是标题字段列
                if (j == 0) {
                    rowi.createCell(j).setCellValue(data.get("calday").toString());
                    // 设置左边字段样式
                    sheet.getRow(i + 1).getCell(j).setCellStyle(styleList.get(0));
                } else {
                    rowi.createCell(j).setCellValue(Double.valueOf(data.get("zbz").toString()));
                    // 设置数据样式
                    sheet.getRow(i + 1).getCell(j).setCellStyle(styleList.get(2));
                }

                //sheet.setColumnHidden(*,true);隐藏列
                //row.setZeroHeight(true);隐藏行
                //rowi.setZeroHeight(true);
            }
        }
        return result;
    }

    private static List<CellStyle> tableStyle() {
        List<CellStyle> cellStyleList = new ArrayList<CellStyle>();
        // 样式准备
        // 标题样式
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        //style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //style.setBorderBottom(BorderStyle.THIN); // 下边框
        //style.setBorderLeft(BorderStyle.THIN);// 左边框
        //style.setBorderTop(BorderStyle.THIN);// 上边框
        //style.setBorderRight(BorderStyle.THIN);// 右边框
        //style.setAlignment(HorizontalAlignment.CENTER);
        cellStyleList.add(style);
        CellStyle style1 = wb.createCellStyle();
        //style1.setBorderBottom(BorderStyle.THIN); // 下边框
        //style1.setBorderLeft(BorderStyle.THIN);// 左边框
        //style1.setBorderTop(BorderStyle.THIN);// 上边框
        //style1.setBorderRight(BorderStyle.THIN);// 右边框
        //style1.setAlignment(HorizontalAlignment.CENTER);
        cellStyleList.add(style1);
        CellStyle cellStyle = wb.createCellStyle();
        //cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
        //cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
        //cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
        //cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
        //cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平对齐方式
        // cellStyle.setVerticalAlignment(VerticalAlignment.TOP);//垂直对齐方式
        cellStyleList.add(cellStyle);
        return cellStyleList;
    }


    //趋势图
    private static List<Map<String, Object>> mockData() {
        List<Map<String, Object>> result = new ArrayList<>();
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191104");
            put("zbz", 62.13);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191101");
            put("zbz", 61.69);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191031");
            put("zbz", 60.23);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191030");
            put("zbz", 60.61);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191029");
            put("zbz", 61.59);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191028");
            put("zbz", 61.57);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191025");
            put("zbz", 62.02);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191024");
            put("zbz", 61.67);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191023");
            put("zbz", 61.17);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191022");
            put("zbz", 59.7);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191021");
            put("zbz", 58.96);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191018");
            put("zbz", 59.42);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191017");
            put("zbz", 59.91);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191016");
            put("zbz", 59.42);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191015");
            put("zbz", 58.74);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191014");
            put("zbz", 59.35);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191011");
            put("zbz", 60.51);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191010");
            put("zbz", 59.1);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191009");
            put("zbz", 58.32);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191008");
            put("zbz", 58.24);
        }});

        result.add(new HashMap<String, Object>() {{
            put("calday", "20191007");
            put("zbz", 58.35);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191004");
            put("zbz", 58.37);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191003");
            put("zbz", 57.71);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191002");
            put("zbz", 57.69);
        }});
        result.add(new HashMap<String, Object>() {{
            put("calday", "20191001");
            put("zbz", 58.89);
        }});
        return result;
    }

    //结算价格预测模拟数据
    private static List<Map<String, Object>> mockData2() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Object> bigNewMap = new HashMap<>();
        //胜利油,
        Map<String, Integer> newMap = new HashMap<>();
        newMap.put("lastMonth", 3298);
        newMap.put("currMonth", 3370);
        //环比=当月-上月
        newMap.put("value", 3370 - 3298);
        bigNewMap.put("ZBOIL0020BD", newMap);

        //航煤,
        Map<String, Integer> newMap2 = new HashMap<>();
        newMap2.put("lastMonth", 5040);
        newMap2.put("currMonth", 5009);
        newMap2.put("value", 5009 - 5040);
        bigNewMap.put("ZBOIL0021BD", newMap2);

        //石脑油
        Map<String, Integer> newMap3 = new HashMap<>();
        newMap3.put("lastMonth", 4030);
        newMap3.put("currMonth", 4138);
        newMap3.put("value", 4138 - 4030);
        bigNewMap.put("ZBOIL0022BD", newMap3);
        result.add(bigNewMap);
        return result;
    }

    //成品油
    private static List<Map<String, Object>> mockData3() {
        List<Map<String, Object>> result = new ArrayList<>();
        Map<String, Integer> newMap = new HashMap<>();
        Map<String, Object> bigNewMap = new HashMap<>();
        //汽油军队价
        newMap.put("lastMonth", 7577);
        newMap.put("currMonth", 7594);
        //与上月比
        newMap.put("value", 7594 - 7577);
        bigNewMap.put("ZBOIL0004BD", newMap);


        //柴油军队价
        newMap.put("lastMonth", 6593);
        newMap.put("currMonth", 6612);
        newMap.put("value", 19);
        bigNewMap.put("ZBOIL0396BD", newMap);

        //汽油新加坡到岸完税价
        newMap.put("lastMonth", 6971);
        newMap.put("currMonth", 7075);
        newMap.put("value", 104);
        bigNewMap.put("ZBOIL0043AD", newMap);

        //柴油新加坡到岸完税价
        newMap.put("lastMonth", 6391);
        newMap.put("currMonth", 6281);
        newMap.put("value", -110);
        bigNewMap.put("ZBOIL0027DD", newMap);
        result.add(bigNewMap);
        return result;
    }
}
