package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_7_线程安全的概念和synchronized;

/**
 * @author yangjian
 * @description 锁实例方法
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 11:44
 * @since 1.0.0
 */
public class _02_AccountSync_02 implements Runnable {
    static _02_AccountSync_02 instance = new _02_AccountSync_02();
    static int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(instance);
        Thread t2 = new Thread(instance);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);


    }
}
