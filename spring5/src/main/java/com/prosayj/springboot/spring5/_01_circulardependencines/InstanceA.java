package com.prosayj.springboot.spring5._01_circulardependencines;

import org.springframework.stereotype.Component;

//@Component
public class InstanceA {
    private InstanceB instanceB;

    public InstanceB getInstanceB() {
        return instanceB;
    }

    public void setInstanceB(InstanceB instanceB) {
        this.instanceB = instanceB;
    }

    public InstanceA() {
        System.out.println("InstanceA实例化");
    }

    public InstanceA(InstanceB instanceB) {
        this.instanceB = instanceB;
    }
}
