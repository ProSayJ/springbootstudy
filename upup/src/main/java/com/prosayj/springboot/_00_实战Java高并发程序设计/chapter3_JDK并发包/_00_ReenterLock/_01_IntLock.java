package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 重入锁的中断
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 19:32
 * @since 1.0.0
 */
public class _01_IntLock implements Runnable {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();
    private int lock;

    public _01_IntLock(int lock) {
        this.lock = lock;
    }

    /**
     * 中断响应lockInterruptibly
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        _01_IntLock r1 = new _01_IntLock(1);
        _01_IntLock r2 = new _01_IntLock(2);

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

        //主线程休眠，其他两个用户线程处于死锁状态。
        Thread.sleep(3000);

        thread2.interrupt();

    }

    @Override
    public void run() {
        try {
            if (lock == 1) {
                //lockInterruptibly可中断的请求锁的方法
                lock1.lockInterruptibly();
                Thread.sleep(500);
                lock2.lockInterruptibly();
            } else {
                lock2.lockInterruptibly();
                Thread.sleep(500);
                lock1.lockInterruptibly();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock1.isHeldByCurrentThread()) {
                lock1.unlock();
            }
            if (lock2.isHeldByCurrentThread()) {
                lock2.unlock();
            }
            System.out.println(Thread.currentThread().getId() + ":线程退出");
        }
    }
}
