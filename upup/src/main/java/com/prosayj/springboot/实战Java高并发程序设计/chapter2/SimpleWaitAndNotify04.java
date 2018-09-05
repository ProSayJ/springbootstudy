package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description 说明被唤醒的线程在被notify之前会获取锁对象
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 17:39
 * @since 1.0.0
 */
public class SimpleWaitAndNotify04 {

    final static Object object = new Object();

    public static class Thread1 extends Thread {
        public void run() {
            synchronized (object) {//6
                System.out.println(System.currentTimeMillis() + ":thread1 start !");
                try {
                    System.out.println(System.currentTimeMillis() + ":thread1 wait for object !");
                    object.wait();
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
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":thread2 start ! notify one thread");
                object.notify();
                try {
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

    //wait()方法会释放目标对象的锁,而Thread.sleep()方法不会释放任何资源.
}
