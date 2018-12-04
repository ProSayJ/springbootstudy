package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._06_volatile;


/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class _01_VolatileDemo {
    private static volatile int sum = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread[] ths = new Thread[10];

        for (int i = 0; i < 10; i++) {
            //主线程睡眠是为了让其他线程顺序启动
            ths[i] = new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "==> add start!");
                for (int times = 0; times < 10000; times++) {
                    synchronized (lock) {
                        sum++;
                    }
                }
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "==> add end!");
            });
            ths[i].start();

        }
        for (int i = 0; i < 10; i++) {
            ths[i].join();
        }
        System.out.println(sum);
    }
}