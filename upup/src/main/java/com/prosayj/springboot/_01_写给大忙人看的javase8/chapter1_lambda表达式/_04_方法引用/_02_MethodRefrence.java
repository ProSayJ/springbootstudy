package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._04_方法引用;

import java.io.PrintStream;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * @author yangjian
 * @description 对象::实例方法
 * 类::静态方法
 * 类::实例方法
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/11 上午 12:14
 * @since 1.0.0
 */
public class _02_MethodRefrence {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public static void main(String[] args) {
        //System.out::println; 等价于 System.out.println(x);
        PrintStream out = System.out;
        Consumer<String> consumer1 = out::println;
        consumer1.accept("控制台打印数据");


        Callable<String> stringCallable = () -> new _02_MethodRefrence().m1();

        String s = _02_MethodRefrence.staticM2();

    }

    public String m1() {
        return "m1";

    }

    public static String staticM2() {

        return "staticM2";

    }

    public void m3() {
        System.out.println("m3");

    }


}
