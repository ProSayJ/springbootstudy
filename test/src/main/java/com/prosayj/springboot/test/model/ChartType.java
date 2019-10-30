package com.prosayj.springboot.test.model;

public class ChartType {

    //系列名字
    private String seriesName;
    //柱状图或者折线图
    private String barOrLine;

    public ChartType() {

    }

    public ChartType(String seriesName, String barOrLine) {
        this.seriesName = seriesName;
        this.barOrLine = barOrLine;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }


	public String getBarOrLine() {
		return barOrLine;
	}

	public void setBarOrLine(String barOrLine) {
		this.barOrLine = barOrLine;
	}

}
