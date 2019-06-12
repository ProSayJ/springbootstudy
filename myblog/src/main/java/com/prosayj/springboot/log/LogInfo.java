package com.prosayj.springboot.log;

import java.util.Date;

/**
 * @author yangjian
 * @description 请求操作人签名
 * @Date 10:20 2019/6/12
 * @since 1.0.0
 */
public class LogInfo {
    /**
     * 操作人
     */
    private String user;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 函数名（http:uri+method/methodname）
     */
    private String function;
    /**
     * 参数
     */
    private String paramStr;
    private String returnStr;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getParamStr() {
        return paramStr;
    }

    public void setParamStr(String paramStr) {
        this.paramStr = paramStr;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReturnStr() {
        return returnStr;
    }

    public void setReturnStr(String returnStr) {
        this.returnStr = returnStr;
    }
}
