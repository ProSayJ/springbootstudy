package com.prosayj.springboot.javase.base.day18_arraylist.code;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author yangjian
 * @description 关于遍历arrayList的并发修改异常
 * @email yangjian@bubi.cn
 * @creatTime 2018/5/29 10:55
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(7);
        list.add(3);
        list.add(8);
        System.out.println(list.toString());
        m1(list);
//        m2(list);
    }

    private static void m2(List<Integer> list) {
        for (int data:list) {
            if (data == 3) {
                list.remove(list.indexOf(data));
            }
        }
        System.out.println(list.toString());
    }

    public static void m1(List<Integer> list) {
        ListIterator<Integer> integerListIterator = list.listIterator();
        while (integerListIterator.hasNext()) {
            Integer next = integerListIterator.next();
            if (next == 3) {
//                integerListIterator.remove();
                list.remove(next);
            }
        }
        System.out.println(list.toString());
    }
}
