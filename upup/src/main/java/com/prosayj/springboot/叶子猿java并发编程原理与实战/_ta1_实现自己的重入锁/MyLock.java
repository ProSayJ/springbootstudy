package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta1_实现自己的重入锁;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author yangjian
 * @description 自定义锁
 * @Date 23:17 2018/8/5
 * @since 1.0.0
 */
public class MyLock implements Lock {

    /**
     * 标志位
     */
    private boolean isLocked = false;
    /**
     * 当前线程作为所对象
     */
    private Thread lockBy = null;

    private int lockCount = 0;

    @Override
    public synchronized void lock() {
        // ...

        Thread currentThread = Thread.currentThread();

        //不可重入
        //while (isLocked) {
        while (isLocked && currentThread != lockBy) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isLocked = true;
        lockBy = currentThread;
        lockCount++;
    }

    @Override
    public synchronized void unlock() {
        if (lockBy == Thread.currentThread()) {
            lockCount--;
            if (lockCount == 0) {
                notify();
                isLocked = false;
            }
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }


    @Override
    public Condition newCondition() {
        return null;
    }

}
