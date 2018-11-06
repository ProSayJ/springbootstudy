package com.prosayj.springboot.实战Java高并发程序设计.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/11/7 0:04
 * @since 1.0.0
 */
public class _Test {
    public static Object obj = new Object();
    public static List<Apple> basket = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        new Productor().createApple();
        new Customer().eatApple();
    }
}

class Customer {
    public void eatApple() {
        new Thread(() -> {
            synchronized (_Test.obj) {
                System.out.println("eat:" + Thread.interrupted());
                while (true) {
                    _Test.basket.forEach(data -> {
                        System.out.println("消费者" + Thread.currentThread().getName() + "吃掉了名字叫做:" + data.getName() + "的苹果~~");
                    });
                    _Test.basket.clear();
                    break;
                }
                try {
                    this.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Productor {
    public void createApple() {
        synchronized (_Test.obj) {
            System.out.println("create:" + Thread.interrupted());
            new Thread(() -> {
                while (true) {
                    Apple apple = new Apple("苹果名称是：【" + new Random().nextInt(100) + "】");
                    System.out.println("生产者" + Thread.currentThread().getName() + "产生了名字叫做:" + apple.getName() + "的苹果~~");
                    _Test.basket.add(apple);
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    this.notifyAll();
                    System.out.println(_Test.basket.size());
                }
            }).start();
        }
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