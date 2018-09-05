package com.prosayj.springboot.叶子猿java并发编程原理与实战._06重入锁和死锁;

import java.util.Random;

/**
 * @author yangjian
 * @description 自旋的demo
 *              多个线程执行完毕之后，打印一句话，结束
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/5 23:03
 * @since 1.0.0
 */
public class Demo2 {

    public static void main(String[] args) {

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 线程执行...");

                try {
                    Thread.sleep(new Random().nextInt(2000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 线程执行完毕了...");
            }
        }).start();

        while (Thread.activeCount() != 1) {
            // 自旋：即获取cpu的时间片
        }
        System.out.println("所有的线程执行完毕了...");
    }

}
