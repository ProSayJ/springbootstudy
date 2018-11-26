package com.prosayj.springboot.叶子猿java并发编程原理与实战._01创建线程的几种方式;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangjian
 * @description 创建线程的方法：使用线程池
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:11
 * @since 1.0.0
 */
public class Demo06 {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        threadPool.shutdown();


        Executors.defaultThreadFactory().newThread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
                System.out.println(i);
            }
        }).start();   }
}
