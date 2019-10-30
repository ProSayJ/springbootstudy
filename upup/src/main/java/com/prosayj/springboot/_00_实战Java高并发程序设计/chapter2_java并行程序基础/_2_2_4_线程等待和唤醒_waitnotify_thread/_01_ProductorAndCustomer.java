package com.prosayj.springboot._00_实战Java高并发程序设计.chapter2_java并行程序基础._2_2_4_线程等待和唤醒_waitnotify_thread;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TimerTask;

/**
 * @author yangjian
 * @description 模拟生产者和消费者
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/25 下午 02:19
 * @since 1.0.0
 */
public class _01_ProductorAndCustomer {
    public static void main(String[] args) {
        new Thread(new Productror()).start();
        new Thread(new Customer()).start();
    }

    public static final List<Apple> basket = new ArrayList<>();

    /**
     * 生产者
     */
    static class Productror implements Runnable {
        @Override
        public void run() {
            synchronized (basket) {
                while (true) {
                    try {
                        if (basket.size() > 10) {
                            System.out.println("篮子的水果已经满啦，快来吃啊");
                            basket.notify();
                        } else {
                            System.out.println(Thread.currentThread().getName() + "开始摘苹果咯");
                            while (basket.size() < 10) {
                                long l = new Random().nextLong();
                                Apple apple = new Apple("苹果" + l, "颜色" + l);
                                Thread.sleep(500L);
                                basket.add(apple);
                                System.out.println("摘到苹果:===>" + basket.size() + apple);
                            }
                            System.out.println("摘苹果完成，开始等待消费");
                            basket.wait();
                            basket.notify();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /**
     * 消费者
     */
    static class Customer implements Runnable {
        @Override
        public void run() {
            synchronized (basket) {
                while (true) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "开始吃苹果啦");
                        if (!CollectionUtils.isEmpty(basket)) {
                            while (basket.iterator().hasNext()) {
                                System.out.println("吃了" + basket.iterator().next()+"还剩" + basket.size() + "个苹果");
                                basket.remove(basket.iterator().next());
                                Thread.sleep(500L);
                            }
                        }
                        System.out.println("没有苹果吃了...我等着苹果的到来");
                        basket.notify();
                        basket.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }


    static class Apple {
        private String name;
        private String color;

        public Apple(String name, String color) {
            this.name = name;
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "name='" + name + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

}
