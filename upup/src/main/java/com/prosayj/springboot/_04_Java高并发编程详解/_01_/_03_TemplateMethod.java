package com.prosayj.springboot._04_Java高并发编程详解._01_;

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


    public void print(String message) {
        System.out.println("##########################");
        warpPrint(message);
        System.out.println("##########################");
    }

    protected void warpPrint(String message) {

    }
}
