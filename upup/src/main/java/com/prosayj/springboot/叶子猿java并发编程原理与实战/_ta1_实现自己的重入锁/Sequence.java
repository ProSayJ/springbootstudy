package com.prosayj.springboot.叶子猿java并发编程原理与实战._ta1_实现自己的重入锁;

/**
 * @author yangjian
 * @description 测试自定义锁的安全性
 * @Date 23:18 2018/8/5
 * @since 1.0.0
 */
public class Sequence {

    private MyLock lock = new MyLock();

    private int value;

    public int getNext() {
        lock.lock();
        value++;
        lock.unlock();
        return value;

    }

    public static void main(String[] args) {

        Sequence s = new Sequence();

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    System.out.println(s.getNext());
                }
            }
        }).start();
    }

}
