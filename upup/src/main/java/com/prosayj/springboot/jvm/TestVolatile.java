package com.prosayj.springboot.jvm;

public class TestVolatile {

    public static void main(String[] args) throws InterruptedException {
        VolatileTest volatileTest = new VolatileTest();
        new Thread(() -> {
            volatileTest.flag = true;

        }).start();

        while (true) {
            Thread.sleep(500L);
            System.out.println(Thread.currentThread().getName() + "--->run!");
            if (volatileTest.flag) {
                System.out.println(Thread.currentThread().getName() + "--->stop!");
                break;
            }
        }
    }

}

class VolatileTest {
    public /*volatile*/ boolean flag = false;

}
