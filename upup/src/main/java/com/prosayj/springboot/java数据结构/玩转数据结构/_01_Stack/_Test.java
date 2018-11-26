package com.prosayj.springboot.java数据结构.玩转数据结构._01_Stack;

import java.util.Stack;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/15 22:43
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);

        Stack<String> stringStack = new Stack<>();


    }
}
