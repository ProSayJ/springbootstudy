package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author yangjian
 * @description LockSupport是非常方便的线程阻塞工具，它可以在线程内任意位置让线程阻塞。
 * <p>
 * 和Thread.suspend()相比，它弥补了由于resume()在发生前，导致线程无法继续执行的情况。
 * <p>
 * 和Objetc.wait()方法相比，它不需要先获得某个对象的锁，也不会抛出InterruptedExpection
 * @Date 0:29 2018/11/5
 * @since 1.0.0
 */
public class _10_LockSupportDemo {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {
                System.out.println("in " + getName());
                //静态方法，可以阻塞当前线程。类似的：  LockSupport.parkNanos();LockSupport.parkUntil();
                LockSupport.park();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread.sleep(122);
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }
}