package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 重入锁
 * @Date 0:31 2018/11/5
 * @since 1.0.0
 */
public class ReenterLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        ReenterLock reenterLock = new ReenterLock();
        Thread thread1 = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
