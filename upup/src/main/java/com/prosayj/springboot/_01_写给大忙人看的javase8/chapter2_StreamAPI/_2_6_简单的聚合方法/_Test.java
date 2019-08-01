package com.prosayj.springboot._01_写给大忙人看的javase8.chapter2_StreamAPI._2_6_简单的聚合方法;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class _Test {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("ahs", "hsjdah", "h12");
        Optional<String> largest = words.stream().max(String::compareToIgnoreCase);
        if (largest.isPresent()) {
            System.out.println("largest:" + largest.get());
        }

        Optional<String> startsWithQ = words.stream().filter(s -> s.startsWith("Q")).findFirst();

        Optional<String> startsWithQ2 = words.stream().parallel().filter(s -> s.startsWith("Q")).findAny();


        boolean aWordStartWithQ = words.stream().parallel().anyMatch(s -> s.startsWith("Q"));

        System.out.println(Test01.getA());
    }
}
class Test01{
    public static int getA() {
        return a;
    }

    public static int a = 10;
    static {
        a = 20;
    }



    public static void m1 (){
        a = 30;
    }
}
