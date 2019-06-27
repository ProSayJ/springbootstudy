package com.prosayj.springboot.report.model;

import java.util.List;

public class ChartSeries {

    //系列名字
    private String seriesName;
    //柱状图或者折线图
    private String barOrLine;
    //该系列图表类别+值
    private List<ChartCategory> chartCategoryList;

    public ChartSeries() {

    }

    public ChartSeries(String seriesName, List<ChartCategory> chartCategoryList) {
        this.seriesName = seriesName;
        this.chartCategoryList = chartCategoryList;
    }

   

	public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public List<ChartCategory> getChartCategoryList() {
        return chartCategoryList;
    }

    public void setChartCategoryList(List<ChartCategory> chartCategoryList) {
        this.chartCategoryList = chartCategoryList;
    }

	public String getBarOrLine() {
		return barOrLine;
	}

	public void setBarOrLine(String barOrLine) {
		this.barOrLine = barOrLine;
	}

}
