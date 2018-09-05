package com.prosayj.springboot.designmode.研磨设计模式._02_facade.example2;


public class BModuleImpl implements BModuleApi {


    @Override
    public void testB() {
        System.out.println("现在在B模块里面操作testB方法");
    }

}
