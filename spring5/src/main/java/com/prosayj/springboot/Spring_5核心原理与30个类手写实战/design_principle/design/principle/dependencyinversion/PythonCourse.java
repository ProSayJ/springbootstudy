package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.dependencyinversion;

/**
 * Created by Tom
 */
public class PythonCourse implements ICourse {
    @Override
    public void study() {
        System.out.println("Tom在学习Python课程");
    }
}
