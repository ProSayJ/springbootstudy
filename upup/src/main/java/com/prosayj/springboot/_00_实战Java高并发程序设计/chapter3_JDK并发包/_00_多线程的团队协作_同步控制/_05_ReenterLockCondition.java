package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_多线程的团队协作_同步控制;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yangjian
 * @description  重入锁的好搭档：Condition条件
 * @Date 0:31 2018/11/5
 * @since 1.0.0
 */
public class _05_ReenterLockCondition {
    public static ReentrantLock lock = new ReentrantLock();
    //生成一个与lock绑定的condition对象。
    public static Condition condition = lock.newCondition();


    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {
                lock.lock();
                //调用之前需要持有线程相关的重入锁。
                condition.await();
                //调用之后这个线程会释放先前获得的锁。
                System.out.println("Thread is going on");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread.sleep(2000);
        lock.lock();
        //执行之前需要获得condition所在的重入锁，
        //这里，主线程唤醒一个正在等待的线程,告诉等在再Condition上的线程可以继续执行了。
        condition.signal();
        //调用signal之后，一般需要释放相关的锁，谦让给被唤醒的线程
        //如果不释放锁，t1就算被唤醒也无法继续执行。
        //lock.unlock();
    }
}
