package com.prosayj.springboot._04_Java高并发编程详解._02_;

/**
 * @author yangjian
 * @description 守护线程
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 23:46
 * @since 1.0.0
 */
public class _05_DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(2_000L);
        System.out.println("main thread finshed lifecycle!");
    }
}
