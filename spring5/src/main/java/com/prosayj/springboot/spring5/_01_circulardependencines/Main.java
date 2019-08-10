package com.prosayj.springboot.spring5._01_circulardependencines;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.prosayj.springboot.spring5");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        InstanceA bean = applicationContext.getBean(InstanceA.class);
        applicationContext.close();
    }
}
