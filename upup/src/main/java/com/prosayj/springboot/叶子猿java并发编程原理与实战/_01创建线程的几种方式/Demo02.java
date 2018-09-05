package com.prosayj.springboot.叶子猿java并发编程原理与实战._01创建线程的几种方式;

/**
 * @author yangjian
 * @description 创建线程的方法：实现Runnable接口
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:08
 * @since 1.0.0
 */
public class Demo02 implements Runnable {

    @Override
    public void run() {
        while (true) {
            System.out.println("thread running ...");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo02());
        thread.start();
    }
}
