package com.prosayj.springboot.zljdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/20 上午 08:42
 * @since 1.0.0
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        //oldVersion
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(i) = " + list.get(i));
        }
        System.out.println("--------");

        //jdk1.5
        for (Integer data : list) {
            System.out.println("data = " + data);
        }
        System.out.println("--------");

        //jdk1.8
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("integer = " + integer);
            }
        });

    }
}
