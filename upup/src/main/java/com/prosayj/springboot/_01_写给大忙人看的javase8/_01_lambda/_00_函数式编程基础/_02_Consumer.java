package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._00_函数式编程基础;

import java.util.function.Consumer;

public class _02_Consumer {
    public static void main(String[] args) {
//        method((b)-> System.out.println("我发现你了"));
      /*   method(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o+"你好啊");

            }
         });*/
        //method((t) -> System.out.println("你好啊"));//打印你好啊

        //method(System.out::println);//拿到t值，转去操作别的，不会产生引用。结果hello

        //System.out.println("----------------------------");

        method((Object t) -> System.out.println(t));//hello

        method(System.out::println);//对象引用成员方法，拿到对象直接对对象进行操作//hello


    }

    public static void method(Consumer consumer) {
        consumer.accept("hello");
    }


}

