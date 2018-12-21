package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._01_线程复用_线程池;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.com
 * @creatTime 2018/12/20 22:25
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "开始~~~");
        }).start();
    }
}
