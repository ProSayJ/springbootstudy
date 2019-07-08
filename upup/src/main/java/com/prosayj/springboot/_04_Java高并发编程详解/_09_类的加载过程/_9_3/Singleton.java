package com.prosayj.springboot._04_Java高并发编程详解._09_类的加载过程._9_3;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/5 下午 06:12
 * @since 1.0.0
 */
public class Singleton {

    //private static int x = 0;
    //private static int y;
    private static Singleton instance = new Singleton();
    private static int x = 0;
    private static int y;

    private Singleton() {
        x++;
        y++;
    }

    public static Singleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println(instance.x);
        System.out.println(instance.y);
    }
}
