package com.prosayj.springboot.designmode.研磨设计模式._05_factorymethod.example6;

public class A2 extends A1 {
    @Override
    protected C1 createC1() {
        //真正的选择具体实现，并创建对象
        return new C2();
    }
}

