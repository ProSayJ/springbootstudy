package com.prosayj.springboot.report.app;

import com.prosayj.springboot.report.model.*;
import com.prosayj.springboot.report.util.PowerPointGenerator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * <b><code>ReportApp</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/10/31 22:48.
 *
 * @author Hu Weihui
 */
public class ReportApp {

    public static void main(String[] args) {
        String templateFile = System.getProperty("user.dir") +
                File.separator + "poi\\src\\main\\resources\\source\\model.pptx";
        String resultFile = System.getProperty("user.dir") +
                File.separator + "poi\\src\\main\\resources\\target\\result2.pptx";

        PowerPointGenerator.generatorPowerPoint(templateFile, resultFile, getData1());
    }

    private static Map<Integer, SlideData> getData1() {
        Map<Integer, SlideData> map = new HashMap<>();
        //第一页图表内容
        SlideData slideData6 = new SlideData();
        slideData6.setChartDataList(getChartData2());
        slideData6.setSlidePage(1);
        map.put(1, slideData6);
        return map;
    }

    private static Map<Integer, SlideData> getData2() {
        Map<Integer, SlideData> map = new HashMap<>();
        //2页表格
        SlideData slideData4 = new SlideData();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            List<String> t = new ArrayList<>();
            t.add("新加坡原油" + i);
            t.add("55.99");
            t.add("55.99");
            t.add("55.99");
            t.add("55.99");
            t.add("55.99");
            t.add("55.99");
            list.add(t);
        }
        slideData4.setTableDataList(getTableTest1(list));
        map.put(1, slideData4);
        return map;
    }

    /**
     * 造点数据玩完吧
     *
     * @return
     */
    private static Map<Integer, SlideData> getData() {
        Map<Integer, SlideData> map = new HashMap<>();
        SlideData slideData6 = new SlideData();
        slideData6.setChartDataList(getChartData2());
//        slideData6.setTextMap(getTextDataTest2());
        map.put(1, slideData6);

        SlideData slideData4 = new SlideData();
        slideData4.setTableDataList(getTableTest());
        map.put(2, slideData4);

       /*
        //第1页text
        SlideData slideData3 = new SlideData();
        slideData3.setTextMap(getTextDataTest());
        map.put(1, slideData3);
        //2页表格
        SlideData slideData4 = new SlideData();
        slideData4.setTableDataList(getTableTest());
        map.put(2, slideData4);
        //3页饼图
        SlideData slideData5 = new SlideData();
        slideData5.setChartDataList(getChartData());
        map.put(3, slideData5);
        //4页柱状图
        SlideData slideData6 = new SlideData();
        slideData6.setChartDataList(getChartData2());
        slideData6.setTextMap(getTextDataTest2());
        map.put(1, slideData6);
        //5页折线图
        SlideData slideData8 = new SlideData();
        slideData8.setChartDataList(getChartData2());
        map.put(5, slideData8);
        //6页折线图
        SlideData slideData9 = new SlideData();
        slideData9.setChartDataList(getChartData2());
        slideData9.setTableDataList(getTableTest());
        map.put(6, slideData9);
        */

        return map;
    }

    private static Map<String, String> getTextDataTest() {
        Map<String, String> textMap = new HashMap<>();
        textMap.put("3A", "测试成功A");
        textMap.put("3B", "测试成功B");
        return textMap;
    }

    private static Map<String, String> getTextDataTest2() {
        Map<String, String> textMap = new HashMap<>();
        textMap.put("6A", "测试成功A");
        textMap.put("6B", "测试成功B");
        textMap.put("6C", "测试成功C");
        textMap.put("6D", "测试成功D");
        return textMap;
    }

    private static List<TableData> getTableTest1(List<List<String>> list) {
        List<TableRowData> tableRowDataList = new ArrayList<>();
        for (List<String> tableRowData : list) {
            TableRowData tableRowData1 = new TableRowData();
            tableRowData1.setDataList(tableRowData);
            tableRowDataList.add(tableRowData1);
        }


        TableData tableData = new TableData();
        tableData.setTableRowDataList(tableRowDataList);
        List<TableData> list1 = new ArrayList<>();
        list1.add(tableData);
        return list1;
    }

    private static List<TableData> getTableTest() {
        List<TableRowData> tableRowDataList = new ArrayList<>();
        TableRowData tableRowData = new TableRowData();
        List<String> strings1 = new ArrayList<>();
        strings1.add("测试成功A");
        strings1.add("测试成功B");
        strings1.add("测试成功C");
        tableRowData.setDataList(strings1);
        tableRowDataList.add(tableRowData);
        TableRowData tableRowData1 = new TableRowData();
        List<String> strings11 = new ArrayList<>();
        strings11.add("测试成功A");
        strings11.add("测试成功B");
        strings11.add("测试成功C");
        tableRowData1.setDataList(strings11);
        tableRowDataList.add(tableRowData1);

        TableData tableData = new TableData();
        tableData.setTableRowDataList(tableRowDataList);
        List<TableData> list = new ArrayList<>();
        list.add(tableData);
        return list;
    }

    private static List<ChartData> getChartData() {
        List<ChartCategory> categoryDataList = new ArrayList<>();
        ChartCategory categoryData = new ChartCategory("第一季度", 8.2);
        ChartCategory categoryData2 = new ChartCategory("第二季度", 3.2);
        ChartCategory categoryData3 = new ChartCategory("第三季度", 2.6);
        categoryDataList.add(categoryData);
        categoryDataList.add(categoryData2);
        categoryDataList.add(categoryData3);

        List<ChartSeries> seriesDataList = new ArrayList<>();
        ChartSeries seriesData = new ChartSeries();
        seriesData.setSeriesName("销售额");
        seriesData.setChartCategoryList(categoryDataList);
        seriesDataList.add(seriesData);

        ChartData chartData = new ChartData();
        chartData.setChartSeriesList(seriesDataList);

        List<ChartData> chartDataList = new ArrayList<>();
        chartDataList.add(chartData);
        return chartDataList;
    }


    private static List<ChartData> getChartData2() {

        List<String> x = new ArrayList<>();
        x.add("A");
        x.add("B");
        x.add("C");
        x.add("D");

        //line bar
        List<Double> y = new ArrayList<>();
        y.add(0.123);
        y.add(0.084);
        y.add(0.53);
        y.add(11.262);
        ChartSeries seriesData = setChartCategoryList2(x, y, "bar", "布伦特-迪拜");

        List<Double> y2 = new ArrayList<>();
        y2.add(0.093);
        y2.add(0.084);
        y2.add(0.55);
        y2.add(0.181);
        ChartSeries seriesData1 = setChartCategoryList2(x, y2, "bar", "三种油计价期");

        List<Double> y3 = new ArrayList<>();
        y3.add(0.051);
        y3.add(0.071);
        y3.add(0.558);
        y3.add(0.31);
        ChartSeries seriesData2 = setChartCategoryList2(x, y3, "bar", "三种油自然月");

        List<Double> y4 = new ArrayList<>();
        y4.add(0.061);
        y4.add(0.071);
        y4.add(0.041);
        y4.add(0.031);
        ChartSeries seriesData3 = setChartCategoryList2(x, y4, "bar", "炼厂CIF");

        List<Double> y5 = new ArrayList<>();
        y5.add(0.021);
        y5.add(0.031);
        y5.add(0.041);
        y5.add(0.051);
        ChartSeries seriesData4 = setChartCategoryList2(x, y5, "bar", "成品油挂靠原油价格");


        List<ChartSeries> seriesDataList = new ArrayList<>();
        seriesDataList.add(seriesData);
        seriesDataList.add(seriesData1);
        seriesDataList.add(seriesData2);
        seriesDataList.add(seriesData3);
        seriesDataList.add(seriesData4);

        ChartData chartData = new ChartData();
        chartData.setChartSeriesList(seriesDataList);

        List<ChartData> chartDataList = new ArrayList<>();
        chartDataList.add(chartData);
        return chartDataList;
    }

    private static ChartSeries setChartCategoryList2(List<String> x, List<Double> y, String barOrLine, String seriesName) {
        List<ChartCategory> categoryDataList = setChartCategoryList1(x, y);
        ChartSeries seriesData = new ChartSeries();
        seriesData.setBarOrLine(barOrLine);
        seriesData.setSeriesName(seriesName);
        seriesData.setChartCategoryList(categoryDataList);
        return seriesData;
    }

    private static List<ChartCategory> setChartCategoryList1(List<String> x, List<Double> y) {
        List<ChartCategory> categoryDataList3 = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            ChartCategory categoryData = new ChartCategory(x.get(i), y.get(i));
            categoryDataList3.add(categoryData);
        }
        return categoryDataList3;
    }
}
