package com.prosayj.springboot.spring5._01_circulardependencines;

import org.springframework.stereotype.Component;

//@Component
public class InstanceB {
    private InstanceA instanceA;

    public InstanceA getInstanceA() {
        return instanceA;
    }

    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }

    public InstanceB() {
        System.out.println("InstanceB实例化");
    }

    public InstanceB(InstanceA instanceA) {
        this.instanceA = instanceA;
    }
}
