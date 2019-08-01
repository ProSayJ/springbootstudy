package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_3_线程睡眠sleep_thread;

/**
 * @author yangjian
 * @description
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/8 上午 02:14
 * @since 1.0.0
 */
public class _00_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                if (Thread.currentThread().isInterrupted()) {//6
                    System.out.println("Interrupted!");
                    break;
                }
                try {
                    Thread.sleep(2000L);//19
                } catch (InterruptedException e) {
                    System.out.println("Interrupted when sleep");//13
                    //设置中断标记
                    Thread.currentThread().interrupt();//15
                    //Thread.currentThread();//16
                    e.printStackTrace();
                }
                Thread.yield();
            }
        });
        //主线程启动
        //t1线程启动
        t1.start();
        //主线程睡眠1s
        Thread.sleep(1000L);
        //主线程睡眠时间到,执行终端t1线程操作，此时t1仍然在睡眠。
        t1.interrupt();
        //t1睡眠被中断，19行抛出中断异常，catch内操作设置设置中断标志位,6行返回true，break线程
        //如果吧15行改成16行，则没有设置中断标志位，虽然有中断异常,但是程序不会停止。
    }
}
