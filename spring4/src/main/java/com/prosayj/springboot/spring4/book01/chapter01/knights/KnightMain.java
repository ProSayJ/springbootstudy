package com.prosayj.springboot.spring4.book01.chapter01.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring4/book01/chapter01/knight.xml");
        Knight knight = context.getBean(Knight.class);
//        Knight knight = (Knight)context.getBean("123");
        knight.embarkOnQuest();
        context.close();
    }

}
