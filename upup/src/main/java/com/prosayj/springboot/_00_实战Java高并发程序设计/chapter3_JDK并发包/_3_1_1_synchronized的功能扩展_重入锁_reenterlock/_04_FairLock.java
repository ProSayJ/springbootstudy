package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description 公平锁
 * @email yangjian@bubi.cn
 * @creatTime 2018/12/5 16:56
 * @since 1.0.0
 */
public class _04_FairLock implements Runnable {
    //设置true指定锁是公平的,也可以不设置,分别运行观察公平锁与非公平锁间的区别
    public static ReentrantLock lock = new ReentrantLock(false);

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
//                Thread.sleep(500L);
            } catch (Exception e) {
            } finally {
                lock.unlock();
            }
        }
    }

    /**
     * 公平锁的一个特点是:不会产生饥饿现象,只要排队最终都会得到资源.
     * <p/>
     * 但是实现公平锁要求系统维护一个有序队列,因此公平锁的实现成本较高,性能相对低下.因此默认锁是非公平的。
     *
     * @param args
     */
    public static void main(String args[]) {
        new Thread(new _04_FairLock(), "Thread_t1").start();
        new Thread(new _04_FairLock(), "Thread_t2").start();
        new Thread(new _04_FairLock(), "Thread_t3").start();
    }

}