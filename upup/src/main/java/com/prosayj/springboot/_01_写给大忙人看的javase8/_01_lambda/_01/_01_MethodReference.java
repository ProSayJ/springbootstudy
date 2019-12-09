package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._01;

import org.junit.Test;

/**
 * @author yangjian
 * @description 方法引用
 * </P>
 * 对象::实例方法
 * 类::静态方法
 * 类::实例方法
 * </P>
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/10 15:53
 * @since 1.0.0
 */
public class _01_MethodReference {
    @Test
    public void m1() {
        //当线程启动，会调用Runnable方法。然后执行super::greet并调用父类的greet方法。
        new ConcurrentGreeter().greet();
    }
}

class Greeter {
    public void greet() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Hello World");
    }
}

class ConcurrentGreeter extends Greeter {
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}
