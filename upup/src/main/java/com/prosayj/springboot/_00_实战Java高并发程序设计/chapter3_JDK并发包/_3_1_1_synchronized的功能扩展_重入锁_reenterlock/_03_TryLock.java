package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 19:51
 * @since 1.0.0
 */
public class _03_TryLock implements Runnable {

    public static ReentrantLock lock1 = new ReentrantLock();
    public static ReentrantLock lock2 = new ReentrantLock();
    int lock;

    public _03_TryLock(int lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        if (lock == 1) {
            while (true) {
                /**
                 *尝试获得锁，获得不到立马返回false，并不会等待
                 */
                if (lock1.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "===>My Job done;");
                                return;
                            } finally {
                                lock2.unlock();
                            }
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            }
        } else {
            while (true) {
                if (lock2.tryLock()) {
                    try {
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                        }
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + "===>My Job done;");
                            } finally {
                                lock1.unlock();
                            }
                            return;
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            }
        }
    }

    /**
     * 上面代码中采用了非常容易死锁的加锁顺序,导致thread1和thread2由于锁的竞争而互相等待从而引起死锁
     * <p>
     * 使用了tryLock后,线程不会一直等待而是不停的尝试去获得锁资源,只需要等待一定的时间,线程最终会获得所需要的资源
     *
     * @param args
     */
    public static void main(String args[]) {
        new Thread(new _03_TryLock(1), "线程1").start();
        new Thread(new _03_TryLock(2), "线程2").start();
    }
}