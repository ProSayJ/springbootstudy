package com.prosayj.springboot.实战Java高并发程序设计.chapter2;


/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 0:35
 * @since 1.0.0
 */
public class VolatileNoVisibility12 {
    private static /*volatile*/ boolean ready;
    private static int number;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new ReadThread()).start();
        Thread.sleep(1000);
        number = 42;
        ready = true;

    }

    public static class ReadThread implements Runnable {

        @Override
        public void run() {
            while (!ready) ;
            System.out.println(number);
        }
    }
}


