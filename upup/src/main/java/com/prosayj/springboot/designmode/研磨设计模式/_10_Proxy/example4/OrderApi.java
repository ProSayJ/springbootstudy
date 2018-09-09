package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy.example4;

public interface OrderApi {
    public void setProductName(String productName, String user);

    public int getOrderNum();

    public void setOrderNum(int orderNum, String user);

    public String getOrderUser();

    public void setOrderUser(String orderUser, String user);
}
