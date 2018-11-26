package com.prosayj.springboot.study._00_07.Multi_001.sync001;

/**
 * @author yangjian
 * @description 线程安全概念：当多个线程访问某一个类（对象或方法）时，这个对象始终都能表现出正确的行为，那么这个类（对象或方法）就是线程安全的。
 * synchronized：可以在任意对象及方法上加锁，而加锁的这段代码称为"互斥区"或"临界区"
 * @email ProSayj@gmail.com
 * @creatTime 2018/4/30 2:58
 * @since 1.0.0
 */
public class MyThread extends Thread {

    private int count = 5;

    public synchronized void run() {
        count--;
        System.out.println(this.currentThread().getName() + "===>count = " + count);
    }

    public static void main(String[] args) {
        /**
         * 分析：当多个线程访问myThread的run方法时，以排队的方式进行处理（这里排对是按照CPU分配的先后顺序而定的），
         * 		一个线程想要执行synchronized修饰的方法里的代码：
         * 		1 尝试获得锁
         * 		2 如果拿到锁，执行synchronized代码体内容；拿不到锁，这个线程就会不断的尝试获得这把锁，直到拿到为止，
         * 		   而且是多个线程同时去竞争这把锁。（也就是会有锁竞争的问题）
         */
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread, "_00_quitstart");
        Thread t2 = new Thread(myThread, "_01_创建线程的几种方式");
        Thread t3 = new Thread(myThread, "_03_字节码的角度看待线程安全");
        Thread t4 = new Thread(myThread, "_04_线程的优先级");
        Thread t5 = new Thread(myThread, "_05_单例模式下的并发安全问题");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}












