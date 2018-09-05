package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/21 18:04
 * @since 1.0.0
 */
public class TestInterrupt02 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.yield();
                    if(Thread.currentThread().isInterrupted()) {
                        break;
                    }
                }
            }
        });

        t1.start();
        Thread.sleep(2000L);
        //它通知目标线程中断，也就是设置中断标志位。中断标志位表示当前线程己经被中断了 。
        t1.interrupt();
    }
}
