package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta1_实现自己的重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description
 * @Date 23:19 2018/8/5
 * @since 1.0.0
 */
public class Test {

    Lock lock = new ReentrantLock(false);


    public void a() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "   a");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
    }

    public static void main(String[] args) {

        Test t = new Test();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    t.a();
                }
            }
        }).start();


    }

}
