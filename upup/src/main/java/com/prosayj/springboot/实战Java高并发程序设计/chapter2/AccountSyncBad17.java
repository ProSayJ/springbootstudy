package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class AccountSyncBad17 implements Runnable {
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
        Thread thread1 = new Thread(new AccountSyncBad17());
        Thread thread2 = new Thread(new AccountSyncBad17());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
