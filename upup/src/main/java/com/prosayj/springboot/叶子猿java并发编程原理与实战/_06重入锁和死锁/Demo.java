package com.prosayj.springboot.叶子猿java并发编程原理与实战._06重入锁和死锁;

/**
 * @author yangjian
 * @description 锁的重入
 *      同一个锁对象，在同一个线程下是可重入的。
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/5 23:03
 * @since 1.0.0
 */
public class Demo {


    public synchronized void a() {
        System.out.println("a");
        b();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void b() {
        System.out.println("b");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Demo d1 = new Demo();
//        Demo d2 = new Demo();

        new Thread(new Runnable() {

            @Override
            public void run() {
                d1.a();
            }
        }).start();
      /*  new Thread(new Runnable() {

            @Override
            public void run() {
                d2.b();
            }
        }).start();*/
    }

}
