package com.prosayj.springboot._04_Java高并发编程详解._09_类的加载过程;

import java.util.Random;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/5 下午 01:03
 * @since 1.0.0
 */
public class GlobalConstants {
    static {
        System.out.println("The GlobalVConstants will be initialized.");
    }
    //在其他类中使用MAX不会导致 GlobalConstants的初始化 ，静态代码块不会输出
    public final static int MAX = 100;

    //虽然 RANDOM 是静态常量 ，但是由于计算复杂 ，只有初始化之后才能得到结果 ，因此在其他类中使用RANDOM 会导致 GlobalConstants 的初始化
    public final static int RANDOM = new Random().nextInt();
}

class Test {
    public static void main(String[] args) {
        System.out.println(GlobalConstants.MAX);
        System.out.println(GlobalConstants.RANDOM);
    }
}
