package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangjian
 * @description Arrays.sort方法传递了一段需要比较元素的代码片段，这段代码会被整合到比较的逻辑中，而你并不需要关心如何在那里实现
 * @Date 上午 08:57 2019/9/10
 * @since 1.0.0
 */
public class _02_LengthComparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        /**
         * Integer.compare(x,y)
         * x=y;返回0
         * x>y;返回正数
         * x=y;返回负数
         */
        return Integer.compare(first.length(), second.length());
    }

    public static void main(String[] args) {
        String[] strings = {"a", "bb", "ccc"};
        Arrays.sort(strings, new _02_LengthComparator());
    }
}
