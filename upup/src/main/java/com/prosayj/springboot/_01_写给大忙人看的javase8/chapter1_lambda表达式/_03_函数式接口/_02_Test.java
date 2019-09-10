package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._03_函数式接口;

/**
 * @author yangjian
 * @description 测试
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:35
 * @since 1.0.0
 */
public class _02_Test {
    public static void main(String[] args) {

        new _02_MyFunctionalInterface() {
            @Override
            public void m1() {
                System.out.println("11111");
            }
        }.m1();

        _02_MyFunctionalInterface test02 = () -> System.out.println("hahah");
        test02.m1();
    }

}
