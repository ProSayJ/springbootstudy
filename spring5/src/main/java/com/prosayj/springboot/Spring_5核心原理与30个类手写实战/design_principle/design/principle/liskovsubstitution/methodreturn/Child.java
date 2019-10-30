package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.design_principle.design.principle.liskovsubstitution.methodreturn;

import java.util.HashMap;

/**
 * Created by Tom
 */
public class Child extends Base {
    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("子类method被执行");
        hashMap.put("message","子类method被执行");
        return hashMap;
    }
}
