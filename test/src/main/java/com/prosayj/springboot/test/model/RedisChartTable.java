package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.Map;

public class RedisChartTable implements Serializable {

    private static final long serialVersionUID = 8061747583152018588L;
    private Map<Integer, SlideData> chart;
    private Map<Integer, SlideData> table;

    public RedisChartTable(Map<Integer, SlideData> chart, Map<Integer, SlideData> table) {
        this.chart = chart;
        this.table = table;
    }

    public RedisChartTable() {

    }

    public Map<Integer, SlideData> getChart() {
        return chart;
    }

    public void setChart(Map<Integer, SlideData> chart) {
        this.chart = chart;
    }

    public Map<Integer, SlideData> getTable() {
        return table;
    }

    public void setTable(Map<Integer, SlideData> table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return "RedisChartTable{" +
                "chart=" + chart +
                ", table=" + table +
                '}';
    }
}
