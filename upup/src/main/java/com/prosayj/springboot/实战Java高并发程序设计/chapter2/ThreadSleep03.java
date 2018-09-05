package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:13
 * @since 1.0.0
 */
public class ThreadSleep03 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("T1 START.....");
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {
                        /**
                         * 会让当前线程休眠若干时间，它会抛出一个 lnterruptedException 中断异常。InterruptedException不是运行时异常 ，
                         * 也就是说程序必须捕获并且处理它，当线程在sleep() 休眠时 ，如果被中断 ，这个异常就会产生 。
                         */
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");
                        //设置中断标记
                        Thread.currentThread().interrupt();
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(1000L);
        t1.interrupt();

    }
}
