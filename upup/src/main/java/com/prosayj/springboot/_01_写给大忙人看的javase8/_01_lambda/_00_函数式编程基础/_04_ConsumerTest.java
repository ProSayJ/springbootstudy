package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._00_函数式编程基础;

import java.util.function.Consumer;

public class _04_ConsumerTest {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};

        method(s -> System.out.print("姓名：" + s.split(",")[0]),
                s -> System.out.println(" 性别：" + s.split(",")[1]),
                array);

    }

    //定义方法，用来打印
    public static void method(Consumer<String> one, Consumer<String> two, String[] arr) {
        //遍历数组，拿到数组中的每一个元素
        for (String s : arr) {
            //打印姓名
            //one.accept(s);
            //打印性别
            //two.accept(s);
            //合并成一个Consumer
            one.andThen(two).accept(s);
        }

    }
}
