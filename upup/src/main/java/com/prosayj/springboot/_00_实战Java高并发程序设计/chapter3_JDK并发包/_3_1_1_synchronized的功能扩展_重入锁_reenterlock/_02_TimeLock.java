package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

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

    public static void main(String args[]) {
        _02_TimeLock tl = new _02_TimeLock();
        new Thread(tl,"线程1").start();
        new Thread(tl,"线程2").start();
    }


}
