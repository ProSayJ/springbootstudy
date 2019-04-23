package com.prosayj.springboot._03_Java8实战._01;

import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

public class First01 {
    public static void main(String[] args) {
        String s = "hello";
        new Thread(() -> {
            System.out.println(s);
        }).start();
        Predicate<Integer> a = x-> x > 4;

    }
}
