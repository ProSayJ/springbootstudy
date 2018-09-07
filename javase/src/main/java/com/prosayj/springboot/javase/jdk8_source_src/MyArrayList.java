package com.prosayj.springboot.javase.jdk8_source_src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/6/20 9:42
 * @since 1.0.0
 */
public class MyArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 9999999; i++) {
            System.out.println(i);
            list.add(i);
        }
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                long t1 = System.currentTimeMillis();
                for (int i = 0; i < list.size(); i++) {
                }
                long t2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "启动randaccess===>" + (t2 - t1));
            }
        });
        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                long t1 = System.currentTimeMillis();
                for (Integer i : list) {
                }
                long t2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "启动foreath===>" + (t2 - t1));
            }
        });
        Thread th3 = new Thread(new Runnable() {
            @Override
            public void run() {
                ListIterator<Integer> listIterator = list.listIterator();
                long t1 = System.currentTimeMillis();
                while (listIterator.hasNext()) {
                    listIterator.next();
                    listIterator.remove();
                }
                long t2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "启动listIterator===>" + (t2 - t1));
            }
        });
        Thread th4 = new Thread(new Runnable() {
            @Override
            public void run() {
                Iterator<Integer> iterator = list.iterator();
                long t1 = System.currentTimeMillis();
                while (iterator.hasNext()) {
                    iterator.next();
                }
                long t2 = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName() + "启动iterator===>" + (t2 - t1));
            }
        });
        th4.start();
        th2.start();
        th1.start();
        th3.start();

    }
}
