package com.prosayj.springboot.叶子猿java并发编程原理与实战._06重入锁和死锁;

/**
 * @author yangjian
 * @description 死锁
 * @Date 11:11 2018/8/12
 * @since 1.0.0
 */
public class Demo3 {

    private Object obj1 = new Object();
    private Object obj2 = new Object();


    public void a() {
        synchronized (obj1) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println("a");
            }
        }
    }

    public void b() {
        synchronized (obj2) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj1) {
                System.out.println("b");
            }
        }
    }

    public static void main(String[] args) {

        Demo3 d = new Demo3();

        new Thread(new Runnable() {

            @Override
            public void run() {
                d.a();
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                d.b();
            }
        }).start();
    }

}
