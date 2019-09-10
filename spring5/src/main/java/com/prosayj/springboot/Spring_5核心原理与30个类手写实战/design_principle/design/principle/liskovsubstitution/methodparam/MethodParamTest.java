package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution.methodparam;

import java.util.HashMap;

/**
 * Created by Tom
 */
public class MethodParamTest {
    public static void main(String[] args) {
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
