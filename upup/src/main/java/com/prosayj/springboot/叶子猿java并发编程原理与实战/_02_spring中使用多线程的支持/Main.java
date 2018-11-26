package com.prosayj.springboot.叶子猿java并发编程原理与实战._02_spring中使用多线程的支持;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 17:05
 * @since 1.0.0
 */
public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        DemoService bean = ac.getBean(DemoService.class);
        bean.m1();
        bean.m2();
//        ac.destroy();
    }
}
