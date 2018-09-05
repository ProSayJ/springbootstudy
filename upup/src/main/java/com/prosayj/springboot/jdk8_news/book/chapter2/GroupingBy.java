package com.prosayj.springboot.jdk8_news.book.chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.BinaryOperator;

import jdk8_news.book.domain.Person;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.joining;

public class GroupingBy {

    public static void m1() {
        List<Person> l = new ArrayList<Person>() {
            {
                add(new Person("male", "zhangsulei", 33));
                add(new Person("famale", "chenli", 34));
                add(new Person("male", "sansan", 33));
                add(new Person("famale", "lili", 23));
                add(new Person("male", "lina", 23));
                add(new Person("male", "zhaonan", 34));
                add(new Person("male", "jerry", 33));
            }
        };
        List<Person> l2 = new ArrayList<Person>() {
            {
                add(new Person("male", "zhangsulei", 33, 13132.3));
                add(new Person("famale", "chenli", 34, 21310.2));
                add(new Person("male", "sansan", 33, 32103.22));
                add(new Person("famale", "lili", 23, 9889.2));
                add(new Person("male", "lina", 23, 31931.2));
                add(new Person("male", "zhaonan", 34, 19394));
                add(new Person("male", "jerry", 33, 21932));
            }
        };
        Map<Integer, List<Person>> m = l.stream().collect(groupingBy(Person::getAge));
        System.out.println(m);
        //groupingBy第二个参数是收集期，映射的是收集到的地方，如list或set
        Map<Integer, Set<Person>> m2 = l.stream().collect(groupingBy(Person::getAge, toSet()));
        System.out.println(m2);
        //mapping函数返回结果，mapping连个参数，分别是映射的属性和收集到的地方，如list或set
        //mapping叫做下游收集器
        Map<Integer, Set<String>> m3 = l.stream().collect(groupingBy(Person::getAge, mapping(Person::getName, toSet())));
        System.out.println(m3);
        //counting返回收集元素的总个数
        Map<Integer, Long> m4 = l.stream().collect(groupingBy(Person::getAge, counting()));
        System.out.println(m4);

        Map<Integer, Double> m5 = l2.stream().collect(groupingBy(Person::getAge, summingDouble(Person::getSalary)));
        System.out.println(m5);

        Map<Integer, Optional<Person>> m6 = l2.stream().collect(groupingBy(Person::getAge, maxBy(Comparator.comparing(Person::getSalary))));
        System.out.println(m6);

        Map<Integer, Optional<String>> m7 = l2.stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(Person::getName, maxBy(Comparator
                                        .comparing(String::length)))));
        System.out.println(m7);

        //各种统计结果数据
        Map<Integer, DoubleSummaryStatistics> m8 = l2.stream().collect(groupingBy(Person::getAge, summarizingDouble(Person::getSalary)));
        System.out.println(m8);

        Map<Integer, Optional<Person>> m9 = l2.stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                reducing(BinaryOperator.maxBy(Comparator.comparing(Person::getSalary)))));
        System.out.println(m9);

        Map<Integer, String> m10 = l2.stream()
                .collect(
                        groupingBy(
                                Person::getAge,
                                mapping(Person::getName, joining(", "))));
        System.out.println(m10);
    }

    public static void main(String[] args) {
        m1();
    }

}
