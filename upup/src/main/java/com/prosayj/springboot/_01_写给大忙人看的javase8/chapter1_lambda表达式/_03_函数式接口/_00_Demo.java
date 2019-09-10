package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._03_函数式接口;

import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:09
 * @since 1.0.0
 */
public class _00_Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(9);
        list.add(3);
        list.add(1);
        list.add(8);
        list.add(0);
        System.out.println(list);
        Collections.sort(list, Integer::compareTo);

        //list.sort(Comparator.reverseOrder());
        System.out.println(list);
    }
}
