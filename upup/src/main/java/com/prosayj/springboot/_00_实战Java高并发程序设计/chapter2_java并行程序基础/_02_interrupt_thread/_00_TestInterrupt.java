package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._02_interrupt_thread;

/**
 * @author yangjian
 * @description
 * 三个方法：
 *      t1.interrupt();//中断线程,实例方法
 *      t1.isInterrupted();//判断是否被中断
 *      Thread.interrupted();//判断是否被中断，并清除当前的中断状态（清除为false）
 *
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:04
 * @since 1.0.0
 */
public class _00_TestInterrupt {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println(Thread.currentThread().getName());
//                    Thread.yield();
                if (Thread.currentThread().isInterrupted()) {
                    break;
                }
            }
        });

        t1.start();
        Thread.sleep(1000L);
        System.out.println(t1.getName() + "是否被中断了呢？_00_函数式编程基础===>" + t1.isInterrupted());

        //它通知当前线程中断，也就是设置中断标志位。中断标志位表示当前线程己经被中断了。jvm会在安全的时候停止线程。
        t1.interrupt();
        System.out.println(t1.getName() + "是否被中断了呢？_02===>" + t1.isInterrupted());

        //判断是否被中断，并清除当前中断状态
        System.out.println("判断是否被中断，并清除当前中断状态:是否被中断了呢？_03===>" + Thread.interrupted());

        System.out.println(t1.getName() + "是否被中断了呢？_04===>" + t1.isInterrupted());
        System.out.println(t1.getName() + "是否被中断了呢？_05===>" + t1.isInterrupted());
        System.out.println(Thread.currentThread().getName() + "是否被中断了呢？_06===>" + Thread.currentThread().isInterrupted());


    }
}
