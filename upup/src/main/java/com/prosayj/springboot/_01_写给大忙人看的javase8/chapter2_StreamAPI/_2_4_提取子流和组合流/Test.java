package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_4_提取子流和组合流;

import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //1:裁剪指定长度的流
        Stream<Double> limit = Stream.generate(Math::random).limit(100);

        //2：简单的skip方法
        String contants = "";
        Stream<String> skip = Stream.of(contants.split("[\\p{L}]+")).skip(1);

        //3:使用Stream类的静态方法concat将两个流链接到一起
        Stream<Character> combined = Stream.concat(
                com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_3_filter_map和flatMap方法.Test.characterStream("Hello"),
                com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_3_filter_map和flatMap方法.Test.characterStream("world"));
        //会产生新的流['H','e','l','l','o','w','o','r','l','d']
        Object[] objects = combined.toArray();
        System.out.println(objects.toString());

        //4:peek 方法会产生另一个与原始流具有相罔元素的流 ，但是在每次获取一个元素时 ，都会调用一个函数 ，这样便于调试。
        //当真正访问某个元素时会打印一条消息。通过这种方式 ，你可以确定iterate方法返回的无限流是否被延迟处理了 。
        Object[] powers = Stream.iterate(1.0, p -> p * 2)
                .peek(e -> System.out.println("Fetching " + e))
                .limit(20).toArray();
        System.out.println(powers);




    }
}
