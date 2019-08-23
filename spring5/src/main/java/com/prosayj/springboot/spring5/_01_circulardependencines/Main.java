package com.prosayj.springboot.spring5._01_circulardependencines;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {
//        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.prosayj.springboot.spring5");
        //创建IOC容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        //去容器缓存中获取
        InstanceA bean = applicationContext.getBean(InstanceA.class);

        InstancePersion bean1 = applicationContext.getBean(InstancePersion.class);
        System.out.println(bean1.getName());
        applicationContext.close();
    }
}
