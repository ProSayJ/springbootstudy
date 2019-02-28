package com.prosayj.springboot.study._00_07.Multi_001.sync005;

/**
 * @author yangjian
 * @description synchronized的重入
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/1 1:43
 * @since 1.0.0
 */
public class SyncDubbo2 {
    private static final Long SLEEP_TIME_100 = 100L;

    static class Main {

        public int i = 10;


        public synchronized void operationSup() {
            try {
                i--;
                System.out.println("Test print i = " + i);
                Thread.sleep(SLEEP_TIME_100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Sub extends Main {
        public synchronized void operationSub() {
            try {
                while (i > 0) {
                    i--;
                    System.out.println("Sub print i = " + i);
                    Thread.sleep(SLEEP_TIME_100);
                    this.operationSup();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Sub sub = new Sub();
                sub.operationSub();
            }
        });

        t1.start();
    }


}
