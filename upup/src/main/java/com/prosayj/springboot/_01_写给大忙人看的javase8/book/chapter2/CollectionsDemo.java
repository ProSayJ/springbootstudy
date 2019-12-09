package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter2;


import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.toList;

public class CollectionsDemo {

    public static void m1() {
        List<String> l = new ArrayList<String>() {{
            add("love");
            add("make");
            add("ok");
        }};
        //可以控制Set的类型
        TreeSet<String> t = l.stream().collect(Collectors.toCollection(TreeSet::new));

        //如果流包含字符串以外的对象，需要先把对象转换为字符串
        List<Button> lb = new ArrayList<Button>() {{
            add(new Button("zhangsulei"));
            add(new Button("chenli"));
        }};
        String s = lb.stream().map(Button::toString).collect(Collectors.joining(", "));
        System.out.println(s);

        //将流的结果聚合为一个总和、平均值、最大值或最小值
        IntSummaryStatistics summary = l.stream().collect(Collectors.summarizingInt(String::length));

        List<Button> lb2 = new ArrayList<Button>() {{
            add(new Button(1, "zhangsulei"));
            add(new Button(2, "chenli"));
        }};
        Map<Integer, String> m = lb2.stream().collect(Collectors.toMap(Button::getId, Button::getName));
        //使用对象本身作为key
        Map<Integer, Button> m2 = lb2.stream().collect(Collectors.toMap(Button::getId, Function.identity()));

        //指定返回类型为TreeMap
        TreeMap<Integer, Button> m3 = lb2.stream().collect(Collectors.toMap(Button::getId, Function.identity(),
                (existingValue, newValue) -> {
                    throw new IllegalStateException();
                }, TreeMap::new));
        System.out.println(m3);

        List<Button> lb3 = new ArrayList<Button>() {{
            add(new Button(1, "zhangsulei"));
            add(new Button(2, "chenli"));
            add(new Button(1, "zhangsulei2"));
        }};
        Map<Integer, Set<String>> m4 = lb3.stream().collect(
                groupingBy(Button::getId,
                        mapping(Button::getName, toSet())));
        System.out.println(m4);

        List<Integer> ll = lb3.stream().map(Button::getId).collect(toList());
    }

    public static void main(String[] args) {
        m1();
    }
}

class Button {

    private int id;
    private String name;

    public Button(String name) {
        super();
        this.name = name;
    }

    public Button(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Button [name=" + name + "]";
    }


}
