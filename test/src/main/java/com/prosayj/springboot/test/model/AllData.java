package com.prosayj.springboot.test.model;

import java.util.List;

public class AllData extends BaseVO{

    //hana数据库sql
    private String id;
    //ppt的类型：chart/table
    private String pptType;
    //ppt图表类型
    private List<ChartType> chartTypes;
    //PPT每页幻灯片名字
    private String pptName;
    //ppt页码
    private Integer pageNo;

    public AllData() {

    }

    public AllData(String id, String pptType, List<ChartType> chartTypes, String pptName, Integer pageNo) {
        this.id = id;
        this.pptType = pptType;
        this.chartTypes = chartTypes;
        this.pptName = pptName;
        this.pageNo = pageNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPptType() {
        return pptType;
    }

    public void setPptType(String pptType) {
        this.pptType = pptType;
    }

    public List<ChartType> getChartTypes() {
        return chartTypes;
    }

    public void setChartTypes(List<ChartType> chartTypes) {
        this.chartTypes = chartTypes;
    }

    public String getPptName() {
        return pptName;
    }

    public void setPptName(String pptName) {
        this.pptName = pptName;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    @Override
    public String toString() {
        return "AllData{" +
                "id='" + id + '\'' +
                ", pptType='" + pptType + '\'' +
                ", chartTypes=" + chartTypes +
                ", pptName='" + pptName + '\'' +
                ", pageNo=" + pageNo +
                '}';
    }
}
