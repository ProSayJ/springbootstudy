package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._00;

import java.util.function.Consumer;

public class _06_Consumer {
    public static void main(String[] args) {
        method(s -> System.out.println(s.toUpperCase()),
                s -> System.out.println(s.toLowerCase()));
    }

    public static void method(Consumer<String> one, Consumer<String> two) {
        // 先调用one的accept，再调用two的accept
        //one.accept("Hello");
        //two.accept("Hello");

        // 可以把one和two合并成一个Consumer
        //Consumer three = one.andThen(two); //three是合并之后的结果，里面包含了one的操作和two的操作
        //three.accept("Hello"); //通过three调用accept方法，因为trhee是one和two合并之后的结果。索引会先通过one调用accept，再通过two调用accept

        //最终写法
        one.andThen(two).accept("Hello");
    }
}