package com.prosayj.springboot.叶子猿java并发编程原理与实战._02_spring中使用多线程的支持;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 17:04
 * @since 1.0.0
 */
@Service
public class DemoService {
    @Async
    public void m1() {
        while (true) {
            System.out.println("1");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Async
    public void m2() {
        while (true) {
            System.out.println("2");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @PostConstruct
    public void m3() {
        System.out.println("对象创建已完成");
    }

    @PreDestroy
    public void m4() {
        System.out.println("即将被销毁");
    }
}
