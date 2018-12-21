package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_多线程的团队协作_同步控制;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 锁申请等待限时tryLock
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 19:45
 * @since 1.0.0
 */
public class _02_TimeLock implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();

    public static void main(String args[]) {
        _02_TimeLock timeLock = new _02_TimeLock();
        Thread thread1 = new Thread(timeLock);
        Thread thread2 = new Thread(timeLock);

        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        try {
            //如果5s没有获得锁，则停止获取
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


}
