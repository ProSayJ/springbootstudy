package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._01;

import org.junit.Test;

/**
 * @author yangjian
 * @description 变量的作用域
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/10 16:14
 * @since 1.0.0
 */
public class _04_VariableScope {
    @Test
    public void m1() {
//        repeatMessage("Hello", 1000);
//        repeatMessage03("Hello", 1000);
        repeatMessage04();
    }

    public static void main(String[] args) {
        new _04_VariableScope().repeatMessage04();
    }

    public void repeatMessage(String text, int count) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < count; i++) {
                //text 和 count 有时候被定义了，有时候没有被定义，为毛？？？
                Thread.yield();
                System.out.println(text + i);
            }
        });
        thread.start();
    }

    //lambda表达式可以捕获闭作用域中的变量，在java中，为了确保被捕获的值是良好的被定义的，需要遵循一个重要的约束。
    public void repeatMessage02(String text, int count) {
        Thread thread = new Thread(() -> {
            while (count > 0) {
                //count--;//不能更改已经捕获的值。
                Thread.yield();
                System.out.println(text);
            }
        });
        thread.start();
    }

    //

    /**
     * 内部类也会捕获闭合作用域的值：
     * 1.8以前，内部类允许访问final修饰的局部变量。
     * 为了使用lambda表达式，这条规则被放宽：
     * 一个内部类可以访问任何有效的final局部变量--即：任何值不会变化的变量。
     */
    public void repeatMessage03(String text, int count) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count > 0) {
                    //count--;//不能更改已经捕获的值。
                    Thread.yield();
                    System.out.println(text + count);
                }
            }
        });
        thread.start();
    }

    @Test
    //lambda引用的this是不是Runnable实例的toString(),
    public void repeatMessage04() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String x = this.toString();
                System.out.println(x);
            }

        });
        thread.start();

    }

    @Override
    public String toString() {
        return "我是外部调用的toString()";
    }
}
