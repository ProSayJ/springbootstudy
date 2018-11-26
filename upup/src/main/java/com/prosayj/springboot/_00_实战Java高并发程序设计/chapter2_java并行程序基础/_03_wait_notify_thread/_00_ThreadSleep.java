package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._03_wait_notify_thread;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:13
 * @since 1.0.0
 */
public class _00_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("T1 START.....");
                    //如果线程被中断，则停止循环

                    //判断以后不重置标记位置
                    if (Thread.currentThread().isInterrupted()) {
                    //判断以后重置标记位置
                    //if (Thread.interrupted()) {
                        System.out.println("Interrupted!,此时线程中断标记是：" + Thread.currentThread().isInterrupted());
                        break;
                    }
                    try {
                        /**
                         * 会让当前线程休眠若干时间，它会抛出一个 interruptedException 中断异常。
                         * InterruptedException不是运行时异常 ，
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
        /**
         * t1线程启动，如果在循环的两秒时间内，外部应用调用t1的中断线程方法interrupt(),则线程立即中断。
         * 并设置中断标记位为中断（true）
         */
        t1.start();
        Thread.sleep(1000L);
        t1.interrupt();

    }
}
