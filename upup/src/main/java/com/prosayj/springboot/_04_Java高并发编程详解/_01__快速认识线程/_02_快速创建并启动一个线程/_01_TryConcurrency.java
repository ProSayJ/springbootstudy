package com.prosayj.springboot._04_Java高并发编程详解._01__快速认识线程._02_快速创建并启动一个线程;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/18 19:15
 * @since 1.0.0
 */
public class _01_TryConcurrency {
    @Test
    //单线程启动
    public void m1() {
        browseNews();
        enjoyMusic();
    }

    @Test
    //匿名内部类启动一个线程
    public void m2() {
        new Thread(() -> {
            enjoyMusic();
        }).start();
        browseNews();
    }

    @Test
    //jdk1.8新特性启动一个线程
    public void m3() {
        new Thread(_01_TryConcurrency::enjoyMusic).start();
        browseNews();
    }

    /**
     * Browse the news
     */
    private static void browseNews() {
        for (; ; ) {
            System.out.println("Un-huh, the good news");
            sleep(1);
        }
    }

    /**
     * Listening and enjoy the music
     */
    private static void enjoyMusic() {
        for (; ; ) {
            System.out.println("Un-huh, the nice music");
            sleep(1);
        }
    }

    /**
     * Simulate the wait and ignore expection
     */
    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
