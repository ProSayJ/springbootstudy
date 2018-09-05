package com.prosayj.springboot.jdk8_news;

import java.util.Arrays;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:41
 * @since 1.0.0
 */
public class _Test_01 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("zhangsan", "lizi", "wangwu", "zhaoliu", "chengqi");
//        before8(names);
        after8(names);
    }

    private static void after8(List<String> names) {
        names.forEach(name -> {
            System.out.println(name);
        });
    }

    private static void before8(List<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
