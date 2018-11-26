package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class _16_AccountSync implements Runnable {

    static _16_AccountSync instance = new _16_AccountSync();
    static volatile int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            /**
             * synchronized的作用是实现线程间的同步,对同步的代码加锁,使得每一次都只能有一个线程进入同步块从而保证线程间的安全性.
             */
            synchronized (instance) {
                i++;
            }
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
