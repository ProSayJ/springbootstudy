package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_3_线程中断_interrupt_thread;

/**
 * @author yangjian
 * @description 三个方法：
 *
 * t1.interrupt();//中断线程,实例方法
 * t1.isInterrupted();//判断是否被中断
 * Thread.interrupted();//判断是否被中断，并清除当前的中断状态（清除为false）
 *
 * @email yangjian@bubi.cn
 * @creatTime 2018/7/31 09:04
 * @since 1.0.0
 */
public class _00_ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread.yield();
            }
        });
        t1.start();
        Thread.sleep(2000L);
        //t1不会停止
        t1.interrupt();
    }
}
