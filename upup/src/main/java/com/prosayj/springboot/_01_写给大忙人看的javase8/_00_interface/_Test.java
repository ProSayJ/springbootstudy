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
