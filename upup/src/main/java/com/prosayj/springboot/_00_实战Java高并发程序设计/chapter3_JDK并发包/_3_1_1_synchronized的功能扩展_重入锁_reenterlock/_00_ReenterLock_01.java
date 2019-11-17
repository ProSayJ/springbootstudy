package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 18:24
 * @since 1.0.0
 */
public class _00_ReenterLock_01 {
    public static int sum = 0;
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Mul2());
        Thread t2 = new Thread(new Mul2());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(sum);

    }

    static class Mul implements Runnable {
        @Override
        public void run() {
            synchronized (_00_ReenterLock_01.class) {
                for (int i = 0; i < 100000; i++) {
                    synchronized (_00_ReenterLock_01.class) {
                        sum += 1;
                    }
                }
            }
        }
    }

    static class Mul2 implements Runnable {
        @Override
        public void run() {
            lock.lock();
            lock.lock();
            lock.unlock();
            lock.unlock();
            lock.unlock();
            for (int i = 0; i < 100000; i++) {
                sum += 1;
            }
        }
    }

}
