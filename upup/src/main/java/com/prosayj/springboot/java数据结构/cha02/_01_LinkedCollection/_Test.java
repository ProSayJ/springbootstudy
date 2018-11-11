package com.prosayj.springboot.java数据结构.cha02._01_LinkedCollection;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/19 12:01
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        LinkedCollection<String> collection = new LinkedCollection<>();
        collection.add("张三");
        collection.add("李四");
        collection.add("王五");
        System.out.println(collection.toString());

    }
}
