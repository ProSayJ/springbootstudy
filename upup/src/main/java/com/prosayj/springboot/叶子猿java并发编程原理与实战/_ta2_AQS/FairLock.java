package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta2_AQS;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description
 * @Date 23:20 2018/8/5
 * @since 1.0.0
 */
public class FairLock {
    private boolean isLocked = false;
    private Thread lockingThread = null;
    private List<QueueObject> waitingThreads = new ArrayList<>();

    public void lock() throws InterruptedException {
        QueueObject queueObject = new QueueObject();
        synchronized (this) {
            waitingThreads.add(queueObject);
        }

        try {
            queueObject.doWait();
        } catch (InterruptedException e) {
            synchronized (this) {
                waitingThreads.remove(queueObject);
            }
            throw e;
        }
    }

    public synchronized void unlock() {
        if (this.lockingThread != Thread.currentThread()) {
            throw new IllegalMonitorStateException("Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        if (waitingThreads.size() > 0) {
            waitingThreads.get(0).doNotify();
        }
    }
}