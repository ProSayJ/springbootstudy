package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._04_方法引用;

public class _01_Greeter {
    public void greet() {
        System.out.println(Thread.currentThread().getName() + "Hello worrld");
    }

    public static void main(String[] args) {
        new ConcurrentGreeter().greet();
        new _01_Greeter().greet();
    }
}

class ConcurrentGreeter extends _01_Greeter {
    public void greet() {
        new Thread(super::greet).start();
    }
}
