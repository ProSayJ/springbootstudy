package com.prosayj.springboot.jdk8_news._00_interface;

/**
 * @author yangjian
 * @description Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法
 * @email yangjian@bubi.cn
 * @creatTime 2018/3/14 15:24
 * @since 1.0.0
 */
public interface MyInterface {
    void sayHello();
    default void sayByebye(){
        System.out.println("default sayBaybay~~");
    }
}
