package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_4_线程等待和唤醒waitnotify_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yangjian
 * @description 模拟生产者消费者
 * @email yangjian@bubi.cn
 * @creatTime 2018/11/7 0:04
 * @since 1.0.0
 */
public class _Test {
    public static List<Apple> basket = new ArrayList<>();

    public static void main(String[] args) {
        new Productor().createApple();
        new Customer().eatApple();
    }
}

class Customer {
    public void eatApple() {
        new Thread(() -> {
            System.out.println("eat:" + Thread.interrupted());
            while (true) {
                synchronized (_Test.basket) {
                    _Test.basket.forEach(data -> {
                        System.out.println("消费者" + Thread.currentThread().getName() + "吃掉了名字叫做:" + data.getName() + "的苹果~~");
                    });
                    _Test.basket.clear();
                    try {
                        _Test.basket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class Productor {
    public void createApple() {
        System.out.println("create:" + Thread.interrupted());
        new Thread(() -> {
            while (true) {
                Apple apple = new Apple("苹果名称是：【" + new Random().nextInt(100) + "】");
                System.out.println("生产者" + Thread.currentThread().getName() + "产生了名字叫做:" + apple.getName() + "的苹果~~");

                synchronized (_Test.basket) {
                    _Test.basket.add(apple);
                    _Test.basket.notifyAll();
                    try {
                        //睡眠主要是为了保证本次的notifyAll()可以唤醒睡眠的线程
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

class Apple {
    private String name;

    public Apple(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                '}';
    }
}