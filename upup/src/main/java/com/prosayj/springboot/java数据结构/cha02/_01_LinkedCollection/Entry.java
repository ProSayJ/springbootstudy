package com.prosayj.springboot.java数据结构.cha02._01_LinkedCollection;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/12 0:21
 * @since 1.0.0
 */
public class Entry<T> {
    /**
     * (头+体+尾)--->(头+体+尾)-->(头+体+尾)
     */
    Entry<T> head;
    Object element;
    Entry<T> next;

    public Entry<T> getHead() {
        return head;
    }

    public Entry<T> setHead(Entry<T> head) {
        this.head = head;
        return this;
    }

    public Object getElement() {
        return element;
    }

    public Entry<T> setElement(Object element) {
        this.element = element;
        return this;
    }

    public Entry<T> getNext() {
        return next;
    }

    public Entry<T> setNext(Entry<T> next) {
        this.next = next;
        return this;
    }

    @Override
    public String toString() {
        return "Entry{" +
                "head=" + head +
                ", element=" + element +
                ", next=" + next +
                '}';
    }
}
