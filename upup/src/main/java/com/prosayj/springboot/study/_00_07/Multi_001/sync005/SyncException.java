package com.prosayj.springboot.study._00_07.Multi_001.sync005;

/**
 * @author yangjian
 * @description synchronized异常
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/1 1:49
 * @since 1.0.0
 */
public class SyncException {

    private int i = 0;
    private static final Long SLEEP_TIME_100 = 100L;

    public synchronized void operation() {
        while (true) {
            try {
                i++;
                Thread.sleep(SLEEP_TIME_100);
                System.out.println(Thread.currentThread().getName() + " , i = " + i);
                if (i == 20) {
                    //Integer.parseInt("a");
                    throw new RuntimeException();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        final SyncException se = new SyncException();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                se.operation();
            }
        }, "_00quitstart");
        t1.start();
    }


}
