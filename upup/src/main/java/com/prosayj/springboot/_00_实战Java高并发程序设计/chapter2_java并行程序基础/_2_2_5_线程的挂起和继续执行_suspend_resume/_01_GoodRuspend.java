package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_5_线程的挂起和继续执行_suspend_resume;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 03:27
 * @since 1.0.0
 */
public class _01_GoodRuspend {
    final static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        volatile boolean suspendme = false;//5

        public void suspendMe() {
            suspendme = true;
        }

        public void resumeMe() {//11
            suspendme = false;
            synchronized (this) {
                notify();
            }
        }//16

        @Override
        public void run() {
            while (true) {
                synchronized (this) {//21
                    while (suspendme) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }//28
                synchronized (u) {
                    System.out.println("in ChangeObjectThread");
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        @Override
        public void run() {
            while (true) {
                synchronized (u) {
                    System.out.println("in ReadObjetThread");
                }
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ChangeObjectThread t1 = new ChangeObjectThread();
        ReadObjectThread t2 = new ReadObjectThread();
        t1.start();
        t2.start();
        Thread.sleep(1000);
        t1.suspendMe();
        System.out.println("suspend t1 2 sec");
        Thread.sleep(2000);
        System.out.println("suspend t1");
        t1.resumeMe();
    }
}
