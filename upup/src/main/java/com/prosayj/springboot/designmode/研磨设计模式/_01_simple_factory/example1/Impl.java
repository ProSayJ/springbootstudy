package com.prosayj.springboot.designmode.研磨设计模式._01_simple_factory.example1;

/**
 * 对接口的实现
 */
public class Impl implements Api {

    @Override
    public void test1(String s) {
        System.out.println("Now In Impl. The input s==" + s);
    }
}
