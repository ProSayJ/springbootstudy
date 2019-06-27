package com.prosayj.springboot.report.app;

import java.util.List;

/**
 * 图表系列数据
 *
 * @author caoyong
 */
public class GraphData {
    // 图形标题
    private String title;

    // 系列值
    private List<SeriesData> serList;


    public GraphData() {
    }

    public GraphData(String title, List<SeriesData> serList) {
        this.title = title;
        this.serList = serList;
    }

    public String getTitle() {
        return title;
    }

    public List<SeriesData> getSerList() {
        return serList;
    }
}

class SeriesData {
    // 系列名称
    private String serName;

    // 系列值
    private double serVal;

    public SeriesData(String serName, double serVal) {
        this.serName = serName;
        this.serVal = serVal;
    }

    public String getSerName() {
        return serName;
    }

    public double getSerVal() {
        return serVal;
    }

}
