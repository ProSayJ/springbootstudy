package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.dependencyinversion;

/**
 * @author yangjian
 * @description
 * @Date 上午 01:48 2019/9/11
 * @since 1.0.0
 */
public class DependencyInversionTest {
    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setCourse(new JavaCourse());
        tom.study();

        tom.setCourse(new PythonCourse());
        tom.study();
    }


}
