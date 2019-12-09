package com.prosayj.springboot;//import com.prosayj.springboot.test.excle.DateUtils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.openxmlformats.schemas.drawingml.x2006.chart.*;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * java利用poi生成excel图表
 *
 * @author chen
 */
@Component
public class ExcelChartUtil3 {
    private static SXSSFWorkbook wb = new SXSSFWorkbook();
    private static SXSSFSheet sheet = null;
//    @Autowired
//    private static PeriodValuationService periodValuationService;
//    @Autowired
//    private static FirstPageService firstPageService;

    public static void main(String[] args) throws Exception {

        //创建图表
        //createCharPic();
        //int lastRowNum = sheet.getLastRowNum();
        //sheet.shiftRows(1, lastRowNum, -1);//删除第一行到第四行，然后使下方单元格上移

        //一.创建国际市场价格原油表
        createSheetOil();

        //二.结算价格预测
        forecastFuturePrice();

        //三、主要产品价格(元/吨)
        //majorPrice();
        //导出到文件
        FileOutputStream out = new FileOutputStream(new File("D:/" + System.currentTimeMillis() + ".xlsx"));
        wb.write(out);
        out.close();
    }

    private static void majorPrice() {
        chengpinyou();
        huagong();
        lianyou();
    }

    //3.炼油自销产品
    private static void lianyou() {
    }

    //2.化工产品
    private static void huagong() {
    }

    //1.成品油
    private static void chengpinyou() {

        mockData3();
  /*      //汽油军队价本月截止
        //柴油军队价 ZBOIL0396BD
        String qiyouCurrjundui = "select avg(value1) \n" +
                "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                "zbbm in ('ZBOIL0004BD')\n" +
                "--and caltime between '20191104' AND '20191108'\n" +
                "and caltime between '20191101' AND '20191129'\n --本月截止" +
                "and value1<>0\n";
        //汽油军队价上月
        String qiyouLastjundui = "select avg(value1) \n" +
                "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                "zbbm in ('ZBOIL0004BD')\n" +
                "--and caltime between '20191104' AND '20191108'\n" +
                "and caltime between '20191001' AND '20191031'\n --上月" +
                "and value1<>0\n";

        //汽油新加坡到岸完税价 本月截止
        //柴油新加坡到岸完税价  ZBOIL0027DD
        String qiyouCurrSingPrice = "select avg(value1)-50\n" +
                "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                "zbbm in ('ZBOIL0043AD')\n" +
                "--and caltime between '20191104' AND '20191108'\n" +
                "and caltime between '20191101' AND '20191129'\n --本月截止" +
                "and value1<>0\n";
        //汽油新加坡到岸完税价上月
        String qiyouLastSingPrice = "select avg(value1)-50\n" +
                "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                "zbbm in ('ZBOIL0043AD')\n" +
                "--and caltime between '20191104' AND '20191108'\n" +
                "and caltime between '20191001' AND '20191031'\n--上月" +
                "and value1<>0\n";*/
    }

    private static void forecastFuturePrice() {

     /*
        List<Map<String, Object>> list =  new ArrayList<>();
        Map<String, Object> newMap = new HashMap<>();
        Map<String, Object> bigNewMap = new HashMap<>();
        String zbbms = "ZBOIL0020BD,ZBOIL0021BD,ZBOIL0022BD";//胜利油,航煤,石脑油
        String[] zbbm = zbbms.split(",");
        String lastMonth = "";
        String currMonth = "";
        for (String oilName : zbbm) {
            try {
                //根据油种名称查询价格
                Map<String, Object> map = QueryPrice(oilName);
                Map<String, Object> zboil0020BD = (Map<String, Object>) map.get("ZBOIL0020BD");
                lastMonth = String.valueOf(zboil0020BD.get("shangqi"));
                currMonth = String.valueOf(zboil0020BD.get("currPrice"));

            } catch (Exception e) {
            }
        }
        list.add(bigNewMap);
        */

        //mock数据
        List<Map<String, Object>> dataList = mockData2();
        //处理数据，确定待生产的excle表格有多少行数据
        Map<String, Object> totalData = new HashMap<>();
        dataList.forEach(map -> {
            totalData.putAll(map);
        });


        //创建一个excle的sheet页
        SXSSFSheet sheet02 = wb.createSheet("结算价格预测");

        //第一行第一个单元格为标题
        SXSSFRow row0 = sheet02.createRow(0);
        row0.createCell(0).setCellValue("二、结算价格预测(元/吨)");

        //行计数器
        AtomicInteger count = new AtomicInteger();
        totalData.forEach((key, value) -> {
            int rowNumber = count.getAndIncrement();
            SXSSFRow rowi = sheet02.createRow(rowNumber + 2);
            Map<String, Object> cellDate = (HashMap<String, Object>) value;
            for (int k = 0; k <= cellDate.size(); k++) {
                if (k == 0) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + key);
                    rowi.createCell(k).setCellValue(key);
                }
                if (k == 1) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("lastMonth"));
                    rowi.createCell(k).setCellValue(cellDate.get("lastMonth").toString());
                }
                if (k == 2) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("value"));
                    rowi.createCell(k).setCellValue(cellDate.get("value").toString());
                }
                if (k == 3) {
                    System.out.println("第" + rowi.getRowNum() + "行，第" + k + "个单元填充数据，值为：" + cellDate.get("currMonth"));
                    rowi.createCell(k).setCellValue(cellDate.get("currMonth").toString());
                }
            }

        });
    }

    /**
     * <p>方法描述: 计价期当前结算价格预测查询方法</p>
     * <p>方法备注: </p>
     *
     * @return 结果
     * <p>创建人：wangying</p>
     */
//    private static Map<String, Object> QueryPrice(String oilnames) throws ParseException {
//        boolean f = false;
//        Map<String, Object> map = new HashMap<>();
//        int dValue = 0;
//        Map<String, Object> map1 = new HashMap<>();
//        //当前月份与油种查询
//        ValuationPeriodDto v1 = periodValuationService.getstartTime(com.sinopec.fpms.platform.util.DateUtil.date2String(new Date()), oilnames);
//
//        if (v1 == null) {
//            //查询最近一条数据
////    	                        ValuationPeriodDto zjData = periodValuationService.getTime(v.getOilName());
//            v1 = periodValuationService.getTime(oilnames);
//            v1.setName(com.sinopec.fpms.platform.util.DateUtil.getOffsetTime2String(new SimpleDateFormat("yyyyMM").parse(v1.getName()), "yyyyMM", 1));
//            v1.setStartTime(com.sinopec.fpms.platform.util.DateUtil.getOffsetTime2String(new SimpleDateFormat("yyyyMMdd").parse(v1.getStartTime()), "yyyyMMdd", 1));
//            v1.setEndTime(DateUtil.getOffsetTime2String(new SimpleDateFormat("yyyyMMdd").parse(v1.getEndTime()), "yyyyMMdd", 1));
//            periodValuationService.saveJq(v1);
//        }
//        FormulaBaseData.getCalculateResult(v1, firstPageService);
//        if (v1.getCalculateResult() == 0) {
//            f = true;
//            String beforeDay = DateOperateUtil.getOffsetTime2String(new Date(), "yyyyMMdd", DateOperateUtil.OffsetDateType.MONTH, -1);
//            //上月月份与油种查询
//            v1 = periodValuationService.getstartTime(beforeDay, oilnames);
//            FormulaBaseData.getCalculateResult(v1, firstPageService);
//        }
//        if (v1.getOilName().equalsIgnoreCase("汽油标准品")
//                || v1.getOilName().equalsIgnoreCase("柴油标准品")) {
//            map.put("currPrice", v1.getSettlementPrice());
//        } else {
//            map.put("currPrice", v1.getCalculateResult());
//        }
//        map.put("exMonth", v1.getEmonth());
//        map.put("startTime", v1.getStartTime());
//        map.put("endTime", v1.getEndTime());
//        String beforeDay = "";
//        if (f) {
//            //上月
//            beforeDay = DateOperateUtil.getOffsetTime2String(new Date(), "yyyyMMdd", DateOperateUtil.OffsetDateType.MONTH, -2);
//
//        } else {
//            beforeDay = DateOperateUtil.getOffsetTime2String(new Date(), "yyyyMMdd", DateOperateUtil.OffsetDateType.MONTH, -1);
//        }
//        //上月月份与油种查询
//        ValuationPeriodDto v2 = periodValuationService.getstartTime(beforeDay, oilnames);
//        if (v2 != null) {
//            if (v1.getOilName().equalsIgnoreCase("汽油标准品")
//                    || v1.getOilName().equalsIgnoreCase("柴油标准品")) {
//                dValue = v1.getSettlementPrice().intValue() - v2.getSettlementPrice().intValue();
//            } else {
//                FormulaBaseData.getCalculateResult(v2, firstPageService);
//                dValue = v1.getCalculateResult() - v2.getCalculateResult();
//            }
//            map.put("shangqi", v2.getCalculateResult());
//        } else {
//            dValue = v1.getCalculateResult();
//            map.put("shangqi", 0);
//        }
//
//        map.put("linkRelative", dValue);
//        map.put("f", f);
//        map1.put(zbbmMapping().get(v1.getOilName()), map);
//        return map1;
//    }
    private static Map<String, String> zbbmMapping() {
        Map<String, String> zbbmMap = new HashMap<>();
        {
            zbbmMap.put("胜利油", "ZBOIL0020BD");
            zbbmMap.put("航煤", "ZBOIL0021BD");
            zbbmMap.put("石脑油", "ZBOIL0022BD");
            zbbmMap.put("重油", "ZBOIL0023BD");
            zbbmMap.put("汽油标准品", "ZBOIL0024BD");//还需调整编码（关键）
            zbbmMap.put("柴油标准品", "ZBOIL0025BD");
        }
        return zbbmMap;
    }

    private static void createSheetOil() throws Exception {
        //[20191125, 20191129, 25日-29日]
        List<List<String>> mondayAndFridayFullMonth = DateUtils.getMondayAndFridayFullMonth(new Date());

        for (int i = 0; i < mondayAndFridayFullMonth.size(); i++) {
            List<String> list = mondayAndFridayFullMonth.get(i);
            String finalStartTime = list.get(0);
            String finalEndTime = list.get(1);
            String time = list.get(2);


            ZBBMList.forEach(zbbm -> {
                String sqlSting = getQuerySqlSting(zbbm, finalStartTime, finalEndTime);
                //TODO 查询HANA
                //TODO 组装excle数据
                //TODO 生成excle

            });


        }

//        String startTime = list.get(0);//开始时间（周一）20191125
//        String endTime = list.get(1);//结束时间（周五）20191129
//        String time = list.get(2);//单元格表头时间 25日-29日


        //访问hana执行sql
//        Map<String, Object> map1 = HanaDButilwy.executeQueryForListPublic(sql, null);
//        List<Map<String, Object>> array = (List<Map<String, Object>>) map1.get("dataList");

        List<Map<String, Object>> array = mockData();

        List<Map<String, Object>> dataList1 = new ArrayList<Map<String, Object>>() {{
            Map<String, Object> dataMap = new HashMap<String, Object>() {{
                put("time", "上月");
                put("zbbm", "wti");
                put("data", "54.01");
            }};
            add(dataMap);
        }};
        //更新Excel表格每一列的数据
        //sheet.getRow(0).getCell(0).setCellValue("haohaohao");

    }


    private static String getQuerySqlSting(String zbbm, String startTime, String endTime) {
        if (zbbm.equals("yx")) {
            //乙烯CFR东北亚
            return "SELECT\n" +
                    " ROUND(AVG(CASE WHEN KSXNSL <> 0 AND GSJGXL ='N00000006' THEN (KSBJDZ3 + KSBJGZ3) / (2 * KSXNSL) ELSE NULL END)) AS PJJW2 --乙烯CFR东北亚\n" +
                    "FROM\n" +
                    " \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_SF020_HGWBSC\"\n" +
                    "WHERE\n" +
                    "GSJGXL ='N00000006'\n" +
                    "and   CALDAY  BETWEEN '" + startTime + "'  AND '" + endTime + "'\n";
        } else {
            return "select avg(value1) \n" +
                    "from \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" where \n" +
                    "zbbm in ('" + zbbm + "')\n" +
                    "--and caltime between '20191104' AND '20191108'\n" +
                    "and caltime between '" + startTime + "'  AND '" + endTime + "'\n" +
                    "and value1<>0";
        }
    }

    private static void createCharPic() throws Exception {
        // 字段名
        List<String> fldNameArr = new ArrayList<String>() {{
            add("calday");
            add("zbz");
        }};
        // 标题
        List<String> titleArr = new ArrayList<String>() {{
            //add("布伦特期货");
            //add(0,"布伦特期货");
            //add("买入");
            //add("卖出");
            //add("分红");
        }};
        // 模拟数据
        String end = DateUtils.getEndFriday();
        String start = "20191001";
        String sql1 = "SELECT \"CALDAY\",---日\n" +
                "ROUND(AVG(\"VALUE1\"),4) as ZBZ --指标值\n" +
                "FROM \"_SYS_BIC\".\"SINOPEC.ZBYY.CWYY.002_JGDSJFX/H1AS_ZB_GG_ZBZ\" \n" +
                "WHERE  \"CALDAY\" between '" + start + "'  and '" + end + "'\n" +
                "and  zbbm = 'ZBCRD0001DD' \n" +
                "and value1 <>0\n" +
                "group by  \"CALDAY\"---日\n" +
                "order by CALDAY desc";
//        Map<String, Object> map1 = HanaDButilwy.executeQueryForListPublic(sql1, null);
//        List<Map<String, Object>> array = (List<Map<String, Object>>) map1.get("dataList");

        List<Map<String, Object>> array = mockData();
        System.out.println(array);
        List<Map<String, Object>> arraySort = listSort(array);
        System.out.println(arraySort);


//        List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>() {{
//            for (int i = 0; i < array.size(); i++) {
//                int finalI = i;
//                Map<String, Object> dataMap = new HashMap<String, Object>() {{
//                    put("calday", array.get(finalI).get("calday").toString());//横坐标（时间）
//                    put("zbz", array.get(finalI).get("zbz").toString());//横坐标对应的数据
//                }};
//                add(dataMap);
//            }
//
//        }};
        ExcelChartUtil3 ecu = new ExcelChartUtil3();
        try {
            // 创建柱状图
            //  ecu.createBarChart(titleArr, fldNameArr, dataList);
            // 创建饼状图
            //ecu.createPieChart(titleArr, fldNameArr, dataList);
            // 创建折线图
            ecu.createTimeXYChar(titleArr, fldNameArr, arraySort);
            //ecu.createTimeXYChar(titleArr, fldNameArr, dataList);
            // 创建面积图
            //  ecu.createAreaChart(titleArr, fldNameArr, dataList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 排序
     *
     * @param array
     */
    private static List<Map<String, Object>> listSort(List<Map<String, Object>> array) {
        List<String> mapFirstKeys = new ArrayList<>();
        array.forEach(map -> {
            map.forEach((mapKey, mapValue) -> {
                if ("calday".equals(mapKey)) {
                    mapFirstKeys.add(String.valueOf(mapValue));
                }
            });
        });
        mapFirstKeys.sort(String::compareTo);
        //mapKeys.sort((Object s1, Object s2) -> s1.compareTo(s2));
        List<Map<String, Object>> arraySort = new ArrayList<>();
        mapFirstKeys.forEach(mapFirstKey -> {
            array.forEach(map -> {
                if (map.get("calday").equals(mapFirstKey)) {
                    arraySort.add(map);
                }
            });
        });
        return arraySort;
    }


    /**
     * 创建柱状图(堆积图，多组)
     *
     * @throws IOException
     */
    public void createBarChart(List<String> titleArr, List<String> fldNameArr, List<Map<String, Object>> dataList) {
        // 创建一个sheet页
        sheet = wb.createSheet("sheet0");
        // drawSheet0Table(sheet,titleArr,fldNameArr,dataList);
        // 堆积=STBarGrouping.STACKED 多组=STBarGrouping.CLUSTERED
        boolean result = drawSheet0Map(sheet, STBarGrouping.CLUSTERED, fldNameArr, dataList, titleArr);
        System.out.println("生成柱状图(堆积or多组)-->" + result);
    }

    /**
     * 生成柱状图
     *
     * @param sheet      页签
     * @param group      柱状图类型(堆积,多组)
     * @param fldNameArr 坐标名称
     * @param dataList   统计数据
     * @return
     */
    private boolean drawSheet0Map(SXSSFSheet sheet, STBarGrouping.Enum group, List<String> fldNameArr,
                                  List<Map<String, Object>> dataList, List<String> titleArr) {
        boolean result = false;
        // 获取sheet名称
        String sheetName = sheet.getSheetName();
        result = drawSheet0Table(sheet, titleArr, fldNameArr, dataList);
        // 创建一个画布
        Drawing drawing = sheet.createDrawingPatriarch();
        // 画一个图区域
        // 前四个默认0，从第8行到第25行,从第0列到第6列的区域
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 6, 25);
        // 创建一个chart对象
        Chart chart = drawing.createChart(anchor);
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        // 创建柱状图模型
        CTBarChart ctBarChart = ctPlotArea.addNewBarChart();
        CTBoolean ctBoolean = ctBarChart.addNewVaryColors();
        ctBarChart.getVaryColors().setVal(true);
        // 设置图类型
        ctBarChart.addNewGrouping().setVal(group);
        ctBoolean.setVal(true);
        ctBarChart.addNewBarDir().setVal(STBarDir.COL);
        // 是否添加左侧坐标轴
        ctChart.addNewDispBlanksAs().setVal(STDispBlanksAs.ZERO);
        ctChart.addNewShowDLblsOverMax().setVal(true);
        // 设置这两个参数是为了在STACKED模式下生成堆积模式；(standard)标准模式时需要将这两行去掉
        if ("stacked".equals(group.toString()) || "percentStacked".equals(group.toString())) {
            ctBarChart.addNewGapWidth().setVal(150);
            ctBarChart.addNewOverlap().setVal((byte) 100);
        }
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
            String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName,
                    true);
            System.out.println(numDataRange);
            ctNumRef.setF(numDataRange);
            // 添加柱状边框线
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
        // 告诉BarChart它有坐标轴，并给它们id
        ctBarChart.addNewAxId().setVal(123456);
        ctBarChart.addNewAxId().setVal(123457);
        // 横坐标
        CTCatAx ctCatAx = ctPlotArea.addNewCatAx();
        ctCatAx.addNewAxId().setVal(123456); // id of the cat axis
        CTScaling ctScaling = ctCatAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        ctCatAx.addNewAxPos().setVal(STAxPos.B);
        ctCatAx.addNewCrossAx().setVal(123457); // id of the val axis
        ctCatAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);

        // 纵坐标
        CTValAx ctValAx = ctPlotArea.addNewValAx();
        ctValAx.addNewAxId().setVal(123457); // id of the val axis
        ctScaling = ctValAx.addNewScaling();
        ctScaling.addNewOrientation().setVal(STOrientation.MIN_MAX);
        // 设置位置
        ctValAx.addNewAxPos().setVal(STAxPos.L);
        ctValAx.addNewCrossAx().setVal(123456); // id of the cat axis
        ctValAx.addNewTickLblPos().setVal(STTickLblPos.NEXT_TO);
        // 是否删除主左边轴
        ctValAx.addNewDelete().setVal(false);
        // 是否删除横坐标
        ctCatAx.addNewDelete().setVal(false);
        // legend图注
        // if(true){
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
        // }
        return result;
    }

    /**
     * 创建横向柱状图
     *
     * @throws IOException
     */
    public void createAreaChart(List<String> titleArr, List<String> fldNameArr,
                                List<Map<String, Object>> dataList) {
        // 创建一个sheet页
        sheet = wb.createSheet("sheet1");
        boolean result = drawSheet1Map(sheet, "is3D", fldNameArr, dataList, titleArr);
        System.out.println("生成面积图-->" + result);
    }

    /**
     * 生成面积图
     *
     * @param sheet
     * @param type
     * @param fldNameArr
     * @param dataList
     * @param titleArr
     * @return
     */
    private boolean drawSheet1Map(SXSSFSheet sheet, String type, List<String> fldNameArr,
                                  List<Map<String, Object>> dataList, List<String> titleArr) {
        boolean result = false;
        // 获取sheet名称
        String sheetName = sheet.getSheetName();
        result = drawSheet0Table(sheet, titleArr, fldNameArr, dataList);
        // 创建一个画布
        Drawing drawing = sheet.createDrawingPatriarch();
        // 画一个图区域
        // 前四个默认0，从第8行到第25行,从第0列到第6列的区域
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 6, 25);
        // 创建一个chart对象
        Chart chart = drawing.createChart(anchor);
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTAreaChart ctAreaChart = ctPlotArea.addNewAreaChart();
        CTBoolean ctBoolean = ctAreaChart.addNewVaryColors();
        ctAreaChart.addNewGrouping().setVal(STGrouping.STANDARD);
        // 创建序列,并且设置选中区域
        for (int i = 2; i < fldNameArr.size() - 1; i++) {
            CTAreaSer ctAreaSer = ctAreaChart.addNewSer();
            CTSerTx ctSerTx = ctAreaSer.addNewTx();
            // 图例区
            CTStrRef ctStrRef = ctSerTx.addNewStrRef();
            // 选定区域第0行,第1,2,3列标题作为图例 //1 2 3
            String legendDataRange = new CellRangeAddress(0, 0, i + 1, i + 1).formatAsString(sheetName, true);
            ctStrRef.setF(legendDataRange);
            ctAreaSer.addNewIdx().setVal(i);
            // 横坐标区
            CTAxDataSource cttAxDataSource = ctAreaSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            // 选第0列,第1-6行作为横坐标区域
            String axisDataRange = new CellRangeAddress(1, dataList.size(), 0, 0).formatAsString(sheetName, true);
            ctStrRef.setF(axisDataRange);
            // 数据区域
            CTNumDataSource ctNumDataSource = ctAreaSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
            // 选第1-6行,第1-3列作为数据区域 //1 2 3
            String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName,
                    true);
            System.out.println(numDataRange);
            ctNumRef.setF(numDataRange);
            // 设置标签格式
            ctBoolean.setVal(false);
            CTDLbls newDLbls = ctAreaSer.addNewDLbls();
            newDLbls.setShowLegendKey(ctBoolean);
            ctBoolean.setVal(true);
            newDLbls.setShowVal(ctBoolean);
            ctBoolean.setVal(false);
            newDLbls.setShowCatName(ctBoolean);
            newDLbls.setShowSerName(ctBoolean);
            newDLbls.setShowPercent(ctBoolean);
            newDLbls.setShowBubbleSize(ctBoolean);
            newDLbls.setShowLeaderLines(ctBoolean);
            /*
             * //是否是平滑曲线 CTBoolean addNewSmooth = ctAreaSer.addNewSmooth();
             * addNewSmooth.setVal(false); //是否是堆积曲线 CTMarker addNewMarker =
             * ctAreaSer.addNewMarker(); CTMarkerStyle addNewSymbol =
             * addNewMarker.addNewSymbol();
             * addNewSymbol.setVal(STMarkerStyle.NONE);
             */
        }
        // telling the BarChart that it has axes and giving them Ids
        ctAreaChart.addNewAxId().setVal(123456);
        ctAreaChart.addNewAxId().setVal(123457);
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
        ctValAx.addNewDelete().setVal(false);
        // 是否删除横坐标
        ctCatAx.addNewDelete().setVal(false);
        // legend图注
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(false);
        return result;
    }

    /**
     * 创建饼状图
     *
     * @throws IOException
     */
    public void createPieChart(List<String> titleArr, List<String> fldNameArr, List<Map<String, Object>> dataList) {
        // 创建一个sheet页
        sheet = wb.createSheet("sheet2");
        boolean result = drawSheet2Map(sheet, "is3D", fldNameArr, dataList, titleArr);
        System.out.println("生成饼状图(普通or3D)-->" + result);
    }

    /**
     * 创建饼状图
     *
     * @param sheet      页签
     * @param type       图类型(3D或者普通)
     * @param fldNameArr (类标题)
     * @param dataList   (填充数据)
     * @param titleArr   (标题)
     * @return
     */
    private boolean drawSheet2Map(SXSSFSheet sheet, String type, List<String> fldNameArr,
                                  List<Map<String, Object>> dataList, List<String> titleArr) {
        boolean result = false;
        // 获取sheet名称
        String sheetName = sheet.getSheetName();
        result = drawSheet0Table(sheet, titleArr, fldNameArr, dataList);
        // 创建一个画布
        Drawing drawing = sheet.createDrawingPatriarch();
        // 画一个图区域
        // 前四个默认0，从第8行到第25行,从第0列到第6列的区域
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 8, 6, 25);
        // 创建一个chart对象
        Chart chart = drawing.createChart(anchor);
        CTChart ctChart = ((XSSFChart) chart).getCTChart();
        CTPlotArea ctPlotArea = ctChart.getPlotArea();
        CTBoolean ctBoolean = null;
        CTPie3DChart ctPie3DChart = null;
        CTPieChart ctPieChart = null;
        // 创建饼状图模型
        if (type.equals("is3D")) {
            ctPie3DChart = ctPlotArea.addNewPie3DChart();
            ctBoolean = ctPie3DChart.addNewVaryColors();
        } else {
            ctPieChart = ctPlotArea.addNewPieChart();
            ctBoolean = ctPieChart.addNewVaryColors();
        }
        // 创建序列,并且设置选中区域
        for (int i = 0; i < fldNameArr.size() - 1; i++) {
            CTPieSer ctPieSer = null;
            if (type.equals("is3D")) {
                ctPieSer = ctPie3DChart.addNewSer();
            } else {
                ctPieSer = ctPieChart.addNewSer();
            }
            CTSerTx ctSerTx = ctPieSer.addNewTx();
            // 图例区
            CTStrRef ctStrRef = ctSerTx.addNewStrRef();
            // 选定区域第0行,第1,2,3列标题作为图例 //1 2 3
            String legendDataRange = new CellRangeAddress(0, 0, i + 1, i + 1).formatAsString(sheetName, true);
            ctStrRef.setF(legendDataRange);
            ctPieSer.addNewIdx().setVal(i);
            // 横坐标区
            CTAxDataSource cttAxDataSource = ctPieSer.addNewCat();
            ctStrRef = cttAxDataSource.addNewStrRef();
            // 选第0列,第1-6行作为横坐标区域
            String axisDataRange = new CellRangeAddress(1, dataList.size(), 0, 0).formatAsString(sheetName, true);
            ctStrRef.setF(axisDataRange);
            // 数据区域
            CTNumDataSource ctNumDataSource = ctPieSer.addNewVal();
            CTNumRef ctNumRef = ctNumDataSource.addNewNumRef();
            // 选第1-6行,第1-3列作为数据区域 //1 2 3
            String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName,
                    true);
            System.out.println(numDataRange);
            ctNumRef.setF(numDataRange);
            // 显示边框线
            ctPieSer.addNewSpPr().addNewLn().addNewSolidFill().addNewSrgbClr().setVal(new byte[]{0, 0, 0});
            // 设置标签格式
            ctBoolean.setVal(true);
        }
        // legend图注
        CTLegend ctLegend = ctChart.addNewLegend();
        ctLegend.addNewLegendPos().setVal(STLegendPos.B);
        ctLegend.addNewOverlay().setVal(true);
        return result;
    }

    /**
     * 创建折线图
     *
     * @throws IOException
     */
    public void createTimeXYChar(List<String> titleArr, List<String> fldNameArr, List<Map<String, Object>> dataList) {
        // 创建一个sheet页
        sheet = wb.createSheet("sheet3");
        // 第二个参数折线图类型:line=普通折线图,line-bar=折线+柱状图
        boolean result = drawSheet3Map(sheet, "line", fldNameArr, dataList, titleArr);
        System.out.println("生成折线图(折线图or折线图-柱状图)-->" + result);
    }

    /**
     * 生成折线图
     *
     * @param sheet      页签
     * @param type       类型
     * @param fldNameArr X轴标题
     * @param dataList   填充数据
     * @param titleArr   图例标题
     * @return
     */
    private boolean drawSheet3Map(SXSSFSheet sheet, String type, List<String> fldNameArr,
                                  List<Map<String, Object>> dataList, List<String> titleArr) {
        boolean result = false;
        // 获取sheet名称
        String sheetName = sheet.getSheetName();
        result = drawSheet0Table(sheet, titleArr, fldNameArr, dataList);
        // 创建一个画布
        Drawing drawing = sheet.createDrawingPatriarch();
        // 画一个图区域
        // 前四个默认0，从第8行到第25行,从第0列到第6列的区域
        ClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 1, 8, 9, 25);
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
                String numDataRange = new CellRangeAddress(1, dataList.size(), i + 1, i + 1).formatAsString(sheetName,
                        true);
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
            addNewSmooth.setVal(true);
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
        return result;
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
    private boolean drawSheet0Table(SXSSFSheet sheet, List<String> titleArr, List<String> fldNameArr,
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
                    rowi.createCell(j).setCellValue((String) data.get("calday"));
                    // 设置左边字段样式
                    sheet.getRow(i + 1).getCell(j).setCellStyle(styleList.get(0));
                } else {
                    rowi.createCell(j).setCellValue(Double.parseDouble(data.get("zbz").toString()));

                    // 设置数据样式
                    sheet.getRow(i + 1).getCell(j).setCellStyle(styleList.get(2));
                }
            }
        }
        return result;
    }

    /**
     * 生成表格样式
     *
     * @return
     */
  /*  private static List<CellStyle> tableStyle() {
        List<CellStyle> cellStyleList = new ArrayList<CellStyle>();
        // 样式准备
        // 标题样式
        CellStyle style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.ROYAL_BLUE.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setBorderBottom(BorderStyle.THIN); // 下边框
        style.setBorderLeft(BorderStyle.THIN);// 左边框
        style.setBorderTop(BorderStyle.THIN);// 上边框
        style.setBorderRight(BorderStyle.THIN);// 右边框
        style.setAlignment(HorizontalAlignment.CENTER);
        cellStyleList.add(style);
        CellStyle style1 = wb.createCellStyle();
        style1.setBorderBottom(BorderStyle.THIN); // 下边框
        style1.setBorderLeft(BorderStyle.THIN);// 左边框
        style1.setBorderTop(BorderStyle.THIN);// 上边框
        style1.setBorderRight(BorderStyle.THIN);// 右边框
        style1.setAlignment(HorizontalAlignment.CENTER);
        cellStyleList.add(style1);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setBorderTop(BorderStyle.THIN);// 上边框
        cellStyle.setBorderBottom(BorderStyle.THIN); // 下边框
        cellStyle.setBorderLeft(BorderStyle.THIN);// 左边框
        cellStyle.setBorderRight(BorderStyle.THIN);// 右边框
        cellStyle.setAlignment(HorizontalAlignment.CENTER);// 水平对齐方式
        // cellStyle.setVerticalAlignment(VerticalAlignment.TOP);//垂直对齐方式
        cellStyleList.add(cellStyle);
        return cellStyleList;
    }*/
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


    public static final Map<String, String> ZBBM = new HashMap<String, String>() {{
        put("ZBOIL0020BD", "胜利原油（当月计价）");
        put("ZBOIL0021BD", "石脑油（当月计价）");
        put("ZBOIL0022BD", "航煤（上月计价）");
    }};


    public static final List<String> ZBBMList = new ArrayList<String>() {{
        add("ZBOIL0020BD");
        add("ZBOIL0021BD");
        add("ZBOIL0022BD");
        add("原油编码");
    }};

}

