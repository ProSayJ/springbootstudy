package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._08_接口中的静态方法;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/11 上午 08:41
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        _01_InterfaceStaticMethod interfaceStaticMethod = () -> "重写接口中的m2方法";
        System.out.println(interfaceStaticMethod.m3());
        System.out.println(interfaceStaticMethod.m2());
        System.out.println(_01_InterfaceStaticMethod.m1());
    }
}
