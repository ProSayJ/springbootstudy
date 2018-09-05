package com.prosayj.springboot.叶子猿java并发编程原理与实战._01创建线程的几种方式;

/**
 * @author yangjian
 * @description 创建线程的方法：实现Runnables接口，使用匿名内部类
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:08
 * @since 1.0.0
 */
public class Demo03 {
    public static void main(String[] args) {


        new Thread() {
            //使用匿名内部类
            public void run() {
                System.out.println("thread start ..");
            }

            ;
        }.start();


        new Thread(new Runnable() {
            //实现Runnable，线程任务通过构造函数传参
            @Override
            public void run() {
                System.out.println("thread start ..");
            }
        }).start();

        //如果两种方法都采取，则子类覆盖接口传参，多态执行的子函数的方法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        }) {
            public void run() {
                System.out.println("sub");
            }

            ;
        }.start();

    }
}
