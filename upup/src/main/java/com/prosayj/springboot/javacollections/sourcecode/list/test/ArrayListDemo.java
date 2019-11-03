package com.prosayj.springboot.javacollections.sourcecode.list.test;

import com.prosayj.springboot.javacollections.sourcecode.list.arraylist.ArrayListSrc;

import java.util.Collection;
import java.util.List;

/**
 * @author yangjian
 * @description ArrayList源码分析_基于jdk1.8_201
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 上午 10:28
 * @since 1.0.0
 */
public class ArrayListDemo {
    public static void main(String[] args) {

        /**
         *
         * ArrayList源码简介总结：{@link ArrayListSrc}
         * 1：是List接口的实现。他实现了所有的List接口的操作。
         * 2：内部实现是可变大小的(Resizable)数组。
         * 3：内部元素允许null值。
         * 4：除了实现List接口之外，Arraylist这个类还提供了操作(manipulate)数组大小的方法，用于自己内部(internally)存储的列表。
         * 5：这个类粗略的(roughly)和Vector相似。但是他是线程不同步的。也就是说是线程不安全的。
         *
         *
         *
         *
         * 实现了List接口是一个数组队列拥有了List基本的增删改查功能
         * 实现了RandomAccess接口拥有随机读写的功能
         * 实现了Cloneable接口可以被克隆
         * 实现了Serializable接口并重写了序列化和反序列化方法，使得ArrayList可以拥有更好的序列化的性能
         *
         *
         */

        /**
         * 成员变量：
         * 1：{@link ArrayListSrc#serialVersionUID}：序列化版本ID。ps目的是为了表示不同版本的兼容性。
         * 1：{@link ArrayListSrc#DEFAULT_CAPACITY}：默认内置数组容量为10。ps:ArrayList底层结构是数组。
         * 2：{@link ArrayListSrc#EMPTY_ELEMENTDATA}：当指定数组初始化容量是0的时候，使用这个常量赋值。
         * 3：{@link ArrayListSrc#DEFAULTCAPACITY_EMPTY_ELEMENTDATA}：默认无参构造函数是使用这个常量赋值。
         * 4：{@link ArrayListSrc#elementData}：真正存放对象数据的数组。ps：transient表示不被序列化。
         * 5：{@link ArrayListSrc#size}：内置数组中真正存放元素的个数。ps：size <=elementData.length。
         * 6：{@link ArrayListSrc#modCount}：修改次数。ps：继承父类AbstractList。
         */
        /**
         * 构造方法：
         * 1：{@link ArrayListSrc#AbstractListSrc()}：无参构造方法。
         * 2：{@link ArrayListSrc#ArrayListSrc(int)}：指定初始化容量的有参构造方法。
         * 3：{@link ArrayListSrc#ArrayListSrc(Collection)}：集合参数的构造方法。
         */
        /**
         * 常用方法：
         * 1：{@link ArrayListSrc#add(Object)}：添加元素。ps:ensureCapacityInternal(size + 1);
         *  1.1：{@link ArrayListSrc#ensureCapacityInternal(int)}：确认内部容量(内部计数器+1并且扩容如果需要的话)。
         *      1.1.1：{@link ArrayListSrc#calculateCapacity(Object[], int)}：则返回默认的初始化容量(DEFAULT_CAPACITY)与方法入参（size + 1）中较大的一个。
         *          (1):如果当前内置数组(elementData)是 DEFAULTCAPACITY_EMPTY_ELEMENTDATA(this使用无参构造方法初始的时候,内置数组被赋值成DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
         *          (2):否则(elementData !=DEFAULTCAPACITY_EMPTY_ELEMENTDATA),则返回方法的入参（size + 1）。
         *      1.1.2:{@link ArrayListSrc#ensureExplicitCapacity(int)}：确认明确的内部容量。
         *              (1)内部计数器modCount++；(继承自AbstractList)
         *              (2)如果入参(int)大于内置数组的容量(elementData.length),则扩容。
         *                  {@link ArrayListSrc#grow(int)} ：
         *
         *
         *
         *  1.2：elementData[size++] = e;把待添加的元素添加到内部数组的末尾。并且内置数组元素计数个数 + 1。
         *  1.3：return true 返回成功。添加方法结束
         *
         *
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
