package com.prosayj.springboot._04_Java高并发编程详解._02_深入理解Thread构造函数;

import java.util.stream.IntStream;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 13:36
 * @since 1.0.0
 */
public class _01_TestDefaultThreadName {
    public static void main(String[] args) {
        IntStream.range(0, 5).boxed().map(i -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);

        IntStream.range(0, 5).boxed().map(
                i -> new Thread(
                        () -> {
                            System.out.println(Thread.currentThread().getName());
                        }
                )
        ).forEach(Thread::start);
    }
}
