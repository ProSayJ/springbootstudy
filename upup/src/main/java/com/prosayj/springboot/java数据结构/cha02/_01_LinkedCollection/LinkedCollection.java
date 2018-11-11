package com.prosayj.springboot.java数据结构.cha02._01_LinkedCollection;

import java.util.Arrays;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/19 12:00
 * @since 1.0.0
 */
public class LinkedCollection<T> {

    /**
     * 头节点
     */
    protected Entry<T> head;

    /**
     * 集合容器
     */
    Entry[] container;

    /**
     * 构造方法
     */
    public LinkedCollection() {
        if (container == null) {
            //初始化容量
            container = new Entry[10];
        }
    }

    public LinkedCollection(Integer size) {
        if (container == null) {
            //初始化容量
            container = new Entry[size];
        }
    }

    /**
     * 添加元素
     */
    public boolean add(T o) {
        if (container[0] == null) {
            Entry<T> entry = new Entry<>();
            entry.setHead(null);
            entry.setElement(o);
            container[0] = entry;
        } else {
            if (container[container.length - 1] != null) {
                throw new RuntimeException("请扩容");
            }

            Entry<T> oEntry = new Entry<>();
            oEntry.setElement(o);
            for (int i = 0; i < container.length; i++) {
                if (container[i] == null) {
                    Entry entry = container[i - 1];
                    entry.setNext(oEntry);
                    oEntry.setHead(entry);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "LinkedCollection{" +
                "container=" + Arrays.toString(container) +
                '}';
    }
}
