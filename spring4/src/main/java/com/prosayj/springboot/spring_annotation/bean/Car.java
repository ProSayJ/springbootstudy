package com.prosayj.springboot.spring_annotation.bean;
/**
 * @description
 * @author yangjian
 * @Date 0:00 2018/9/25
 * @since 1.0.0
 */

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car constructor...");
    }

    public void init() {
        System.out.println("car ... init...");
    }

    public void detory() {
        System.out.println("car ... detory...");
    }

}
