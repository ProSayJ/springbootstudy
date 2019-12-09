package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._01;

import org.junit.Test;

import java.util.*;

/**
 * @author yangjian
 * @description 函数式接口：
 * <p>
 * 对于只包含一个抽象方法的接口，你可以通过lambda表达式来创建该接口的对象，这种接口被称为函数式接口。
 * 我们使用注解：@FunctionalInterface来标识是一个函数式接口标识。但是并不强制使用。使用该注解有两个好处：
 * 1>编译器会检查有该注解的实体，检查它是否是只包含一个抽象方法的接口。
 * 2>代码看上去更清楚。
 * <p/>
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/10 14:50
 * @since 1.0.0
 */
public class _00_FunctionInterface {
    //函数式接口_线程启动
    @Test
    public void test01() {
        /***
         * 匿名内部类
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类==>" + Thread.currentThread().getName() + "启动");
            }
        }).start();
        /**
         * lambda表达式：函数式编程。
         */
        new Thread(() -> {
            System.out.println("lambda表达式==>" + Thread.currentThread().getName() + "启动");
        }).start();

        //what???
        new Thread() {{
            System.out.println(Thread.currentThread().getName() + "启动");
        }};
    }


    //函数式接口_比较器
    @Test
    public void test02() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(6);
            add(165);
            add(3);
            add(19);
        }};
        System.out.println("初始化集合：" + list);

        Collections.sort(list);
        System.out.println("默认升序排列：" + list);


        /***
         * 匿名内部类
         */
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序排列
                return Integer.compare(o2, o1);
            }
        });
        System.out.println("自定义比较器_匿名内部类_降序：" + list);

        // a,b 自动类型推断
        Collections.sort(list, (a, b) -> {
            //升序排列
            return Integer.compare(a, b);
        });
        System.out.println("自定义比较器_lambda_升序：" + list);

    }


    /**
     * 注意：lambda表达式在转成函数式接口的时候，需要注意处理期的检查异常。
     * 这里，Runnable接口没有抛出任何异常，所以lambda里面的方法有异常是不可以抛出去的。
     * 要么，内部catch。要么将lambda表达式赋值给一个抽象的可以抛出方法异常的接口。
     */
    public void test03() {
        Runnable runnable = () -> {
            System.out.println("Zzzz");
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
    }
}
