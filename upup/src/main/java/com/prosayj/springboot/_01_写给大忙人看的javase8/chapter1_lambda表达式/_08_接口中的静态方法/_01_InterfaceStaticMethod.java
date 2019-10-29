package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._08_接口中的静态方法;

/**
 * @author yangjian
 * @description 接口中的静态方法和默认方法
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/11 上午 08:39
 * @since 1.0.0
 */
public interface _01_InterfaceStaticMethod {
    static String m1() {
        return "我是接口中的静态方法";
    }

    default String m2() {
        return "我是接口中的默认方法";
    }

    String m3();

}
