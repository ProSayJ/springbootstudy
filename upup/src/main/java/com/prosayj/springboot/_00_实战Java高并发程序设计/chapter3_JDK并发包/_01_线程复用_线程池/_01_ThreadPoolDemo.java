package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._01_线程复用_线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.com
 * @creatTime 2019/1/13 23:05
 * @since 1.0.0
 */
public class _01_ThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID:" + Thread.currentThread().getId());

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) {
        MyTask myTask = new MyTask();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(myTask);
        }
        executorService.shutdown();
    }
}
