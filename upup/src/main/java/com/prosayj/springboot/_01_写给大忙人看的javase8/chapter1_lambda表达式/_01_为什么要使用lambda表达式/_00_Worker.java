package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;

public class _00_Worker implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            //doWork();
        }
    }

    public static void main(String[] args) {
        _00_Worker worker = new _00_Worker();
        new Thread(worker).start();
    }
}
