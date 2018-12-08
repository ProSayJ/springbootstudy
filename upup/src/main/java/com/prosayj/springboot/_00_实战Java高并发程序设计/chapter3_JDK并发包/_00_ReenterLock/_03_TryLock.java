package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description TODO
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
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getId() + "===>My Job done;");
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
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (lock1.tryLock()) {
                            System.out.println(Thread.currentThread().getId() + "===>My Job done;");
                            return;

                        }
                    } finally {
                        lock1.unlock();
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
        _03_TryLock r1 = new _03_TryLock(1);
        _03_TryLock r2 = new _03_TryLock(2);
        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();
    }
}
