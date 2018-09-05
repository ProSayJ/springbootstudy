package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description demo说明sleep会持有锁
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:45
 * @since 1.0.0
 */
public class SimpleWaitAndNotify05 {
    final static Object object = new Object();

    public static class T1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":_00quitstart 开始执行 !");
                try {
                    System.out.println(System.currentTimeMillis() + ":_00quitstart 等待被唤醒 !");
                    /**
                     * Object.wait（）方法并不是可以随便调用的 。
                     * 它必须包含在对应的 synchronized 语句中，
                     * 无论是wait（）或者 notify（）都需要首先获得目标对象的一个监视器
                     */
                    object.wait();

                    System.out.println(System.currentTimeMillis() + ":_00quitstart 睡眠4秒，在此期间不会释放锁，不能被唤醒 !");
                    Thread.sleep(4000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":_00quitstart 被唤醒，t1结束 !");
            }
        }
    }

    public static class T2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":_01创建线程的几种方式 开始执行,t2第一次尝试唤醒t1，" +
                        "虽然此时t1已经在等待,已经释放了锁，但是t1又睡眠了，睡眠又持有了锁，t2获取不到监视器，t1不会被唤醒");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":_01创建线程的几种方式 结束!");
            }
        }
    }

    public static void main(String args[]) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }

    //wait()方法会释放目标对象的锁,而Thread.sleep()方法不会释放任何资源.
}
