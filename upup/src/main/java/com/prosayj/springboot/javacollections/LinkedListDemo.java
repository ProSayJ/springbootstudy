package com.prosayj.springboot.javacollections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yangjian
 * @description <p>
 * <p>
 * 参考：https://blog.csdn.net/m0_37884977/article/details/80467658
 * </p>
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 上午 10:26
 * @since 1.0.0
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();

        list.add("112");
        list.add("3");
        list.add("2");
        list.add("3");
        list.add("9");
        list.add(null);
        System.out.println(list.toString());
        /**
         * 添加元素：
         * 1：获取到最后一个节点
         * 2：把元素添加到链表尾部
         * 3：有序可重复,可以为null值。
         * 结论：LinkedList底层是一个双链表。是一个直线型的链表结构。
         */


        System.out.println("list.getFirst() = " + list.getFirst());
        System.out.println("list.getLast() = " + list.getLast());
        System.out.println("list.get(3) = " + list.get(3));
        /**
         * 获取
         */


        System.out.println("list.peek() = " + list.peek());
        System.out.println("list.poll() = " + list.poll());
        /**
         * 获取栈顶元素
         */


        list.push("777");
        System.out.println("list.toString() = " + list.toString());
        /**
         * 压栈：把元素压栈顶
         */


        System.out.println("list.get(0) = " + list.get(0));
        /**
         * 获取指定角标的元素
         * 1:边界检查
         * 2:查找节点:LinkedList还对整个做了优化，不是盲目地直接从头进行遍历，而是先比较一下index更靠近链表（LinkedList）的头节点还是尾节点。然后进行遍历，获取相应的节点
         *  2.1：二分查找(向下取整)节点所在的位置。
         *  2.1.1: 左半边部分
         *         头部开始遍历，获取next 循环赋值，直到index为止。
         *  2.1.1: 右半边部分
         *          尾部开始遍历，获取prev 循环赋值，直到index为止。
         * 3：返回节点itme
         * 总结：
         */


        System.out.println("list.remove() = " + list.remove());
        /**
         * 总结：removeFirst()
         */



        list.add(null);
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.remove(null) = " + list.remove(null));
        System.out.println("list.toString() = " + list.toString());
        System.out.println("list.remove(3) = " + list.remove("3"));
        System.out.println("list.toString() = " + list.toString());
        /**
         * 结论：remove只能从链表头开始，移除第一次match的元素。
         */


        System.out.println("list.remove(3) = " + list.remove(1));
        System.out.println("list.toString() = " + list.toString());
        /**
         * 计算指定索引上的节点（返回Node）
         * 1:索引检测
         */


    }


}
