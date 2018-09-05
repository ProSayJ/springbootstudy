package com.prosayj.springboot.叶子猿java并发编程原理与实战._00quitstart;

/**
 * @author yangjian
 * @description 多线程hello world
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:58
 * @since 1.0.0
 */
public class NewThread01 implements Runnable {

    @Override
    public synchronized void run() {
        while (true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("自定义的线程执行了....");
        }
    }

    public static void main(String[] args) {

        NewThread01 n = new NewThread01();

        // 初始化状态
        Thread thread = new Thread(n); // 创建线程,并指定线程任务

        thread.start(); // 启动线程

        while (true) {
            synchronized (n) {
                System.out.println("主线程执行了...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                n.notifyAll();
            }

        }

    }

}