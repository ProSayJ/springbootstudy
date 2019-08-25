package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_3_volatile与java内存模型;

/**
 * @author yangjian
 * @description volatile无法保证i++的原子性操作
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 04:53
 * @since 1.0.0
 */
public class _00_NoAtomic {
    private static volatile int sum = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(() -> {
                for (int times = 0; times < 10000; times++) {
                    sum++;
                }
            });
            threads[i].start();
        }
        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }
        System.out.println(sum);

    }

}
