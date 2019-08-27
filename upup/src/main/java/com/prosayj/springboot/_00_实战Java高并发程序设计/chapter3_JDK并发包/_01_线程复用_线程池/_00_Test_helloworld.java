package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._01_线程复用_线程池;

/**
 * @author yangjian
 * @description 最简单的创建线程和回收方法
 * @email ProSayJ@gmail.com
 * @creatTime 2018/12/20 22:25
 * @since 1.0.0
 */
public class _00_Test_helloworld {
    public static void main(String[] args) {
        new Thread(() -> {
            // do sth
        }).start();

        System.out.println(Thread.currentThread().getName() + "开始~~~");


    }
}
