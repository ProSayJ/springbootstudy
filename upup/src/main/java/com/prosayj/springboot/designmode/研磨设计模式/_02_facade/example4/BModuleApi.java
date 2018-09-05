package com.prosayj.springboot.designmode.研磨设计模式._02_facade.example4;

public interface BModuleApi {
    //对子系统外部
    public void b1();

    //子系统内部使用
    public void b2();

    //子系统内部使用
    public void b3();
}
