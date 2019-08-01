package com.prosayj.springboot._00_实战Java高并发程序设计.chapter1_走入并行世界._1_5_1_原子性_Atomicity;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/6/28 23:41
 * @since 1.0.0
 */
public class _01_MultiThreadLong {
    public /*volatile*/ static long t = 0;

    public static class ChangeT implements Runnable {
        private long to;
        public ChangeT(long to) {
            this.to = to;
        }
        @Override
        public void run() {
            while (true) {
                _01_MultiThreadLong.t = to;
                Thread.yield();
            }
        }
    }
    public static class ReadT implements Runnable {
        @Override
        public void run() {
            while (true) {
                long tmp = _01_MultiThreadLong.t;
                if (tmp != 111L && tmp != -999L && tmp != 333L && tmp != -444L) {
                    System.out.println(tmp);
                }
                Thread.yield();
            }
        }
    }
    public static void main(String[] args) {
        new Thread(new ChangeT(111L)).start();
        new Thread(new ChangeT(-999L)).start();
        new Thread(new ChangeT(333L)).start();
        new Thread(new ChangeT(-444L)).start();
        new Thread(new ReadT()).start();
    }
}
