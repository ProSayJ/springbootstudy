package com.prosayj.springboot.叶子猿java并发编程原理与实战._03_字节码的角度看待线程安全;


/**
 * @author yangjian
 * @description 不安全的线程调用
 * @email yangjian@bubi.cn
 * @creatTime 2018/8/1 23:17
 * @since 1.0.0
 */
public class Demo01 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "<=====>" + sequence.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    sequence.getNext();
                }
            }
        }).start();
    }

}

