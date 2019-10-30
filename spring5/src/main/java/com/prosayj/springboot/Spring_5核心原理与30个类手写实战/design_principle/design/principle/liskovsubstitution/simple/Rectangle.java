package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution.simple;

/**
 * 长方形
 * Created by Tom
 */
public class Rectangle {
    private long height;
    private long width;

    public long getWidth() {
        return width;
    }

    public long getHeight() {
        return height;
    }

    public void setHeight(long height) {
        this.height = height;
    }

    public void setWidth(long width) {
        this.width = width;
    }
}
