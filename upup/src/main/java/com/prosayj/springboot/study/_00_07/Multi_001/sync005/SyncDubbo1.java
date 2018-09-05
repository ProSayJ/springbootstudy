package com.prosayj.springboot.study._00_07.Multi_001.sync005;

/**
 * @author yangjian
 * @description synchronized的重入
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/1 1:42
 * @since 1.0.0
 */
public class SyncDubbo1 {

    public synchronized void method1() {
        System.out.println("method1..");
        method2();
    }

    public synchronized void method2() {
        System.out.println("method2..");
        method3();
    }

    public synchronized void method3() {
        System.out.println("method3..");
    }

    public static void main(String[] args) {
        final SyncDubbo1 sd = new SyncDubbo1();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sd.method1();
            }
        });
        t1.start();
    }
}
