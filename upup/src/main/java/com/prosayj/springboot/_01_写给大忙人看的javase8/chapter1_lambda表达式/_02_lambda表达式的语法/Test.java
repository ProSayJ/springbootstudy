package com.prosayj.springboot._01_写给大忙人看的javase8.chapter1_lambda表达式._02_lambda表达式的语法;
/**
 * @description
 * @author yangjian
 * @Date 下午 11:06 2019/9/10
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        m1(a, b);
    }


    private static void m1(int a, int b) {
        Integer.compare(a, b);
    }

    class MyComparator implements Comparable {

        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
