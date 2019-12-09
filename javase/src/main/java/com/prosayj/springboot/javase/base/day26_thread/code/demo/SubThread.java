package com.prosayj.springboot.javase.base.day26_thread.code.demo;

/**
 * 定义子类,继承Thread
 * 重写方法run
 */
public class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("run..." + i);
        }
    }
}
