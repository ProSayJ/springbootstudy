package com.prosayj.springboot.designmode.研磨设计模式._15_Template_method.example2;

/**
 * 描述登录人员登录时填写的信息的数据模型
 */
public class LoginModel {
    private String workerId;
    private String pwd;

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
}
