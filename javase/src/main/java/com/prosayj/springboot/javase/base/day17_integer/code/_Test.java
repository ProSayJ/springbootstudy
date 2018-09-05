package com.prosayj.springboot.javase.base.day17_integer.code;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/12 17:56
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        Integer i1 = new Integer(4);
        Long i2 = 4L;
        Integer i3 = new Integer(4);
        int i4 = 4;
        System.out.println(i2.equals(i1));
        System.out.println(i1.equals(i2));
        System.out.println(i1.equals(4));
        System.out.println(i2.equals(4));
        System.out.println(i1.equals(i3));
        System.out.println(i1.equals(i4));
    }
}
