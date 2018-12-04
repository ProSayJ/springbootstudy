package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._10_synchronized;

/**
 * @author yangjian
 * @description Synchronized:
    1>指定加锁对象：对给定的对象加锁，进入同步代码块前要获得给定对象的锁
    2>直接作用于实例方法，相当于对当前实例加锁，进入同步代码块前要获得当前实例的锁。
    3>直接作用于静态方法，相当于对当前类加锁，进入同步代码块前要获得当前类对象。

 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:59
 * @since 1.0.0
 */
public class _01_AccountSync {
    private static volatile int i = 0;

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int j = 0; j < 10000000; j++) {
                synchronized (_01_AccountSync.class) {
                    i++;
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int j = 0; j < 10000000; j++) {
                synchronized (_01_AccountSync.class) {
                    i++;
                }
            }
        });
        thread1.start();
        thread2.start();

        //两个join阻塞了主线程，保证了thread1和thread1执行完成之后主线程才打印出i的值。
        thread1.join();
        thread2.join();

        System.out.println(i);
    }
}
