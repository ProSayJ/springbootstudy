package com.prosayj.springboot.designmode.研磨设计模式._15_Template_method.example2;

/**
 * 描述工作人员信息的数据模型
 */
public class WorkerModel {
    private String uuid;
    private String workerId;
    private String pwd;
    private String name;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}