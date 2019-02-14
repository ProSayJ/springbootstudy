package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter8;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;

public class EachRemaining {

    public static void demo1() {
        Set<String> set = new HashSet<String>();
        set.add("Java");
        set.add("C#");
        set.add("Perl");

        Spliterator<String> spliterator = set.spliterator();
        //对每个数据执行指定的代码
        spliterator.forEachRemaining(lang -> System.out.println(lang));
    }

    public static void demo2() {
    	Set<String> set = new HashSet<String>();
    	set.add("Java");
    	set.add("C#");
    	set.add("Perl");

    	Iterator<String> spliterator = set.iterator();
    	spliterator.forEachRemaining(lang -> System.out.println(lang));
    }

    public static void main(String[] args) {
    	demo1();
    	System.out.println("---------------");
    	demo2();
	}

}
