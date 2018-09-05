package com.prosayj.springboot.designmode.研磨设计模式._02_facade.example2;

public class AModuleImpl implements AModuleApi {
    @Override
    public void testA() {
        System.out.println("现在在A模块里面操作testA方法");
    }
}
