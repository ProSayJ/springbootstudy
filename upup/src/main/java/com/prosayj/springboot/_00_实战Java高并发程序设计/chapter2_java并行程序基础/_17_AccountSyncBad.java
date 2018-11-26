package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class _17_AccountSyncBad implements Runnable {
    static volatile int i = 0;

    public /*static*/ synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        //成员方法锁的是各自自己对象的锁，所以没有意义
        Thread thread1 = new Thread(new _17_AccountSyncBad());
        Thread thread2 = new Thread(new _17_AccountSyncBad());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
