package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._03_wait_notify_thread;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/8 上午 09:06
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Interruted");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interruted when sleep!");
                    //设置中断标识
                    Thread.currentThread().interrupt();
                }
                Thread.yield();
            }
        });
        t1.start();
        Thread.sleep(2000L);
        t1.interrupt();
    }

}
