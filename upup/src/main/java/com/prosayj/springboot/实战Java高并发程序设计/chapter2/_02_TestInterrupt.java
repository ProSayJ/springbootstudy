package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:04
 * @since 1.0.0
 */
public class _02_TestInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
//                    Thread.yield();
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(2000L);
        System.out.println(t1.getName() + "是否被中断了呢？_00===>" + t1.isInterrupted());

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
