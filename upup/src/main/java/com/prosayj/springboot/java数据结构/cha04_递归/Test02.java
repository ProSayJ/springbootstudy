package com.prosayj.springboot.java数据结构.cha04_递归;

import java.util.ArrayList;

/**
 * @author yangjian
 * @description 简单的阶乘_十进制转换成二进制
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/20 0:41
 * @since 1.0.0
 */
public class Test02 {
    public static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) {
        System.out.println(m1(15));
    }


    public static String m1(int i) {
        int end = i % 2;
        int i1 = i / 2;
        if (i1 == 0) {
            return sb.append(end).reverse().toString();
        } else {
            sb.append(end);
            return m1(i1);
        }
    }
}
