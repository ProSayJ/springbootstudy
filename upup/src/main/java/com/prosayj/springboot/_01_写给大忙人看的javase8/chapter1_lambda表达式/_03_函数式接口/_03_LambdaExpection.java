package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._03_函数式接口;

import static java.lang.Thread.sleep;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/10 下午 11:44
 * @since 1.0.0
 */
@FunctionalInterface
public interface _03_LambdaExpection {
    void threadExpection() throws InterruptedException;
    //void threadExpection() ;
}

class _03_Test {
    public static void main(String[] args) throws InterruptedException {
        _03_LambdaExpection lambdaExpection = () -> {
            new Thread(() -> {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ).start();
        };
        lambdaExpection.threadExpection();
    }
}