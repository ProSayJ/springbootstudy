package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta1_实现自己的重入锁;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 测试自定义锁的重入性
 * @Date 23:15 2018/8/5
 * @since 1.0.0
 */
public class Demo {

    Lock lock = new ReentrantLock();

    public void a() {
        lock.lock();
        System.out.println("a");
        b();
        lock.unlock();
    }

    public void b() {
        lock.lock();
        System.out.println("b");
        c();
        lock.unlock();
    }

    public void c() {
        lock.lock();
        System.out.println("c");
        lock.unlock();
    }

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Demo d = new Demo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                d.a();
            }
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                d.b();
            }
        }).start();

    }

}
