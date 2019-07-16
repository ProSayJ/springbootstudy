package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.List;

public class ChartSeries implements Serializable {

    private static final long serialVersionUID = 1619296757251045583L;
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
