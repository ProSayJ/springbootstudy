package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy.example5;

public interface OrderApi {
    public String getProductName();

    public void setProductName(String productName, String user);

    public int getOrderNum();

    public void setOrderNum(int orderNum, String user);

    public String getOrderUser();

    public void setOrderUser(String orderUser, String user);
}