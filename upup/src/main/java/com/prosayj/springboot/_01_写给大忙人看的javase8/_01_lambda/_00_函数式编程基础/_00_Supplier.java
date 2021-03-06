package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._00_函数式编程基础;

import java.util.function.Supplier;

/**
 * 如何自定义函数式接口方法
 */
public class _00_Supplier {
    public static void main(String[] args) {
        method(() -> "helloworld");


    }

    public static void method(Supplier<String> supplier) {
        String s = supplier.get();//重写的接口的抽象方法get。
        System.out.println(s);
    }
}
