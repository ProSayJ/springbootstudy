package com.prosayj.springboot.myblog.api_freemark;

import io.swagger.annotations.ApiModelProperty;

public class ModuleDataVO {
    @ApiModelProperty(value = "css列样式", required = false)
    private Integer id;

    @ApiModelProperty(value = "字符串1", required = false)
    private String string1;

    @ApiModelProperty(value = "字符串2", required = false)
    private String string2;

    @ApiModelProperty(value = "开始时间", required = false)
    private String begintime;

    @ApiModelProperty(value = "结束时间", required = false)
    private String endtime;

    @ApiModelProperty(value = "返回类型", required = false)
    private String returntype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    public String getBegintime() {
        return begintime;
    }

    public void setBegintime(String begintime) {
        this.begintime = begintime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getReturntype() {
        return returntype;
    }

    public void setReturntype(String returntype) {
        this.returntype = returntype;
    }

    @Override
    public String toString() {
        return "ModuleDataVO{" +
                "id=" + id +
                ", string1='" + string1 + '\'' +
                ", string2='" + string2 + '\'' +
                ", begintime='" + begintime + '\'' +
                ", endtime='" + endtime + '\'' +
                ", returntype='" + returntype + '\'' +
                '}';
    }
}
