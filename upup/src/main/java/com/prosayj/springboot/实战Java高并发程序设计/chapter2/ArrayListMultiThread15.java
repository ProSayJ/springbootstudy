package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

import java.util.ArrayList;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 2:27
 * @since 1.0.0
 */
public class ArrayListMultiThread15 {

    static ArrayList<Integer> arrayList = new ArrayList<>(10);

    public static class AddThread implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p/>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                arrayList.add(i);
            }
        }
    }

    /**
     * ArrayList是一个线程不安全的容器,多线程操作时会出现冲突,报错信息如下:
     * Exception in thread "Thread-1" java.lang.ArrayIndexOutOfBoundsException: 22
     * at java.util.ArrayList.add(ArrayList.java:441)
     * at chapter2.ArrayListMultiThread$AddThread.run(ArrayListMultiThread.java:27)
     * at java.lang.Thread.run(Thread.java:745)
     * <p>
     * Vector是一个线程安全的容器,可以代替ArrayList
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread());
        Thread thread2 = new Thread(new AddThread());

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(arrayList.size());
    }

}
