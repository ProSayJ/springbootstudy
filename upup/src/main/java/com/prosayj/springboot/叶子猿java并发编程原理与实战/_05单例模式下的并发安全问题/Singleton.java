package com.prosayj.springboot.叶子猿java并发编程原理与实战._05单例模式下的并发安全问题;
/**
 * @description 懒汉式单例模式
 * @author yangjian
 * @Date 17:56 2018/7/28
 * @since 1.0.0
 */

public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    // 多线程的环境下
    // 必须有共享资源
    // 对资源进行非原子性操作

}
