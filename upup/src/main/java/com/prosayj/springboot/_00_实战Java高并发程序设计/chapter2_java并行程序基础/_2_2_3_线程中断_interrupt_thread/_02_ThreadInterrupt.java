package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_3_线程中断_interrupt_thread;

public class _02_ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                Thread.yield();
                //判断但是不清空当前线程实例的标志位:实例不清空的标志位为：true,即标志位默认为false
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("使用对象实例方法，线程已经被清空标志位了吗？==>" + Thread.currentThread().isInterrupted());
                    //使用对象实例方法，线程已经被清空标志位了吗？==>true
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
