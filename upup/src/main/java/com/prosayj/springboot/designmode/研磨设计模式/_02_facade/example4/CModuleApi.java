package com.prosayj.springboot.designmode.研磨设计模式._02_facade.example4;

public interface CModuleApi {
    //对子系统外部
    public void c1();

    //子系统内部使用
    public void c2();

    //子系统内部使用
    public void c3();
}
