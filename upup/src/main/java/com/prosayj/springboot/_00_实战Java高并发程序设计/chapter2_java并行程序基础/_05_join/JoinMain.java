package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._05_join;

/**
 * @author yangjian
 * @description join()方法 我加入，你等待。join方法会无限等待，他会一直阻塞当前的线程，直到目标线程执行完成。
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 18:42
 * @since 1.0.0
 */
public class JoinMain {
    public static void main(String args[]) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "===>start!");

        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "===>start!");
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "===>end!");
        });

        thread.start();
        //使用join()方法后,主线程会等待AddThread执行完毕,之后才会继续执行。
        //可以查看join的底层代码,本质即让调用线程在当前线程对象实例上等待
        thread.join();
        //最大阻塞时间
        //thread.join(2000L);
        System.out.println(Thread.currentThread().getName() + "===>end!");

    }
}
