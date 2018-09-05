package com.prosayj.springboot.study._00_07.Multi_001.sync006;

/**
 * @author yangjian
 * @description synchronized代码块对字符串的锁，注意String常量池的缓存功能
 * @Date 18:46 2018/5/18
 * @since 1.0.0
 */
public class StringLock {

    public void method() {
        //new String("字符串常量")
        synchronized ("字符串常量") {
            try {
                while (true) {
                    System.out.println("当前线程 : " + Thread.currentThread().getName() + "开始");
                    Thread.sleep(1000);
                    System.out.println("当前线程 : " + Thread.currentThread().getName() + "结束");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final StringLock stringLock = new StringLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        }, "_00quitstart");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                stringLock.method();
            }
        }, "_01创建线程的几种方式");

        t1.start();
        t2.start();
    }
}
