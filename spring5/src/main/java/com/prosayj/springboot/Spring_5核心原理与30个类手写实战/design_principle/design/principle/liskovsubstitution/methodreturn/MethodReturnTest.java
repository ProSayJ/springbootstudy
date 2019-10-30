package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution.methodreturn;


/**
 * Created by Tom
 */
public class MethodReturnTest {
    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.method());

    }
}
