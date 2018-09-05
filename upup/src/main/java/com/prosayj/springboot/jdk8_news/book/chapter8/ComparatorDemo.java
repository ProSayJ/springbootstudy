package com.prosayj.springboot.jdk8_news.book.chapter8;


import com.prosayj.springboot.jdk8_news.book.domain.Person;

import java.util.Arrays;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.Comparator.nullsFirst;
import static java.util.Comparator.naturalOrder;

import java.util.stream.Stream;

//比较器
public class ComparatorDemo {

    public static void m1() {
        Person[] ps = {new Person("女", "chenli", 33), new Person("男", "张楠", 35),
                new Person("女", "lili", 20), new Person("男", "hanmeimei", 25),
                new Person("女", "lucy", 25)};
        //先按性别排序，然后按年龄排序
        Arrays.sort(ps, comparing(Person::getGender).thenComparing(Person::getAge));
        Stream.of(ps).forEach(System.out::print);
        System.out.println();

        //还可以提供一个比较器
        Arrays.sort(ps, comparing(Person::getName, (s, t) -> Integer.compare(s.length(), t.length())).thenComparing(Person::getAge));

        //comparing有避免int\long\double值装箱\拆箱的重载形式
        Arrays.sort(ps, comparingInt(person -> person.getName().length()));

        Person[] ps2 = {new Person("女", "chenli", 33), new Person("男", "张楠", 35),
                new Person("女", "lili", 20), new Person("男", "hanmeimei", 25),
                new Person("女", "lucy", 25), new Person("女", null, 14)};
        //nullsFirst对null值进行处理
        //naturalOrder为所有实现了Comparable接口的类生成一个比较器
        Arrays.sort(ps2, comparing(person -> person.getName(), nullsFirst(naturalOrder())));
        Stream.of(ps2).forEach(System.out::print);
    }

    public static void main(String[] args) {
        m1();
    }

}
