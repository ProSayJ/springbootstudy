package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_4_线程等待和唤醒_waitnotify_thread;

/**
 * @author yangjian
 * @description 说明被唤醒的线程在被notify之前会获取锁对象：
 * <p>
 * Object.wait()和 Thread.sleep()方法都可以让线程等待若干时间 。
 * <p>
 * 除了 wait（）可以被唤醒外 ， 另外一个主要区别就是：
 * wait()方法会释放目标对象的锁。
 * Thread.sleep()方法不会释放任何资源
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 02:06
 * @since 1.0.0
 */
public class _00_SimpleWN {
    final static Object object = new Object();

    public static class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T1 start");
                try {
                    //wait()方法先申请锁对象。
                    //然后执行等待方法，并且释放锁资源。
                    // wait方法是可以被唤醒的。
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 end");
            }
        }
    }

    public static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":T2 start notify one Thread");
                //notify()方法先会申请锁对象
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 end");
                try {
                    //Thread.sleep是不会释放锁资源的，直到休眠结束
                    // 所以，就算wait的线程被唤醒了
                    //但是获取不到锁资源，依然在阻塞，直到t2休眠结束
                    Thread.sleep(4000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new T1().start();
        new T2().start();
    }
}
