package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 17:55
 * @since 1.0.0
 */
public class _07_BadSuspend {
    final static Object u = new Object();

    public static class ChangeObjectThread extends Thread {
        volatile boolean supendme = false;//5

        public void supendMe() {
            supendme = true;
        }

        public void resumeMe() {//11
            supendme = false;
            synchronized (this) {
                notify();
            }
        }

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    while (supendme) {//21
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (u) {
                    System.out.println("in changeOjectThread");
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
                    System.out.println("in readObjectThread");
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
        t1.supendMe();
        System.out.println("supend _00quitstart 2 sec");
        Thread.sleep(2000);
        System.out.println("resum _00quitstart");
        t1.resumeMe();
    }
}
