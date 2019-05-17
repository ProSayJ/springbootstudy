package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._03_cglib_proxy;

import com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._01_static_proxy.UserDao;

public class MainTest {
    public static void main(String[] args) {
        //目标对象
        UserDao target = new UserDao();

        //代理对象
        UserDao proxy = (UserDao) new ProxyFactory(target).getProxyInstance();

        //执行代理对象的方法
        proxy.save();
    }
}
