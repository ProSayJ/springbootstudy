package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_7_线程安全的概念和synchronized;

/**
 * @author yangjian
 * @description 一种错误的加锁对象
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class _03_AccountSyncBad implements Runnable {
    static int i = 0;

    public  synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        _03_AccountSyncBad target = new _03_AccountSyncBad();
        Thread thread1 = new Thread(target);
        Thread thread2 = new Thread(target);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

}
