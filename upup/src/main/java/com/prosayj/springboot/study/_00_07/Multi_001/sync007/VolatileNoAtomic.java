package com.prosayj.springboot.study._00_07.Multi_001.sync007;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangjian
 * @description volatile关键字不具备synchronized关键字的原子性（同步）
 * @Date 18:49 2018/5/18
 * @since 1.0.0
 */
public class VolatileNoAtomic extends Thread {
    //private static volatile int count;
    private static AtomicInteger count = new AtomicInteger(0);

    private static void addCount() {
        for (int i = 0; i < 1000; i++) {
            //count++ ;
            count.incrementAndGet();
        }
        System.out.println(count);
    }

    public void run() {
        addCount();
    }

    public static void main(String[] args) {

        VolatileNoAtomic[] arr = new VolatileNoAtomic[100];
        for (int i = 0; i < 10; i++) {
            arr[i] = new VolatileNoAtomic();
        }

        for (int i = 0; i < 10; i++) {
            arr[i].start();
        }
    }


}
