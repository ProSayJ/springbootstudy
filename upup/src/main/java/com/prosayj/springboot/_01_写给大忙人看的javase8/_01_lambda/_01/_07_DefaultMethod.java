package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda._01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/10 17:05
 * @since 1.0.0
 */
public class _07_DefaultMethod {
    @Test
    //许多开发语言都将函数表达式集成到了其集合库中。 这样比循环方式所需的代码更少。
    public void m1() {
        List<Integer> list = new ArrayList<Integer>() {{
            add(6);
            add(165);
            add(3);
            add(19);
            add(99);
        }};
        list.forEach(System.out::println);
        System.out.println(list);

        List<Integer> listTemp = new ArrayList<>();
        list.forEach(listTemp::add);
        System.out.println(listTemp);
    }

    @Test
    public void m2() {
        new Som().m2();
    }
}

interface I1 {
    void m1();

    default void m2() {
        System.out.println("I1父接口的m2执行");
    }
}
interface I2 {
    void m1();

    default void m2() {
        System.out.println("I2父接口的m2执行");
    }
}

class Som implements I1,I2{

    @Override
    public void m1() {

    }
    @Override
    public void m2() {

    }
}
