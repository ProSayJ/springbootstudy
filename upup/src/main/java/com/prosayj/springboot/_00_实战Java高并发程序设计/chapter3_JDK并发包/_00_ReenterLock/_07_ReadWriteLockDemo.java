package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author yangjian
 * @description jdk5提供的读写分离锁：都操作远远大于写操作，则读写锁就可以发挥最大的功效
 * <p>
 * 优点：
 * 有效减少锁竞争：
 * <p>
 * 读<--->读不互斥：读读之间不阻塞
 * 读<--->写阻塞：读阻塞写，写也会阻塞读
 * 写<--->写阻塞：写写阻塞
 * @email yangjian@bubi.cn
 * @creatTime 2018/12/5 18:54
 * @since 1.0.0
 */
public class _07_ReadWriteLockDemo {
    private static Lock lock = new ReentrantLock();
    private static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    private int value;

    public Object handleRead(Lock lock) throws InterruptedException {

        try {
            lock.lock();
            Thread.sleep(1000);//模拟读操作，耗时越多，优势越明显
            System.out.println("读操作:" + value);
            return value;
        } finally {
            lock.unlock();
        }
    }

    public void handleWrite(Lock lock, int index) throws InterruptedException {
        try {
            lock.lock();
            Thread.sleep(1000);//模拟写操作
            System.out.println("写操作:" + value);
            value = index;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String args[]) {
        final _07_ReadWriteLockDemo demo = new _07_ReadWriteLockDemo();

        Runnable readRunnable = new Runnable() {
            @Override
            public void run() {
                //分别使用两种锁来运行,性能差别很直观的就体现出来,使用读写锁后读操作可以并行,节省了大量时间
                try {
                    demo.handleRead(readLock);
                    //demo.handleRead(lock);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };

        Runnable writeRunnable = new Runnable() {
            @Override
            public void run() {
                //分别使用两种锁来运行,性能差别很直观的就体现出来
                try {
                    demo.handleWrite(writeLock, new Random().nextInt(100));
                    //demo.handleWrite(lock, new Random().nextInt(100));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        for (int i = 0; i < 18; i++) {
            new Thread(readRunnable).start();
        }
        for (int i = 18; i < 20; i++) {
            new Thread(writeRunnable).start();
        }
    }
}
