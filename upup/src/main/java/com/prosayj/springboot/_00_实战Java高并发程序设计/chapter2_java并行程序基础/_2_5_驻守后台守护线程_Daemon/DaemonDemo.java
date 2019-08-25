package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_5_驻守后台守护线程_Daemon;

/**
 * @author yangjian
 * @description 当一个 Java 应用内，只有守护线程时 ，Java 虚拟机就会自然退出
 * <p>
 * 设置守护线程必须在线程start() 之前设置，否则你会得到一个类似以下的异常 ，告诉你守护线程设置失败
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:36
 * @since 1.0.0
 */
public class DaemonDemo {
    public static class DaemonT extends Thread {
        @Override
        public void run() {
            while (true) {
                System.out.println("I am alive");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread = new DaemonT();
        thread.start();
        thread.setDaemon(true);
        Thread.sleep(3000);
    }
}
