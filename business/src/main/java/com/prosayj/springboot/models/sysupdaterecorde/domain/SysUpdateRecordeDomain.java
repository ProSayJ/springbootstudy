package com.prosayj.springboot.models.sysupdaterecorde.domain;

import java.util.Date;

public class SysUpdateRecordeDomain {
    private Long id;

    private String version;

    private String description;

    private Date recordeTime;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRecordeTime() {
        return recordeTime;
    }

    public void setRecordeTime(Date recordeTime) {
        this.recordeTime = recordeTime;
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
}