package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_7_线程安全的概念和synchronized;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:51
 * @since 1.0.0
 */
public class _00_AccountingVol {
    private static volatile int i = 0;

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            add();
        });

        Thread thread2 = new Thread(() -> {
            add();
        });
        thread1.start();
        thread2.start();
        //两个join阻塞了主线程，保证了thread1和thread1执行完成之后主线程才打印出i的值。
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    private static void add() {
        for (int j = 0; j < 10000000; j++) {
            i++;
        }
        System.out.println(Thread.currentThread().getName() + " end~~~");
    }
}
