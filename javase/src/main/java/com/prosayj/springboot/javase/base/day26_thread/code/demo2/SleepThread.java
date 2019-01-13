package com.prosayj.springboot.javase.base.day26_thread.code.demo2;

public class SleepThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception ex) {

            }
            System.out.println(i);
        }
    }
}
