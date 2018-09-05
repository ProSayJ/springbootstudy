package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 17:55
 * @since 1.0.0
 */
public class BadSuspend06 {
    final static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("_00quitstart");
    static ChangeObjectThread t2 = new ChangeObjectThread("_01创建线程的几种方式");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {//12
                System.out.println("in==>" + getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();//23
        t2.resume();//24
        t1.join();
        t2.join();
    }
}
