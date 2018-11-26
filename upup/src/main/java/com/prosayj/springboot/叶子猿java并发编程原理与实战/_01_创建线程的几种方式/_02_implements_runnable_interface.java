package com.prosayj.springboot.叶子猿java并发编程原理与实战._01_创建线程的几种方式;

/**
 * @author yangjian
 * @description 创建线程的方法：实现Runnable接口
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:08
 * @since 1.0.0
 */
public class _02_implements_runnable_interface implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println(Thread.currentThread().getName() + " running ...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new _02_implements_runnable_interface());
        thread.start();
    }
}
