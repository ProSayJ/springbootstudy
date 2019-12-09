package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter8;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NullDemo {

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(){{add("dad");add("qeqw");add(null);}};
		//检查是否有空值
		System.out.println(l.stream().anyMatch(Objects::isNull));
		//获取非空对象
		l.stream().filter(Objects::nonNull).forEach(System.out::println);

		System.out.println((char[]) Objects.requireNonNull(null, "Map is null"));
	}

}
