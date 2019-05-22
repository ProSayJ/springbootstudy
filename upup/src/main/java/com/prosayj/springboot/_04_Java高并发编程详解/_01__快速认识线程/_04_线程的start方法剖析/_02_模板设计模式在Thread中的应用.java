package com.prosayj.springboot._04_Java高并发编程详解._01__快速认识线程._04_线程的start方法剖析;

import org.junit.Test;

/**
 * @author yangjian
 * @description 父类编写算法结构代码，子类实现逻辑细节
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/22 12:44
 * @since 1.0.0
 */
public class _02_模板设计模式在Thread中的应用 {

    @Test
    //模板方法测试
    public void m1() {
        new TemplateMethod() {
            @Override
            protected void wrapPrint(String msg) {
                System.out.println("######" + msg + "######");
            }
        }.print("hello");
    }
}

class TemplateMethod {
    public final void print(String msg) {
        System.out.println("###############");
        wrapPrint(msg);
        System.out.println("###############");

    }

    protected void wrapPrint(String msg) {
    }
}
