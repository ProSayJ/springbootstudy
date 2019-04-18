package com.prosayj.springboot._04_Java高并发编程详解._01_;

import java.util.concurrent.TimeUnit;

public class _02_ThreadRestart {
    public static void main(String[] args) {
//        startTwiceThreadErr();
        startTwiceThreadOk();
    }


    public static void startTwiceThreadErr() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();//启动线程
        thread.start();//再次启动线程
    }

    public static void startTwiceThreadOk() {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();//启动线程
        try {
            TimeUnit.SECONDS.sleep(4);//主要线程睡眠是为了确保Thread结束生命周期
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.start();//企业重新激活该线程
    }
}
