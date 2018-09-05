package com.prosayj.springboot.java数据结构.cha02.LinkedCollection;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/19 12:00
 * @since 1.0.0
 */
public class LinkedCollection {
    /**
     * 头节点
     */
    protected Entry head;

    /**
     * 构造方法
     */
    public LinkedCollection() {
    }

    /**
     * 添加元素
     *
     * @param o
     * @return
     */
    public boolean add(Object o) {
        Entry entry = new Entry();
        entry.element = o;
        head = entry;
        entry.next = head;
        return true;
    }

    public int size() {
        int count = 0;
        for (Entry current = head; current != null; current = current.next) {
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public boolean contains(Object o) {
        for (Entry current = head; current != null; current = current.next) {
            if (current.element.equals(o)) {
                return true;
            }
        }
        return false;

    }


    protected static class Entry {
        Object element;
        Entry next;
    }
}
