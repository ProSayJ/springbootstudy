package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._01_static_proxy;

public class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("----已经保存数据!----");
    }
}
