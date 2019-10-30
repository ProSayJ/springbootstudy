package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.dependencyinversion;


/**
 * @description
 * @author yangjian
 * @Date 上午 01:47 2019/9/11
 * @since 1.0.0
 */
public class JavaCourse implements ICourse {

    @Override
    public void study() {
        System.out.println("Tom在学习Java课程");
    }
}
