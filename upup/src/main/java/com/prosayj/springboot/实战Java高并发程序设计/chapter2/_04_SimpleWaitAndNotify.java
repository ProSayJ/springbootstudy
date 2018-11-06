package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description 说明被唤醒的线程在被notify之前会获取锁对象
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 17:39
 * @since 1.0.0
 */
public class _04_SimpleWaitAndNotify {

    final static Object object = new Object();

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":thread1 start !");
                try {
                    System.out.println(System.currentTimeMillis() + ":thread1 wait for object !");
                    //mian保证了t1先执行。t1执行wait()方法自己等待，但是会释放锁资源。
                    object.wait();
                    System.out.println(System.currentTimeMillis() + ":thread1 被唤醒，获取锁资源中。。。 !");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":thread1 end!");
            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                // 在main休眠500毫秒以后，t2被执行
                System.out.println(System.currentTimeMillis() + ":thread2 start ! notify one thread");
                //锁唤醒一个休眠的线程，
                object.notify();
                try {
                    //t2在唤醒一个线程以后，自己立马睡眠，sleep是不会释放锁资源的，直到休眠结束，所以，就算wait的线程被唤醒了
                    //但是获取不到锁资源，依然在阻塞，直到t2休眠结束
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":thread2 end!");
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        //为了保证t1在t2之前执行
        Thread.sleep(500);
        thread2.start();
    }

    //Object.wait()和 Thread.sleep()方法都可以让线程等待若干时间 。
    // 除了 wait（）可以被唤醒外 ， 另外一个主要区别就是wait()方 法会释放目 标对 象的锁 ， 而Thread.sleep（）方法不会释放任何资源
}
