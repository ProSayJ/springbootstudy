package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_2_创建Stream;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        String contants = "";
        //split方法会返回以一个String[]数组
        Stream<String> word = Stream.of(contants.split("[\\P{L}]+"));

        //of 方法接受可变长度的参数 ，因此你可以构造一个含有任意个参数的 Stream:
        Stream<String> song = Stream.of("gently", "down", "the", "stream");

        //泛型<String> 会被编译器推导出来，这里同Stream.<String> empty()一样
        Stream<String> empty = Stream.empty();

        //创建含有常量的stream
        Stream<String> generate = Stream.generate(() -> "echo");

        //创建含有随机字符串的Streams
        Stream<Double> generate1 = Stream.generate(Math::random);

        //创建一个无线序列
        Stream<BigInteger> integes = Stream.iterate(BigInteger.ZERO, n -> n.add(BigInteger.ONE));
        integes.limit(100000);
        integes.forEach(System.out::println);

        //在 Java  8 中，添加了许多能够产生 Stream  的方法。
        // 例如，Pattern 类添加了个 splitAsStream  的方法 ，
        // 能够按照正则表达式对 CharSequence 对象进行分隔。你可以使用如下代码对一个字符串按照单词进行分隔。
        Stream<String> words = Pattern.compile("[\\P{L}]+").splitAsStream(contants);


        //静态方法 Files.lines 会返回一个包含文件中所有行的 Stream。
        // Stream 接口有一个父接口 AutoCloseable。当在某个 Stream 上调用 close 方法时，底层的文件也会被关闭 。
        //为了确保关闭文件 ，最好使用 Java 7 中提供的 try-with  resources 语句 ，如下：
        String file = "";
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            //doSth
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
