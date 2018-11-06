package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description 这是一个错误的加锁方式
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 15:55
 * @since 1.0.0
 */
public class _19_BadLockOnInteger implements Runnable {


    public static Integer i = 0;
    static _19_BadLockOnInteger instance = new _19_BadLockOnInteger();


    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            //这里同步的并不是同一个对象,因为i是以Integer关键字创建的
            synchronized (i) {
//            synchronized (instance) {    //正确做法应该是
                i++;
            }
        }
    }

    /**
     * 得到的结果并不是2000000,在多线程的操作中出现了错误
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
        i = Integer.valueOf(i.intValue() + 1);
    }
}
