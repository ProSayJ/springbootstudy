package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._09_priority;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 1:45
 * @since 1.0.0
 */
public class PriorityDemo {
    static int count = 0;

    /**
     * 低优先级的线程先启动,但是并不能保证每次都是LowPriority先完成,资源竞争的情况下还是会先确保优先级较高的线程获得资源.
     *
     * @param args
     */
    public static void main(String args[]) {
        Thread high = new Thread(() -> {
            while (true) {
                //此处产生资源竞争
                synchronized (PriorityDemo.class) {
                    count++;
                    if (count > 1000000) {
                        System.out.println("HightPriority is complete!");
                        break;
                    }
                }
            }
        });

        Thread low = new Thread(() -> {
            while (true) {
                //此处产生资源竞争
                synchronized (PriorityDemo.class) {
                    count++;
                    if (count > 1000000) {
                        System.out.println("LowPriority is complete!");
                        break;
                    }
                }
            }
        });

        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);

        low.start();
        high.start();
    }

}
