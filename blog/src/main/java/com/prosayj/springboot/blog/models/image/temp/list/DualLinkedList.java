package com.prosayj.springboot.blog.models.image.temp.list;

/**
 * @author wang.xw
 * @date 2018/3/2 10:23.
 */
public class DualLinkedList<E> {
    private int size;
    private Node first;
    private Node last;

    private class Node<E> {
        private Node next;
        private Node pre;
        private E data;

        public Node(Node pre, Node next, E e) {
            this.pre = pre;
            this.next = next;
            this.data = e;
        }

    }

    public int size() {
        return size;
    }

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        final Node<E> oldlast = last;
        Node newNode = new Node(oldlast, null, e);
        last = newNode;
        if (first == null) {
            first = newNode;
        } else {
            oldlast.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * 在指定索引处添加元素
     *
     * @param index
     * @param e
     * @return
     */
    public boolean add(int index, E e) {
        checkIndex(index);
        addBefore(e, getIndex(index));
        return true;
    }

    private void addBefore(E e, Node cur) {
        Node<E> pred = cur.pre;
        Node<E> newNode = new Node<>(pred, cur, e);
        cur.pre = newNode;
        if (pred == null) {
            first = newNode;
        } else {
            pred.next = newNode;
        }
        size++;
    }

    /**
     * 删除元素
     *
     * @return
     */
    public boolean remove(E e) {
        for (Node<E> x = first; x != null; x = x.next) {
            if (e.equals(x.data)) {
                unlink(x);
            }
        }
        return true;
    }

    /**
     * 根据索引删除元素
     *
     * @param index
     * @return
     */
    public boolean remove(int index) {
        checkIndex(index);
        Node node = getIndex(index);
        unlink(node);
        return true;
    }

    private void unlink(Node<E> x) {

        final Node<E> pred = x.pre;
        final Node<E> next = x.next;
        if (pred == null) {
            first = next;
        } else {
            pred.next = next;
            x.pre = null;
        }
        if (next == null) {
            last = pred;
        } else {
            next.pre = pred;
            x.next = null;
        }

        x.data = null;
        size--;
    }

    /**
     * 检查索引合法性
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index < 0 || index - size >= 0) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
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
        if (node != null) {
            return (E) node.data;
        }
        return null;

    }

    /**
     * 二分法取的节点
     *
     * @param index
     * @return
     */
    private Node getIndex(int index) {
        checkIndex(index);
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.pre;
            }
            return x;
        }
    }


}
