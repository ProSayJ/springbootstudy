package com.prosayj.springboot.jdk8_news.book.chapter2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorted {

	public static void toUp() {
		List<String> l = new ArrayList<String>(){{add("love");add("make");add("ok");}};
		//按字符长度排序
		l.stream().sorted(Comparator.comparing(String::length).reversed());
	}

}
