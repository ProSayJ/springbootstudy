package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包;

import java.util.concurrent.locks.LockSupport;

/**
 * @description
 * @author yangjian
 * @Date 0:29 2018/11/5
 * @since 1.0.0
 */
public class LockSupportIntDemo {
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
                LockSupport.park();
                if (Thread.interrupted()) {
                }
                System.out.println(getName() + "被中断");
            }
            System.out.println(getName() + "继续执行");
        }
    }


    public static void main(String args[]) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        LockSupport.unpark(t1);
        LockSupport.unpark(t2);
        t1.join();
        t2.join();
    }

}
