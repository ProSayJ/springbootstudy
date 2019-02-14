package com.prosayj.springboot._01_写给大忙人看的javase8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:33
 * @since 1.0.0
 */
public class _Test_00 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lizi", "wangwu", "zhaoliu", "chengqi");
        System.out.println(names.toString());

        before8(names);
        after8(names);
        System.out.println(names.toString());
    }

    private static void after8(List<String> names) {
      /*  Collections.sort(names, (String s1, String s2) -> {
            return s1.compareTo(s2);
        });*/
        Collections.sort(names, (a, b) -> b.compareTo(a));
    }

    //jdk8之前
    private static void before8(List<String> names) {
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }
}
