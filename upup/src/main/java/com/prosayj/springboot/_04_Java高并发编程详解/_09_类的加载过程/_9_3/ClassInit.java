package com.prosayj.springboot._04_Java高并发编程详解._09_类的加载过程._9_3;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/6 上午 01:30
 * @since 1.0.0
 */
public class ClassInit {
    static {
        try {
            System.out.println("The ClassInit static code block will be invoke");
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(i -> new Thread(ClassInit::new));
    }
}
