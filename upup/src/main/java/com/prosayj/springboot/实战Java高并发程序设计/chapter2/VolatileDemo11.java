package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class VolatileDemo11 {
    private static /*volatile*/ AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {

        Thread[] ths = new Thread[10];

        for (int i = 0; i < 10; i++) {
            ths[i] = new Thread(new PushTask());
            ths[i].start();
        }

        for (int i = 0; i < 10; i++) {
            ths[i].join();
        }
        System.out.println(sum.toString());

    }

    public static class PushTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                sum.getAndIncrement();
            }
        }
    }
}


