package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:51
 * @since 1.0.0
 */
public class _15_AccountingVol implements Runnable {

    static _15_AccountingVol instance = new _15_AccountingVol();
    static volatile int i = 0;

    public static void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    /**
     * 主函数是通过两个线程对i进行累加操作,最终的正确结果应为20000000,但是实际运行却远远小于正确数值,因为多个线程同事对i进行写入操作时,
     * 其中一个线程的结果会覆盖另外一个线程的操作,线程不安全导致了这种冲突.
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
    }

}
