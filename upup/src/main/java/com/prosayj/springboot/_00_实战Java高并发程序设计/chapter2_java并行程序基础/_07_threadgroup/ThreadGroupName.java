package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._07_threadgroup;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:25
 * @since 1.0.0
 */
public class ThreadGroupName implements Runnable {

    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupName(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName(), "T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        Thread t3 = new Thread(tg, new ThreadGroupName(), "T3");
        t3.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

}
