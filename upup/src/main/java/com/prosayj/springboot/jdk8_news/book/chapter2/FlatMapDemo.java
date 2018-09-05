package com.prosayj.springboot.jdk8_news.book.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class FlatMapDemo {

	public static Stream<Character> characterStream(String s){
		List<Character> result = new ArrayList<Character>();
		for (char c : s.toCharArray()) {
			result.add(c);
		}
		return result.stream();
	}

	public static void m1(){
		List<String> l = new ArrayList<String>(){{add("love");add("make");add("ok");}};
		Stream<Stream<Character>> result = l.stream().map(w -> characterStream(w));
		Stream<Character> result2 = l.stream().flatMap(w -> characterStream(w));
		Stream<Character> result3 = Stream.concat(characterStream("hello"), characterStream("world"));
	}

}
