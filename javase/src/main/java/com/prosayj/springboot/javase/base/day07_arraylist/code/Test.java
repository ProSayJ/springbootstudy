package com.prosayj.springboot.javase.base.day07_arraylist.code;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/26 下午 10:30
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add(" ");
        list.add("1");
        list.add("2");
        list.add(" ");
        list.add("4");
        list.add(" ");
        list.add("5");
        list.add(" ");
        /*
        list.forEach(data -> {
            if (data.equals("5")) {
                list.remove(data);
            }
        });
        */
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if (next.equals("5")) {
                iterator.remove();
            }
        }
        list.ensureCapacity(10);


    }
}
