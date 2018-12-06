package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._04_suspend_resume;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 17:55
 * @since 1.0.0
 */
public class _00_BadSuspend {
    final static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("00000");
    static ChangeObjectThread t2 = new ChangeObjectThread("111111");

    public static class ChangeObjectThread extends Thread {
        public ChangeObjectThread(String name) {
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u) {//12
                System.out.println("in==>" + getName());
                //线程挂起
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        //线程继续执行
        t1.resume();//23
        t2.resume();//24
        t1.join();
        t2.join();
    }
}
