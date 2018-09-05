package com.prosayj.springboot.study._00_07.Multi_001.sync007;

/**
 * @author yangjian
 * @description
 * @Date 18:48 2018/5/18
 * @since 1.0.0
 */
public class RunThread extends Thread {

    private volatile boolean isRunning = true;

    private void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public void run() {
        System.out.println("进入run方法..");
        int i = 0;
        while (isRunning == true) {
            //..
        }
        System.out.println("线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        RunThread rt = new RunThread();
        rt.start();
        Thread.sleep(1000);
        rt.setRunning(false);
        System.out.println("isRunning的值已经被设置了false");
    }


}
