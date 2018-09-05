package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 18:24
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        int v1 = 1073741827;
        int v2 = 1431655768;
        System.out.println("v1=" + v1);
        System.out.println("v2=" + v2);
        int avg = (v1 + v2) / 2;
        System.out.println("avg=" + avg);

    }


}
