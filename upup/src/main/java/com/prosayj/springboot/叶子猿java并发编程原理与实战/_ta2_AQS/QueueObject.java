package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta2_AQS;

/**
 * @author yangjian
 * @description
 * @Date 23:20 2018/8/5
 * @since 1.0.0
 */
public class QueueObject {

    private boolean isNotified = false;

    public synchronized void doWait() throws InterruptedException {

        while (!isNotified) {
            this.wait();
        }

        this.isNotified = false;

    }

    public synchronized void doNotify() {
        this.isNotified = true;
        this.notify();
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

}
