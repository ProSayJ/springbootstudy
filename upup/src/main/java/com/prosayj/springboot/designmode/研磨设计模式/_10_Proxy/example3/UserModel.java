package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy.example3;

/**
 * 描述用户数据的对象
 */
public class UserModel implements UserModelApi {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 部门编号
     */
    private String depId;
    /**
     * 性别
     */
    private String sex;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDepId() {
        return depId;
    }

    @Override
    public void setDepId(String depId) {
        this.depId = depId;
    }

    @Override
    public String getSex() {
        return sex;
    }

    @Override
    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "userId=" + userId + ",name=" + name + ",depId=" + depId + ",sex=" + sex + "\n";
    }
}
