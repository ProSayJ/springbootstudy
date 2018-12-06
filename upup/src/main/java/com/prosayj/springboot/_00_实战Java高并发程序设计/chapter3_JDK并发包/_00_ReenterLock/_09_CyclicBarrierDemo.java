package com.prosayj.springboot._00_实战Java高并发程序设计.chapter3_JDK并发包._00_ReenterLock;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yangjian
 * @description 循环栅栏：CyclicBarrier p91
 * <p>
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/5 0:26
 * @since 1.0.0
 */
public class _09_CyclicBarrierDemo {

    public static void main(String args[]) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        //创建CyclicBarrier实例，并设置计数器为10，并且要求在计时器到达指标时，执行BarrierRun的run方法。
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));

        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍!");
        for (int i = 0; i < N; i++) {
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            allSoldier[i].start();
            /**
             * 可能得到一个 InterruptedException 和九个 BrokenBarrierException，
             * InterruptedException是被总段跑出去的。
             * BrokenBarrierException是等待再当前CyclicBarrier上的线程抛出的，
             * 这个异常可以避免其他9个线程进行永久的，无谓的等待，因为其中一个线程已经被中断，等待是没有结果的
             */
            /*
            if (i == 5) {
                allSoldier[0].interrupt();
            }
            */
        }
    }
}

class BarrierRun implements Runnable {

    boolean flag;
    int N;

    public BarrierRun(boolean flag, int N) {
        this.flag = flag;
        this.N = N;
    }

    @Override
    public void run() {
        if (flag) {
            System.out.println("司令:[士兵" + N + "个,任务完成!");
        } else {
            System.out.println("司令:[士兵" + N + "个,集合完毕!");
            flag = true;
        }
    }
}

class Soldier implements Runnable {
    private String soldier;
    private final CyclicBarrier cyclicBarrier;

    public Soldier(CyclicBarrier cyclicBarrier, String soldier) {
        this.soldier = soldier;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        try {
            //等待所有的士兵到齐，齐了再执行工作,集齐了执行BarrierRun的run方法。
            assemble(soldier);
            cyclicBarrier.await();
            doWork();
            //等待所有的士兵完成工作
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    private void assemble(String soldier) {
        System.out.println("士兵" + soldier + "起床 !" + "开始洗脸刷牙飞速楼下集合");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 士兵执行任务
     */
    void doWork() {
        try {
            Thread.sleep(Math.abs(new Random().nextInt() % 10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(soldier + ":任务完成");
    }
}

