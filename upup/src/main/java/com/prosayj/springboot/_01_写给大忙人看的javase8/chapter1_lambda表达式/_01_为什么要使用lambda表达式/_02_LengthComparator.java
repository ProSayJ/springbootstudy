package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;

import java.util.Arrays;
import java.util.Comparator;

public class _02_LengthComparator implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return Integer.compare(first.length(), second.length());
    }

    public static void main(String[] args) {
        String[] strings = {"a", "bb", "ccc"};
        Arrays.sort(strings, new _02_LengthComparator());
    }
}
