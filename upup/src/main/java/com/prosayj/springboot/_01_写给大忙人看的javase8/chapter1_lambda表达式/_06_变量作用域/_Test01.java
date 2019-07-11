package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._06_变量作用域;

public class _Test01 {
    public static void main(String[] args) {

    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i = 0; i < count; i++) {
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();

    }

    public static void repeatMessage2(String text, int count) {
        Runnable r = () -> {
            while (count > 0) {
                //count --;//错误，不能更改已捕获变量的值
                System.out.println(text);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }
}
