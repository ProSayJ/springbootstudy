package com.prosayj.springboot.javase.homework.day01_a;


/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:20
 * @since 1.0.0
 */
public class _Test01 {
    public static void main(String[] args) {
        System.out.println("00当前线程是主线程，名称是：" + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            new MyThread_01().start();
            new Thread(new MyThread_02()).start();
        }
    }
}

class MyThread_01 extends Thread {
    @Override
    public void run() {
        System.out.println("11当前线程是第一个线程，名称是：" + Thread.currentThread().getName());
    }
}

class MyThread_02 implements Runnable {

    @Override
    public void run() {
        System.out.println("22当前线程是第二个线程，名称是：" + Thread.currentThread().getName());
    }
}