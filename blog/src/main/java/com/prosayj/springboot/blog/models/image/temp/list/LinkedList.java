package com.prosayj.springboot.blog.models.image.temp.list;

import java.util.NoSuchElementException;

/**
 * @author wang.xw
 * @date 2018/2/14 9:45.
 */
public class LinkedList<E> {
    private int size = 0;
    /**
     * 头结点
     */
    private Node<E> first;
    /**
     * 尾节点
     */
    private Node<E> last;

    static class Node<E> {
        E data;
        Node<E> next;

        Node(Node next, E data) {
            this.next = next;
            this.data = data;
        }
    }

    public int size() {
        return size;
    }

    /**
     * 向头部增加节点
     *
     * @param e
     * @return
     */
    public boolean addFirst(E e) {
        final Node newNode = new Node(null, e);
        if (first == null) {
            this.first = newNode;
        } else {
            Node oldFirst = first;
            newNode.next = oldFirst;
            first = newNode;
        }
        size++;
        return true;
    }

    /**
     * 向末尾添加
     * <li>插入一个新节点要考虑头结点是不是为null</>
     * <li>在单向链表中，插入一个新节点,一定要知道他的前一个节点</>
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        Node oldLast = last;
        final Node newNode = new Node(null, e);
        last = newNode;
        if (first == null) {
            this.first = newNode;
        } else {
            oldLast.next = newNode;
            last = newNode;
        }
        size++;
        return true;
    }

    /**
     * <li>在单向链表中，插入一个新节点,一定要知道他的前一个节点</>
     * <li>头结点不存在</>
     *
     * @param index
     * @param e
     * @return
     */
    public boolean addIndex(int index, E e) {
        checkIndex(index);
        final Node newNode = new Node(null, e);
        if (index == 0) {
            addFirst(e);
        } else {
            Node pre = getIndex(index - 1);
            newNode.next = pre.next;
            pre.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 根据索引删除元素
     *
     * @param index
     * @return
     */
    public boolean reomve(int index) {
        checkIndex(index);
        // 删除头结点
        if (index == 0) {
            Node oldFirst = first;
            first = oldFirst.next;
            oldFirst.next = null;
            oldFirst.data = null;

        } else {
            // 获得眼输出节点的前一个节点
            Node pre = getIndex(index - 1);
            // 要删除的节点
            Node remove = pre.next;
            // 空出当前节点
            pre.next = remove.next;
            remove.data = null;

        }
        size--;
        return true;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public E getData(int index) {
        checkIndex(index);
        Node node = getIndex(index);
        return (E) node.data;
    }

    /**
     * 检查索引的合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index - size >= 0 || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }

    private Node getIndex(int index) {
        if (first == null) {
            throw new NoSuchElementException();
        }
        Node node = first;
        for (int i = 0; i < index && node.next != null; i++) {
            node = node.next;
        }
        return node;
    }


}
