package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._10_synchronized;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author yangjian
 * @description 并发下的HashMap
 * HashMap是一个线程不安全的容器,多线程操作时会出现冲突
 * <p>
 * jdk7下谨慎运行此方法,可能会导致电脑死机,jdk8中问题已修复。jdk8对HashMap内部的实现做了大规模的调整。
 * 最简单的解决方案使用ConcurrentHashMap代替MashMap
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/8 14:49
 * @since 1.0.0
 */
public class _05_HashMapMultiThread {

    //static Map<String, String> map = new HashMap<>();
    static Map<String, String> map = new ConcurrentHashMap<>();

    public static class AddThread implements Runnable {


        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 100000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AddThread(0));
        Thread thread2 = new Thread(new AddThread(1));
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(map.size());
        map.entrySet().forEach(data -> {
            if (!Integer.toBinaryString(Integer.valueOf(data.getKey())).equals(data.getValue())) {
                System.out.println(data.toString());
            }
        });
    }
}
