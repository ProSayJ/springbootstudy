package com.prosayj.springboot.models.systemplate.domain;

import java.util.Date;

public class SysTemplateDomain {
    private Long id;

    private String refKey;

    private Date createTime;

    private Date updateTime;

    private String refValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefKey() {
        return refKey;
    }

    public void setRefKey(String refKey) {
        this.refKey = refKey;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRefValue() {
        return refValue;
    }

    public void setRefValue(String refValue) {
        this.refValue = refValue;
    }
}