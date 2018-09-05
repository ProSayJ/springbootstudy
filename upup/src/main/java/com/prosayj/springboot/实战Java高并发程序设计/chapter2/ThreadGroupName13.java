package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:25
 * @since 1.0.0
 */
public class ThreadGroupName13 implements Runnable {

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        String groupAndName = Thread.currentThread().getThreadGroup().getName() + "-" + Thread.currentThread().getName();
        while (true) {
            System.out.println("I am " + groupAndName);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        ThreadGroup tg = new ThreadGroup("PrintGroup");
        Thread t1 = new Thread(tg, new ThreadGroupName13(), "T1");
        Thread t2 = new Thread(tg, new ThreadGroupName13(), "T2");
        t1.start();
        t2.start();
        System.out.println(tg.activeCount());
        Thread t3 = new Thread(tg, new ThreadGroupName13(), "T3");
        t3.start();
        System.out.println(tg.activeCount());
        tg.list();
    }

}
