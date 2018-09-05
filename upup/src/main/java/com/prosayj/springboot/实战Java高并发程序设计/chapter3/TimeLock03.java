package com.prosayj.springboot.实战Java高并发程序设计.chapter3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 19:45
 * @since 1.0.0
 */
public class TimeLock03 implements Runnable {

    public static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + "===>get lock success");
                Thread.sleep(6000);
            } else {
                System.out.println(Thread.currentThread().getName() + "===>get lock failed");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }

    /**
     * 锁申请等待限时tryLock
     *
     * @param args
     */
    public static void main(String args[]) {
        TimeLock03 timeLock = new TimeLock03();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);

        thread1.start();
        thread2.start();
    }
}
