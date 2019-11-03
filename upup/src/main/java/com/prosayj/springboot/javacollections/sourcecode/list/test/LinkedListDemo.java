package com.prosayj.springboot.javacollections.sourcecode.list.test;

import com.prosayj.springboot.javacollections.sourcecode.list.linkedlist.LinkedListSrc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/3 下午 02:43
 * @since 1.0.0
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        /**
         *
         * LinkedList源码简介总结：{@link LinkedListSrc}
         * 1：LinkedList内部是一个链表的实现，一个节点除了保持自身的数据外，还持有前，后两个节点的引用。可为null值。
         * 2：所以就数据存储上来说，它相比使用数组作为底层数据结构的ArrayList来说，会更加耗费空间。
         * 3：但也正因为这个特性，它删除，插入节点很快！
         * 4：LinkedList没有任何同步手段，所以多线程环境须慎重考虑.
         * 5：可以使用Collections.synchronizedList(new LinkedList(...));保证线程安全。
         * 6：相比于ArrayList，它额外实现了双端队列接口Deque，这个接口主要是声明了队头，队尾的一系列方法。
         *
         */
        List<String> list = new LinkedListSrc<String>() {{
            addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g"));
        }};
        System.out.println("list.toString() = " + list.toString());
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            //测试修改异常。
            //list.remove("f");
            String next = iterator.next();
            if ("f".equals(next)) {
                iterator.remove();
            }
            System.out.println("iterator.next() = " + next);
        }
        System.out.println("list.toString() = " + list.toString());


        /**
         * 成员变量：
         * 1：{@link LinkedListSrc#size}：当前存储的元素个数。
         * 1：{@link LinkedListSrc#first}：头节点。
         * 2：{@link LinkedListSrc#last}：尾节点。
         * 3：{@link LinkedListSrc#serialVersionUID}：序列化版本ID。ps目的是为了表示不同版本的兼容性。
         */
        /**
         * 构造方法：
         * 1：{@link LinkedListSrc#LinkedListSrc()}：无参构造方法。
         * 2：{@link LinkedListSrc#LinkedListSrc(Collection)}：集合参数的构造器。
         */

        /**
         * 常用方法：
         * 1：{@link LinkedListSrc#add(Object)}：添加一个元素。
         * 2：{@link LinkedListSrc#add(int, Object)} ：添加元素到指定的位置。
         */


    }
}
