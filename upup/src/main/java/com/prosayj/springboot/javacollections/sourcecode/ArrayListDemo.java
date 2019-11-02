package com.prosayj.springboot.javacollections.sourcecode;

import com.prosayj.springboot.javacollections.sourcecode.list.arraylist.ArrayListSrc;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yangjian
 * @description
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 上午 10:28
 * @since 1.0.0
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        System.out.println(163 >> 1);

        /**
         * ArrayList源码分析：成员变量：
         * 1：DEFAULT_CAPACITY：默认初始化容量为10： {@link ArrayListSrc#DEFAULT_CAPACITY}
         * 2：EMPTY_ELEMENTDATA：
         *
         */


        /**
         * 无参构造方法：默认初始化一个空的
         * {@link ArrayListSrc#ArrayListSrc()}
         */
        List<String> list2 = new ArrayListSrc<>();
        for (int i = 0; i < 200; i++) {
            list2.add("1");
        }
        list2.add("2");
        List<String> list = new ArrayListSrc<String>() {{
            add("1");
            add("3");
            add("2");
            add(null);
            add("4");
            add("1");
        }};
        /**
         * 如何增加元素：
         * 1：集合内内部数组大小+1==》本次add后最小的集合内部数组容量(minCapacity)。第一次add为0 + 1。
         *  1.1：计算内部容量：返回数组组容量。
         *      如果内部数组是空数组(new ArrayList<>(),并且是第一次add元素的时候)，则取（1的入参minCapacity） 和默认的内部素组大小（DEFAULT_CAPACITY）两个值两者最大的一个。第一次add肯定是取值：DEFAULT_CAPACITY。
         *结论1：ArrayList默认初始化大小是10。
         *      需要注意的是：在调用无参构造方法的时候(如：new ArrayList<>())，集合的内部数组为{},第一次add()的时候，默认初始化内部数组大小是10。
         *      在调用有参构造方法的时候(如：new ArrayList<>(12))，如果指定容量大小小于10，则默认初始化为10。大于则使用给的的值初始化集合大小。
         *
         *  1.2：确认是否需要扩容 grow(minCapacity)，如果1.1的返回值大于内部数组的长度的话扩容。
         *    1.2.1：扩容：
         *          1.2.1.1：获取旧的集合内部数组大小
         *          1.2.1.2：新的扩容大小为旧的大小基础上有符号右移动1位置：  int newCapacity = oldCapacity + (oldCapacity >> 1);
         *结论2：默认扩容1.5倍,有小数向上取整。
         *          1.2.1.3：如果新的扩容以后的大小还是小于minCapacity，则扩容的大小就是minCapacity(即扩容1.5以后还是满足不了需求)
         *          1.2.1.4：如果新的扩容以后的大小大于集合内部数组的最大值(MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8),
         *              1.2.1.4.1：如果minCapacity < 0  OOM
         *              1.2.1.4.2： (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
         *结论3：集合内部数组最大值为Integer.MAX_VALUE - 8,ArrayList最大可以存储Integer.MAX_VALUE个元素
         * https://stackoverflow.com/questions/35756277/why-the-maximum-array-size-of-arraylist-is-integer-max-value-8
         *
         *   1.3：Arrays.copyOf(elementData, newCapacity)扩容数组。newCapacity为1.2返回的新的数组的容量。
         *结论3：集合内的数组拷贝是覆盖旧的集合数组地址内存区域，不是新开辟新的区域，并且把旧的区域置为无主内存等gc回收这种方式。
         * 2:将待加入的数据方在集合最后一位：   elementData[size++] = e;
         * 3：返回true
         *
         * 总结：list内部实现是数组：Object[] elementData 元素可以为null。
         *
         * 问题：添加200个元素到ArrayList后内部的数组大小是多少？244
         *
         *
         */


        System.out.println("list.toString() = " + list.toString());
        //有序可重复


        list.add(4, "999");


        System.out.println("list.remove(4) = " + list.remove(4) + " ,list.toString() = " + list.toString());
        /**
         * 如何删除元素
         * 1:边界校验
         * 2:获取待删除的元素。
         * 3：拷贝该角标以后的素组元素到该数组
         * 4：将数组的最后一个元素置为null，gc回收
         * 4：返回删除的元素。
         * 结论：删除元素涉及到数组拷贝。元素越靠近结尾，删除元素效率越高
         */


        System.out.println("list.get(0) = " + list.get(0));
        /**
         * 如何查找元素：
         * 1:边界校验
         * 2:通过内部数组直接定位数组角标所在位置的元素
         * 结论：查询快。
         *
         */
    }
}
