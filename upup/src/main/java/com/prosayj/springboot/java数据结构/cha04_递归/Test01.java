package com.prosayj.springboot.java数据结构.cha04_递归;

/**
 * @author yangjian
 * @description 简单的递归_阶乘
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/20 0:33
 * @since 1.0.0
 */
public class Test01 {
    public static void main(String[] args) {
        System.out.println(mul(10));
    }

    public static int mul(int i) {
        if (i == 1) {
            return i;
        } else {
            return mul(i - 1) * i;
        }
    }
}
