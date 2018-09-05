package com.prosayj.springboot.spring4.day02.a_annotation;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring4.day02.bean.User;


public class Demo {
    @Test
    public void fun1() {

        //1 创建容器对象
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring4/day02/a_annotation/applicationContext.xml");
        //2 向容器"要"user对象
        User u1 = (User) ac.getBean("user");
        User u2 = (User) ac.getBean("user");

        System.out.println(u1 == u2);
        //3 打印user对象
        System.out.println(u1);

        ac.close();


    }

}
