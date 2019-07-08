package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._03_wait_notify_thread;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/8 上午 02:14
 * @since 1.0.0
 */
public class _00_ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {//6
                        System.out.println("Interrupted!");
                        break;
                    }
                    try {//10
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted when sleep");//13
                        //设置中断标记
                        Thread.currentThread().interrupt();//15
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
