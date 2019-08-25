package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_3_volatile与java内存模型;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 05:08
 * @since 1.0.0
 */
public class _01_NoVisibility {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {//7
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(10000);

    }
}
