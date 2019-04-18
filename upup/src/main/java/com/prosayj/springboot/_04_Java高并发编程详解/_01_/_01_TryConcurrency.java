package com.prosayj.springboot._04_Java高并发编程详解._01_;

import java.util.concurrent.TimeUnit;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/18 19:15
 * @since 1.0.0
 */
public class _01_TryConcurrency {
    /*
    public static void main(String[] args) {
        browseNews();
        enjoyMusic();
    }
    */

    /*
    public static void main(String[] args) {
        new Thread(()->{
            enjoyMusic();
        }).start();
        browseNews();
    }
    */

    public static void main(String[] args) {
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
