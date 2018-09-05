package com.prosayj.springboot.javase.base.day06_arraylist.code;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @description arraylist去重
 * @author yangjian
 * @Date 13:36 2018/5/15
 * @since 1.0.0
 */
public class ArrayListDemo_4 {
    public static void main(String[] args) {
        List<String> array = new ArrayList<String>();
        array.add("abc");
        array.add("abc");
        array.add("abc");
        array.add("itcast");
        array.add("itcast");
        array.add("itcast");
        array.add("itcast");
        array.add("love");
        array.add("love");
        array.add("love");
        array.add("java");
        System.out.println(array.toString());
        System.out.println(new ArrayList<String>(new HashSet<String>(array)));
    }
}