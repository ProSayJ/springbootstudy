package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._06_变量作用域;

public class Application {
    public void doWork() {
        Runnable runner = () -> {
            //...
            System.out.println(this.toString());
            //...
        };
    }
}
