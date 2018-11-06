package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

/**
 * @author yangjian
 * @description join()方法
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/1 18:42
 * @since 1.0.0
 */
public class _08_JoinMain {

    public volatile static int i = 0;

    public static class AddThread extends Thread {
        @Override
        public void run() {
            System.out.println("add!");
            for (i = 0; i < 1000000; i++) {
            }
            ;
        }
    }

    public static void main(String args[]) throws InterruptedException {

        AddThread at = new AddThread();
        at.start();
        //使用join()方法后,主线程会等待AddThread执行完毕,i输出为1000000,如果没有这条语句,i输出为0
        //助记：我加入你等待下
        at.join();
        //可以查看join的底层代码,本质即让调用线程在当前线程对象实例上等待
        System.out.println(i);

    }
}
