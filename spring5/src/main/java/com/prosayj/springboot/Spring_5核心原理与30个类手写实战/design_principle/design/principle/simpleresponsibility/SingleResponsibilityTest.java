package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility;


import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.simple.Course;
import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.simple.LiveCourse;
import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.simpleresponsibility.simple.ReplayCourse;

/**
 * Created by Tom.
 */
public class SingleResponsibilityTest {
    public static void main(String[] args) {
        Course course = new Course();
        course.study("直播课");
        course.study("录播课");

        LiveCourse liveCourse = new LiveCourse();
        liveCourse.study("直播课");

        ReplayCourse replayCourse = new ReplayCourse();
        replayCourse.study("录播课");


    }
}
