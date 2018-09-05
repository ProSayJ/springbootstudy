package com.prosayj.springboot.叶子猿java并发编程原理与实战._05单例模式下的并发安全问题;

/**
 * @author yangjian
 * @description 饿汉式单例模式
 * @Date 17:57 2018/7/28
 * @since 1.0.0
 */

public class Singleton2 {

    private Singleton2() {
    }

    private static volatile Singleton2 instance;

    public static Singleton2 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton2();
        }
        return instance;
    }


}
