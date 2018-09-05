package com.prosayj.springboot.叶子猿java并发编程原理与实战._01创建线程的几种方式;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author yangjian
 * @description 创建线程的方法：使用java定时器
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:10
 * @since 1.0.0
 */
public class Demo05 {
    public static void main(String[] args) {

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                // 实现定时任务
                System.out.println("timertask is run");
            }
        }, 0, 100000/**每隔几秒执行一次*/);

    }
}
