package com.prosayj.springboot.javase.base.day26_thread.code.demo1;

/**
 * 获取线程名字,父类Thread方法
 * String getName()
 */
public class NameThread extends Thread {

    public NameThread() {
        super("小强");
    }

    @Override
    public void run() {
        System.out.println(getName());
    }
}