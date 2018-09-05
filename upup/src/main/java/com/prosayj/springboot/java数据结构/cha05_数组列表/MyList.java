package com.prosayj.springboot.java数据结构.cha05_数组列表;

/**
 * @author yangjian
 * @description 自定义list接口
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/20 1:10
 * @since 1.0.0
 */
public interface MyList {
    Object get(int index);

    Object set(int index, Object element);

    int indexOf(Object elem);

    void add(Object element);

    Object remove(Object element);
}
