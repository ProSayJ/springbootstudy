package com.prosayj.springboot.叶子猿java并发编程原理与实战._01_创建线程的几种方式;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangjian
 * @description ：jdk1.8新特性 并行流
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:11
 * @since 1.0.0
 */
public class _08_parallelstream {
    public static void main(String[] args) {

        List<Integer> values = Arrays.asList(10, 20, 30, 40);
        int res = new _08_parallelstream().add(values);
        System.out.println("计算的结果为：" + res);


    }


    public int add(List<Integer> values) {
        //并行流：parallelStream
        values.parallelStream().forEach(System.out::println);
        values.parallelStream().forEachOrdered(System.out::println);

//        return values.parallelStream().mapToInt(i -> i * 2).sum();
        return values.parallelStream().mapToInt(i -> i).sum();
    }

}
