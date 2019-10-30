package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.interfaced;

/**
 * Created by Tom
 */
public interface ICourse {

    //获得基本信息
    String getCourseName();

    //获得视频流
    byte[] getCourseVideo();

    //学习课程
    void studyCourse();
    //退款
    void refundCourse();
}
