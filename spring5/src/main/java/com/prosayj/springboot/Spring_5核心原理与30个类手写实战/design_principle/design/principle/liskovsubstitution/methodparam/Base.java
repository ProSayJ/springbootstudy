package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution.methodparam;

import java.util.HashMap;

/**
 * Created by Tom
 */
public class Base {
    public void method(HashMap map){
        System.out.println("父类被执行");
    }
}
