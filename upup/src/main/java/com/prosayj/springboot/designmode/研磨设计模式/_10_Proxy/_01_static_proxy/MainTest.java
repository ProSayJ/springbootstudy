package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._01_static_proxy;

public class MainTest {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);

        //执行的是代理的方法
        proxy.save();
    }
}
