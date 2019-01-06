package com.prosayj.springboot.spring_annotation.bean;

/**
 * @author yangjian
 * @description
 * @Date 0:00 2018/9/25
 * @since 1.0.0
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color [car=" + car + "]";
    }


}
