package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._08_Daemon;

/**
 * @author yangjian
 * @description TODO
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

    /**
     * thread被设置为守护线程,系统中只有主线程main为用户线程,因此在main线程休眠3秒退出时,整个程序也随之结束,如果不把线程thread设置为守护线程,
     * main线程结束后,t线程还会不停的打印,永远也不会结束.
     * <p>
     * tip:当一个Java应用内,只有守护线程时,Java虚拟机就会退出.
     * 这里注意 ，设置守护线程必须在线程start() 之前设置，否则你会得到一个类似以下的异常 ，告诉你守护线程设置失败 。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new DaemonT();
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(3000);
    }
}
