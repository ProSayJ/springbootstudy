package com.prosayj.springboot.实战Java高并发程序设计.chapter2;


/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 16:59
 * @since 1.0.0
 */
public class NewThread00 {
    public static void main(String[] args) {
        //继承Thread
        MyThread t1 = new MyThread();
        //内部类
        Thread t2 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        //jdk1.8新特性
        Thread t3 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
//        _04线程的优先级.stop();


    }
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

