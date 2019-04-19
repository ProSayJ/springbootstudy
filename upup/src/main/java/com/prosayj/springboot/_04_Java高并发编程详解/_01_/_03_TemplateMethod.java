package com.prosayj.springboot._04_Java高并发编程详解._01_;

/**
 * @author yangjian
 * @description 模板方法
 * @Date 9:33 2019/4/19
 * @since 1.0.0
 */
public class _03_TemplateMethod {
    public static void main(String[] args) {
        _03_TemplateMethod t1 = new _03_TemplateMethod() {
            @Override
            protected void warpPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };
        t1.print("hello Thread");


        _03_TemplateMethod t2 = new _03_TemplateMethod() {
            @Override
            protected void warpPrint(String message) {
                System.out.println("+" + message + "+");
            }
        };
        t2.print("hello Thread");

    }


    public final void print(String message) {
        System.out.println("##########################");
        warpPrint(message);
        System.out.println("##########################");
    }

    protected void warpPrint(String message) {

    }
}
