package com.prosayj.springboot.叶子猿java并发编程原理与实战._01创建线程的几种方式;

/**
 * @author yangjian
 * @description 创建线程的方法：继承Thread类,线程中断的同时，标记位也会被标记
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:05
 * @since 1.0.0
 */
public class Demo01 extends Thread {

    public Demo01(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            System.out.println(getName() + "线程执行了 .. ");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Demo01 d1 = new Demo01("first-thread");
        Demo01 d2 = new Demo01("second-thread");


        d1.start();
        d2.start();

//		d1.stop();
        d1.interrupt();
    }

}