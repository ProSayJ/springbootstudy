package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;

/**
 * @author yangjian
 * @description 传统的新建线程的方式:这里的关键在于，run方法里面包含了你希望在另一个线程内部执行的方法
 * @Date 上午 08:54 2019/9/10
 * @since 1.0.0
 */
public class _00_Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            doWork();
        }
    }

    private void doWork() {
        System.out.println(Thread.currentThread().getName() + "==>开始工作");
    }

    public static void main(String[] args) {
        new Thread(new _00_Worker()).start();
    }
}
