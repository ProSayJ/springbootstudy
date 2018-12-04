package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包;

import java.util.concurrent.*;

/**
 * @description
 * @author yangjian
 * @Date 0:32 2018/11/5
 * @since 1.0.0
 */
public class RejectThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + ":Thread ID:" + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        MyTask myTask = new MyTask();

        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(10), Executors.defaultThreadFactory()
                , new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println(r.toString() + " is discard");
            }
        });

        for (int i = 0; i < 100; i++) {
            executorService.submit(myTask);
            Thread.sleep(10);
        }
    }
}
