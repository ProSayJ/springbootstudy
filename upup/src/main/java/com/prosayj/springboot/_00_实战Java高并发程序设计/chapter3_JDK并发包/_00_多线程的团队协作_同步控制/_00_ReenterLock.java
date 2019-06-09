package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_多线程的团队协作_同步控制;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 同一个线程允许多次获取一把锁
 * 主要的几个方法：
 * <p>
 * lock():获得锁，如果锁被占用，则等待。
 * lockInterruptibly():获得锁，但有先相应中断
 * tryLock():尝试获得锁，如果成功返回true，失败返回false，该方法不等待，立即返回
 * trylock(long time, TimeUnit unit):在给定的时间内获得锁。
 * unluck():释放锁：
 * <p>
 * 实现方式：
 * 1>原子状态：原子态使用CAS操作来村粗当前锁的状态，判断锁是否已经被别的线程持有。
 * 2>等待队列：没有请求到锁的线程会进入到一个等待队列中。
 * 3>阻塞原语park()和unpark()，用来挂起和恢复线程。
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
