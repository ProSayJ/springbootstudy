package com.prosayj.springboot.叶子猿java并发编程原理与实战._01_创建线程的几种方式;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author yangjian
 * @description 创建线程的方法：实现Callable接口，有返回值和异常
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/23 0:09
 * @since 1.0.0
 */
public class _04_Callable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + ":正在进行紧张的计算....");
        Thread.sleep(3000);
        return 1;
    }

    public static void main(String[] args) throws Exception {
        _04_Callable d = new _04_Callable();

        FutureTask<Integer> task = new FutureTask<>(d);

        Thread t = new Thread(task);

        t.start();

        Thread.sleep(50L);
        System.out.println(Thread.currentThread().getName()+":我先干点别的。。。");

        Integer result = task.get();
        System.out.println("线程执行的结果为：" + result);
    }
}
