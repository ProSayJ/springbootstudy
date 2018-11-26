package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础;


/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class _10_VolatileDemo {
    private static volatile int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread[] ths = new Thread[10];

        for (int i = 0; i < 10; i++) {
            ths[i] = new Thread(new PushTask());
            ths[i].start();
        }

        for (int i = 0; i < 10; i++) {
            ths[i].join();
        }
        System.out.println(sum);

    }

    public static class PushTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                synchronized (lock) {
                    sum++;
                }
            }
        }
    }
}


