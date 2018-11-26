package com.prosayj.springboot.study._00_07.Multi_001.sync003;
/**
 * @author yangjian
 * @description 对象锁的同步和异步问题
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/1 0:41
 * @since 1.0.0
 */
public class MyObject {
    public static final long SLEEP_TIME = 4000L;

    public synchronized void method1() {
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        final MyObject mo = new MyObject();

        /**
         * 分析：
         * t1线程先持有object对象的Lock锁，t2线程可以以异步的方式调用对象中的非synchronized修饰的方法
         * t1线程先持有object对象的Lock锁，t2线程如果在这个时候调用对象中的同步（synchronized）方法则需等待，也就是同步
         */
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method1();
            }
        }, "_00_quitstart");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                mo.method2();
            }
        }, "_01_创建线程的几种方式");

        t1.start();
        t2.start();

    }

}
