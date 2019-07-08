package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._04_方法引用;

public class _01_Greeter {
    public void greet() {
        System.out.println("Hello worrld");
    }
}

class ConcurrentGreeter extends _01_Greeter {
    public void greet() {
        Thread t1 = new Thread(super::greet);
        t1.start();
    }
}
