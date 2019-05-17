package com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._02_dynamic_proxy;

import com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._01_static_proxy.IUserDao;
import com.prosayj.springboot.designmode.研磨设计模式._10_Proxy._01_static_proxy.UserDao;

public class MainTest {
    public static void main(String[] args) {

        IUserDao target = new UserDao();
        System.out.println(target.getClass());

        IUserDao proxy = (IUserDao) new ProxyFactory(target).getProxyInstance();
        System.out.println(proxy.getClass());

        proxy.save();
    }
}
