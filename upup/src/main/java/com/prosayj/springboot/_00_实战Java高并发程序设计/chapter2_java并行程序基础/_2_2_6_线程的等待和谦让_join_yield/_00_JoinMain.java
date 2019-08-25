package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_6_线程的等待和谦让_join_yield;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 03:41
 * @since 1.0.0
 */
public class _00_JoinMain {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            for (i = 0; i < 10000000; i++) ;
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AddThread at = new AddThread();
        at.start();
        at.join();
        System.out.println(i);

    }
}
