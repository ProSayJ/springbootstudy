package com.prosayj.springboot.javase.homework.day01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:38
 * @since 1.0.0
 */
//03：请在_Test02中写一个分割函数，将一个String 按照某个字符分割成为一个数组。
//        例如：ab,c,4,5 如果用逗号分隔，则结果是[ab c 4 5]；
//        要求自己实现算法，不得用String 类的split方法。
public class _Test02 {
    public static void main(String[] args) {
        String array = "123,ab,345,y,ui";
        splitString(array);
    }


    public static void splitString(String array){
        List<String> list = new ArrayList<>();
        int b = array.indexOf(",");
        while (b>0){
          list.add(array.substring(0,b));
            array = array.substring(b+1,array.length());
            b = array.indexOf(",");
        }
        list.add(array);
        String[] strings = list.toArray(new String[list.size()]);
       // System.out.println(strings);
/*        for (String s: strings) {
            System.out.println(s);
        }*/
        System.out.print("[");
    for(int i = 0;i<strings.length;i++){
        System.out.print(strings[i]+" ");
    }
        System.out.print("]");
    }
}

