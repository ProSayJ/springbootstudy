package com.prosayj.springboot.javase.base.day02_operator.code;

/**
 * @param null
 * @author yangjian
 * @description 数据类型的转换自动:
    取值范围小的类型,自动转成取值范围大的类型一个类型 boolean 不参与类型转换
 * @Date 11:03 2018/1/15
 * @throws TODO
 * @since 1.0.0
 */
public class _03DataConvert {

    public static void main(String[] args) {
        //定义doublel类型的变量
        //出现类型自动转换,int自动转成double
        double d = 1000;
        System.out.println(d);
        //出现类型自动转换,int自动转成double
        int i = 100;
        double d2 = i;
        System.out.println(d2);

        byte b = 10;
        //自动类型转换,byte自动转成int
        int j = b;
        System.out.println(j);
    }
}