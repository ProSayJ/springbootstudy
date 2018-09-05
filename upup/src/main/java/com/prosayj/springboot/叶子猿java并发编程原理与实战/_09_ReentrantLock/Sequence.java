package com.prosayj.springboot.叶子猿java并发编程原理与实战._09_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description
 * @Date 23:14 2018/8/5
 * @since 1.0.0
 */
public class Sequence {

    private int value;
    Lock lock = new ReentrantLock();
    Lock l1 = new ReentrantLock();

    /**
     * @return
     */
    public int getNext() {
        lock.lock();
        int a = value++;
        lock.unlock();
        return a;
    }

    public static void main(String[] args) {

        Sequence s = new Sequence();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }

}
