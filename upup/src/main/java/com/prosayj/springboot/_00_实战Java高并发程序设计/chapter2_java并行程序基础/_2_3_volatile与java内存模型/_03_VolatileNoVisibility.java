package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_3_volatile与java内存模型;


/**
 * @author yangjian
 * @description 多线程情况下，没有被volatile修饰的共享变量，在多线程修改的情况下，线程之间的修改是彼此不可见的。
 * 虚拟机在client模式下，JIT并没有做足够的优化。在主线程修改ready变量的状态后，其他线程可以发现这个改变，并推出程序。
 * 但是在Server模式下，由于系统优化的结果，无法看到主线程的修改。
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class _03_VolatileNoVisibility {
    private static/* volatile*/ boolean ready;
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!ready) {
            }
            System.out.println(number);
        }).start();
        Thread.sleep(1000);
        number = 42;
        ready = true;

    }
}


