package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_5_有状态的转换;

import java.util.Comparator;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        //只获取了一个"merrily"
        Stream<String> uniqueWords = Stream.of("merrily", "merrily", "merrily", "gently").distinct();
        System.out.println(uniqueWords.toArray().length);

        Stream<String> longestFirst = uniqueWords.sorted(Comparator.comparing(String::length).reversed());



    }
}
