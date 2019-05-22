package com.prosayj.springboot._04_Java高并发编程详解._02_深入理解Thread构造函数;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangjian
 * @description 栈溢出操作
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 16:57
 * @since 1.0.0
 */
public class _04_StackOverFlow extends Thread {
    final static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        try {
            while (true) {
                new _04_StackOverFlow().start();
            }
        } catch (Exception e) {
            System.out.println("failed At=>" + counter.get());
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            System.out.println("The" + counter.getAndIncrement() + "thread be create.");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
