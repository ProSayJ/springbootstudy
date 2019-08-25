package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_7_线程安全的概念和synchronized;

/**
 * @author yangjian
 * @description Synchronized:
 * 1>指定加锁对象：对给定的对象加锁，进入同步代码块前要获得给定对象的锁
 * 2>直接作用于实例方法，相当于对当前实例加锁，进入同步代码块前要获得当前实例的锁。
 * 3>直接作用于静态方法，相当于对当前类加锁，进入同步代码块前要获得当前类对象。
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class _01_AccountSync implements Runnable {
    static _01_AccountSync instance = new _01_AccountSync();
    static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            synchronized (instance) {
                i++;
            }
        }
    }
}
