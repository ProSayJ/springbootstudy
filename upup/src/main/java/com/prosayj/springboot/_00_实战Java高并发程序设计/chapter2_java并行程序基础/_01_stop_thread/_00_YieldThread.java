package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._01_stop_thread;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/24 15:12
 * @since 1.0.0
 */
public class _00_YieldThread {
    volatile static int i = 0;
    volatile static int j = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                i++;
                Thread.yield();
            }
        });
        Thread t2 = new Thread() {
            @Override
            public void run() {
                while (true) {
                    j++;
                    Thread.yield();
                }
            }
        };
        t1.start();
        t2.start();
        Thread.sleep(2000);
        System.out.println("i=" + i);
        System.out.println("j=" + j);
        t1.stop();
        t2.stop();
    }
}
