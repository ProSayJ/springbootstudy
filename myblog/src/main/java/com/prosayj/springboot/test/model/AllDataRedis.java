package com.prosayj.springboot.test.model;

import java.io.Serializable;
import java.util.Map;

public class AllDataRedis implements Serializable {
    private static final long serialVersionUID = -8894807759589673013L;
    /**
     * ppt图表类型对应的数据
     */
    private Map<Integer, SlideData> chart;
    /**
     * table对应的数据
     */
    private Map<Integer, SlideData> table;
    /**
     * PPT名字sheet页的名称
     */
    private String pptTitleName;


    public AllDataRedis() {

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

    public String getPptTitleName() {
        return pptTitleName;
    }

    public void setPptTitleName(String pptTitleName) {
        this.pptTitleName = pptTitleName;
    }
}
