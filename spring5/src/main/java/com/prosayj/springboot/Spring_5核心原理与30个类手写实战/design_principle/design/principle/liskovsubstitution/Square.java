package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution;

/**
 * 正方形
 * Created by Tom
 */
public class Square implements Quadrangle {
    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public long getWidth() {
        return length;
    }

    @Override
    public long getHeight() {
        return length;
    }
}
