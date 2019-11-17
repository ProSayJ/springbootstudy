package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_8_程序中的幽灵_隐蔽的错误;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 并发下的ArrayList：
 * ArrayList是线程不安全的容器。多线程并发操作时会出现冲突。
 * Vector是一个线程安全的容器,可以代替ArrayList
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 2:27
 * @since 1.0.0
 */
public class _00_ArrayListMultiThread {

    static List<Integer> arrayList = new ArrayList<>(20000);
    //static List<Integer> arrayList = new Vector<Integer>(20000);

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());

        /**
         * 可能有三种结果：
         * 1>程序正常结束：结果刚好是：20000
         * 2>程序抛出异常：
         * 3>打印出arrayList的大小：
         */
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();


        System.out.println(arrayList.size());

    }

}
