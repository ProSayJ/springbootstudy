package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.List;

public class ChartData implements Serializable {
    private static final long serialVersionUID = 4554866480287500929L;
    //所有系列
    private List<ChartSeries> chartSeriesList;


    public ChartData() {

    }

    public ChartData(List<ChartSeries> chartSeriesList) {
        this.chartSeriesList = chartSeriesList;
    }

    public List<ChartSeries> getChartSeriesList() {
        return chartSeriesList;
    }

    public void setChartSeriesList(List<ChartSeries> chartSeriesList) {
        this.chartSeriesList = chartSeriesList;
    }


}
