package com.prosayj.springboot._04_Java高并发编程详解._09_类的加载过程._9_3;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/6 上午 01:05
 * @since 1.0.0
 */
public class ClassResolve {
    static Simple simple = new Simple();
    public static void main(String[] args) {
        System.out.println(simple);
    }
}
