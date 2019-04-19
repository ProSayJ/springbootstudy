package com.prosayj.springboot._04_Java高并发编程详解._02_;

import java.util.stream.IntStream;

/**
 * @author yangjian
 * @description 给线程命名
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 13:45
 * @since 1.0.0
 */
public class _02_NamedThreadName {
    private final static String PREFIX = "ALEX-";

    public static void main(String[] args) {
        IntStream.range(0, 5).mapToObj(_02_NamedThreadName::createThread).forEach(Thread::start);
    }

    public static Thread createThread(final int intName) {
        return new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, PREFIX + intName);
    }
}
