package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangjian
 * @description
 * @Date 0:29 2018/11/5
 * @since 1.0.0
 */
public class NoTraceDivTaskDemo {
    public static class DivTask implements Runnable {
        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a / b;
            System.out.println(re);
        }
    }


    public static void main(String args[]) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        for (int i = 0; i < 5; i++) {
            /*poolExecutor.submit(new DivTask(100, i));*/ //没有报错提示
            poolExecutor.execute(new DivTask(100, i));//有报错提示
        }
    }

}
