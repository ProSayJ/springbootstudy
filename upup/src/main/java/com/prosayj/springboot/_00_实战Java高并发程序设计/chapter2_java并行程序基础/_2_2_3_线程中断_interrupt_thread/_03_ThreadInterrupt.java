package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_3_线程中断_interrupt_thread;

public class _03_ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread.yield();
                //判断并清空当前线程实例的标志位:实例清空的标志位为：false。即标志位默认为false
                if (Thread.interrupted()) {
                    System.out.println("使用Thread的静态方法，实例线程已经被清空标志位了吗？==>" + Thread.currentThread().isInterrupted());
                    //使用Thread的静态方法，实例线程已经被清空标志位了吗？==>false
                    break;
                }
            }
        });
        t1.start();
        Thread.sleep(2000L);
        //t1停止
        t1.interrupt();
    }
}
