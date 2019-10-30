package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.interfaced;
/**
 * Created by Tom
 */
public class CourseImpl implements ICourseManager,ICourseInfo {
    @Override
    public void studyCourse() {

    }

    @Override
    public void refundCourse() {

    }

    @Override
    public String getCourseName() {
        return null;
    }

    @Override
    public byte[] getCourseVideo() {
        return new byte[0];
    }
}
