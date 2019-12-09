package com.prosayj.springboot.java数据结构.玩转数据结构.src

public interface Map<K, V> {

    void add(K key, V value);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    V remove(K key);
    int getSize();
    boolean isEmpty();
}
