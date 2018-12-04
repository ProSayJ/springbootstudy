package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 同一个线程允许多次获取一把锁
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 19:09
 * @since 1.0.0
 */
public class _00_ReenterLock implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
                lock.unlock();
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        _00_ReenterLock reenterLock = new _00_ReenterLock();
        Thread thread1 = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
