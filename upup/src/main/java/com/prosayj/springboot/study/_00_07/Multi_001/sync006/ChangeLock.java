package com.prosayj.springboot.study._00_07.Multi_001.sync006;

/**
 * @author yangjian
 * @description 锁对象的改变问题
 * @Date 18:29 2018/5/18
 * @since 1.0.0
 */
public class ChangeLock {

    private String lock = "lock";

    private void method() {
        synchronized (lock) {
            try {
                System.out.println("当前线程 : " + Thread.currentThread().getName() + "开始");
                lock = "change lock";
                Thread.sleep(2000);
                System.out.println("当前线程 : " + Thread.currentThread().getName() + "结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final ChangeLock changeLock = new ChangeLock();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        }, "_00_quitstart");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                changeLock.method();
            }
        }, "_01_创建线程的几种方式");
        t1.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }

}
