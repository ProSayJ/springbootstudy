package com.prosayj.springboot.java数据结构.cha05_数组列表.myarraylist;

import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/2 22:56
 * @since 1.0.0
 */
public class MyArrayList<E> implements Collection {
    /*************************************静态常量**************************************************/
    /**
     * 无参构造方法创建的空数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * 有参构造方法创建的空数组
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};
    /**
     * Default initial capacity.
     * 默认初始化容量
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * ArrayList的大小（指其所含的元素个数，真实的数据大小）
     */
    private int size;
    /**
     * 这个列表在结构上被修改了很多次。
     * 结构修改是指改变了
     * 列表，或者以一种迭代的方式扰乱它
     * 进展可能产生不正确的结果。
     */
    protected int modCount = 0;
    /**
     * 数组可被分配的最大容量。
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    /*************************************静态常量end**************************************************/

    /**
     * 基于数组实现的ArrayList
     */
    Object[] elementData;

    /**********************************构造方法***********************************************/
    /**
     * 无参构造方法。创建对象，初始化数组大小
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;

    }

    /**
     * 有参构造方法，初始化List大小
     *
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }
    /**********************************构造方法end***********************************************/


    /**********************************基础方法***********************************************/
    /**
     * 清除数组中多余的容量
     */
    public void trimToSize() {
        modCount++;
        //如果真实的数据大小小于数组的大小
        if (size < elementData.length) {
            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
    }

    /**
     * 确保当前List的容量
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        //获取最小的期望扩大的值
        int minExpand = (elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                // any size if not default element table
                ? 0
                // larger than default for default empty table. It's already
                // supposed to be at default size.
                : DEFAULT_CAPACITY;
        //如果这个值大于最新的期望值，则需要扩容
        if (minCapacity > minExpand) {
            ensureExplicitCapacity(minCapacity);
        }
    }

    /**
     * 确保明确的容量
     *
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0) {
            //扩容
            grow(minCapacity);
        }
    }

    /**
     * 扩容方法
     *
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        //获取原来数组容量的长度
        int oldCapacity = elementData.length;
        //新增加的容量长度为原来容量的1.5倍
        //这种算法构造出来的新的数组长度的增量都会比上一次大( 而且是越来越大) ，
        // 即认为客户需要增加的数据很多，而避免频繁newInstance 的情况。
        int newCapacity = +(oldCapacity >> 1);
        //新容量比老容量小，那么新的容量就是老的容量
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        //新创建的容量超过数组的最大值。抛出异常
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            //设置数组可被分配的最大容量
            newCapacity = hugeCapacity(minCapacity);
        }
        // minCapacity is usually close to size, so this is a win:
        //调用复制方法，在原来元素上增加容量，这就是传说中的可变集合。用新长度复制原数组。
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 扩容
     * @param minCapacity
     * @return
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            // overflow
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    //确保内部的容量
    private void ensureCapacityInternal(int minCapacity) {
        //当elementData为空时，ArrayList的初始容量最小为DEFAULT_CAPACITY（10）
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    /**********************************基础方法end***********************************************/


    /**********************************常用方法***********************************************/
    @Override
    public boolean add(Object o) {
        //确保内部容量在增加当前元素以后是否足够
        // Increments modCount!!
        ensureCapacityInternal(size + 1);
        // arrayList的缓冲区把元素添加到缓冲区的末尾
        elementData[size++] = o;
        return true;
    }

    /**********************************常用方法end***********************************************/


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
