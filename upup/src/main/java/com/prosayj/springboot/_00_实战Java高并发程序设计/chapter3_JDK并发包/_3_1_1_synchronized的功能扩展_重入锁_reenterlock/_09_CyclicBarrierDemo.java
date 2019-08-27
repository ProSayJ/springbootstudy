package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._3_1_1_synchronized的功能扩展_重入锁_reenterlock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/27 下午 05:23
 * @since 1.0.0
 */
public class _09_CyclicBarrierDemo {
    public static void main(String[] args) {
        final int N = 10;
        boolean flag = false;


        //创建CyclicBarrier实例，并设置计数器为10，并且要求在计时器到达指标时，执行BarrierRun的run方法。
        CyclicBarrier cyclic = new CyclicBarrier(N, new BarrierRun(flag, N));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道!");
            Thread t = new Thread(new Soldier("士兵" + i, cyclic));
            t.start();
            /**
             * 下面的interrupt可能得到一个 InterruptedException 和九个 BrokenBarrierException，
             * InterruptedException是被总段跑出去的。
             * BrokenBarrierException是等待再当前CyclicBarrier上的线程抛出的，
             * 这个异常可以避免其他9个线程进行永久的，无谓的等待，因为其中一个线程已经被中断，等待是没有结果的
             */
            /*if (i == 5){
                t.interrupt();
            }*/

        }
    }

    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclic;

        public Soldier(String soldierName, CyclicBarrier cyclic) {
            this.soldier = soldierName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                //等待所有士兵到齐
                cyclic.await();
                doWork();
                //等待所有士兵完成工作
                cyclic.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }

        private void doWork() {
            try {
                int sleepTime = Math.abs(new Random().nextInt() % 10000);
                Thread.sleep(sleepTime);
                System.out.println(soldier + ":完成任务,耗时：" + sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;

        public BarrierRun(boolean flag, int n) {
            this.flag = flag;
            N = n;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令：[士兵" + N + "个，任务完成！]");
            } else {
                System.out.println("司令：[士兵" + N + "个，集合完成！]");
                flag = true;
            }

        }
    }
}