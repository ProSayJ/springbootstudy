package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_4_线程等待和唤醒waitnotify_thread;

/**
 * @author yangjian
 * @description
 * demo说明sleep会持有锁，wait 和 notify会释放锁对象
 * wait()方法会释放目标对象的锁,而Thread.sleep()方法不会释放任何资源.
 *
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:45
 * @since 1.0.0
 */
public class _03_SimpleWaitAndNotify {
    final static Object object = new Object();


    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":t1开始执行 !");
                try {
                    System.out.println(System.currentTimeMillis() + ":t1 等待被唤醒 !");
                    /**
                     * Object.wait（）方法并不是可以随便调用的 。
                     * 它必须包含在对应的 synchronized 语句中，
                     * 无论是wait（）或者 notify（）都需要首先获得目标对象的一个监视器
                     */
                    object.wait();
                    System.out.println(System.currentTimeMillis() + ":t1 已经被被唤醒 !");
                    System.out.println(System.currentTimeMillis() + ":t1  睡眠4秒，在此期间不会释放锁!!");
                    Thread.sleep(4000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":t1线程执行结束 !");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":t2开始执行");
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":t2唤醒已经在等待的线程");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":t2开始尝试睡眠，但是");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":t2线程执行结束!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        Thread.sleep(500L);
        t2.start();
    }

}
