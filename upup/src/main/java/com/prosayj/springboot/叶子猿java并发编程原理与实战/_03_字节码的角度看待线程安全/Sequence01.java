package com.prosayj.springboot.叶子猿java并发编程原理与实战._03_字节码的角度看待线程安全;

/**
 * @author yangjian
 * @description 线程安全问题
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:13
 * @since 1.0.0
 */
public class Sequence01 {

    private int value;

    /**
     * 实例锁：
     * synchronized 放在普通方法上，内置锁就是当前类的实例
     *
     * @return
     */
    public synchronized int getNext() {
        return value++;
    }

    /**
     * 类锁：
     *
     * 修饰静态方法，内置锁是当前的Class字节码对象
     * Sequence.class
     *
     * @return
     */
    public static synchronized int getPrevious() {
//		return value --;
        return 0;
    }

    public int xx() {
        //synchronized代码块的实现原理是基于进入monitorenter 和 monitorexit来实现的
        // monitorenter
        synchronized (Sequence01.class) {

            if (value > 0) {
                return value;
            } else {
                return -1;
            }

        }
        // monitorexit

    }

    public static void main(String[] args) {
        Sequence01 s = new Sequence01();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " " + s.getNext());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                s.getNext();
            }
        }).start();


    }
}
