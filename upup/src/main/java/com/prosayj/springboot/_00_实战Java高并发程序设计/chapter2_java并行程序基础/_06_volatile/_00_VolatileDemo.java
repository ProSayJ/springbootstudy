package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._06_volatile;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class _00_VolatileDemo {
    private static volatile int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] ths = new Thread[10];

        for (int i = 0; i < 10; i++) {
            ths[i] = new Thread(() -> {
                for (int times = 0; times < 10000; times++) {
                    sum++;
                }
            });
            ths[i].start();
        }

        for (int i = 0; i < 10; i++) {
            ths[i].join();
        }
        System.out.println(sum);

    }
}