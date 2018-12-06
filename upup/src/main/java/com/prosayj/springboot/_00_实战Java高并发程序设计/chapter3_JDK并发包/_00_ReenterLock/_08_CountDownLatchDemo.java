package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangjian
 * @description 多线程控制工具类。倒计数器，他可以让某个线程等待直到倒计时结束，再开始执行。
 * @email yangjian@bubi.cn
 * @creatTime 2018/12/6 17:12
 * @since 1.0.0
 */
public class _08_CountDownLatchDemo {
    //表示需要有10个线程完成了任务，主线程才能继续执行。
    static final CountDownLatch end = new CountDownLatch(10);
    static final _08_CountDownLatchDemo demo = new _08_CountDownLatchDemo();

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                try {
                    //模拟检查任务
                    Thread.sleep(new Random().nextInt(3) * 1000);
                    System.out.println("check complete");
                    end.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        //等待检查:主线程再CountDownLatch上等待，当所有检查任务全部完成后，主线程才能继续执行。
        end.await();
        //发射火箭
        System.out.println("Fire!");
        executorService.shutdown();
    }
}

