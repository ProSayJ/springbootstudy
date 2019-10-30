package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._09_execises;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangjian
 * @description Arrays.sort中的比较器的逻辑和主线程是同一个线程吗？
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/11 上午 08:47
 * @since 1.0.0
 */
public class _IsThreSimeThread {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        List<Integer> list = Arrays.asList(9, 2, 4, 5, 1);
        System.out.println(list.toString());

        Collections.sort(list,new MyComparator());
        System.out.println(list.toString());


    }


    static class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            System.out.println(Thread.currentThread().getName());
            return o2.compareTo(o1);
        }
    }


}
