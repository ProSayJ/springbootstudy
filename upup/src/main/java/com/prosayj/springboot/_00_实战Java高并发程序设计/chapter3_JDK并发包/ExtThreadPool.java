package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/5 0:26
 * @since 1.0.0
 */
public class ExtThreadPool {

    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行:Thread ID:" + Thread.currentThread().getId() + ",Task Name:" + name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("准备执行:" + ((MyTask) r).name);
            }

            protected void afterExecute(Thread t, Runnable r) {
                System.out.println("执行完成:" + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出!");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK-GEYM-" + i);
            executorService.execute(task);
            Thread.sleep(10);
        }
        executorService.shutdown();
    }
}

