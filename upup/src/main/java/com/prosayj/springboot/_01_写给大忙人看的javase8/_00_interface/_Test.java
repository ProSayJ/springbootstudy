package com.prosayj.springboot._01_写给大忙人看的javase8._00_interface;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:29
 * @since 1.0.0
 */
public class _Test implements MyInterface {
    @Override
    public void sayHello() {
        System.out.println("zhang san say hello~~~~");
    }

    public static void main(String[] args) {
        MyInterface myInterface = new _Test();
        myInterface.sayHello();
        myInterface.sayByebye();
    }
}

/**
 * Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法
 */
interface MyInterface {
    void sayHello();

    default void sayByebye() {
        System.out.println("default sayBaybay~~");
    }
}