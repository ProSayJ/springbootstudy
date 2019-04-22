package com.prosayj.springboot.halo.listener;

import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class TestPreDestory {
    @PreDestroy
    public void destory() {

        System.out.println("@PreDestory的方式");
    }
}
