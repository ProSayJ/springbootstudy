package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._03_函数式接口;

/**
 * @author yangjian
 * @description 如果有@FunctionalInterface注解，则：
 * 1：编译器会检查是否只有一个实现
 * 2：javadoc页面也会包含一条声明，说明该接口是函数式接口
 * 3：实现类在
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:32
 * @since 1.0.0
 */
@FunctionalInterface
public interface _02_MyFunctionalInterface {
    void m1();
    //void m2();
}
