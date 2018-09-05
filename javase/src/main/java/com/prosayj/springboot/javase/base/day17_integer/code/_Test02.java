package com.prosayj.springboot.javase.base.day17_integer.code;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/5 22:01
 * @since 1.0.0
 */
public class _Test02 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);// false
        System.out.println(e == f);// false
        System.out.println(c == (a + b));// true
        System.out.println(c.equals(a + b));//true
        System.out.println(g == (a + b));//true
        System.out.println(g.equals(a + b));//true
    }
}
