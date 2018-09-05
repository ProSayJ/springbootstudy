package com.prosayj.springboot.javase.jdk8_source;


import java.util.ArrayList;
import java.util.List;


/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/6/19 22:56
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(3);
        list.add("123");
        System.out.println(list.toString());
        System.out.println( 3 + (3 >> 1));//0110--> 0011
        System.out.println(3 *1.5);

    }
}
