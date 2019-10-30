package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._01_为什么要使用lambda表达式;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author yangjian
 * @description 什么是lambda?
 * Java Lambda表达式是⼀种匿名函数；它是没有声明的⽅法，即没有访问修饰符、返回值声明和名字
 * <p>
 * lambda的作用？
 * 1：提升抽象层次
 * 2：API重⽤性更好
 * 3：更加灵活
 * <p>

 * 为什么需要lambda：?
 * 在Java中，我们⽆法将函数作为参数传递给⼀个⽅法，也⽆法声明返回⼀个函数的⽅法。
 * 在JavaScript中，函数参数是⼀个函数，返回值是另⼀个函数的情况是⾮常常⻅的； JavaScript是一门非常典型的函数式语⾔。
 * <p>
 * lambda的作用：
 * Lambda表达式为Java添加了缺失的函数式编程特性，使我们能将函数当做⼀等公⺠看待
 * 在将函数作为⼀等公⺠的语⾔中， Lambda表达式的类型是函数。
 * 但在Java中， Lambda表达式是对象，他们必须依附于⼀类特别的对象类型——函数式接⼝(functional interface)
 * <p>
 * <p>
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/11 上午 09:31
 * @since 1.0.0
 */
public class _00_Readme {
    @Test
    public void test() {
        List<Integer> list = Arrays.asList(1, 3, 2, 9, 8, 5);


        //外部迭代
        System.out.println("==========外部迭代==========");
        for (int number : list) {
            System.out.println(number);
        }

        //内部迭代
        System.out.println("==========内部迭代==========");
        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        //再进一步
        System.out.println("=========再进一步===========");
        list.forEach((Integer value) -> System.out.println(value));

        //更进一步
        System.out.println("========更进一步============");
        list.forEach(value -> System.out.println(value));

        //继续
        System.out.println("========继续============");
        list.forEach(System.out::println);

    }
}
