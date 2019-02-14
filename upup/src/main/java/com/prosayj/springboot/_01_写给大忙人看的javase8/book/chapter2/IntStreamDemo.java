package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamDemo {

	public static void m1(){
		IntStream i = IntStream.range(1, 100);
		IntStream i2 = IntStream.rangeClosed(1, 100);
		int[] i3 = new int[]{1, 2, 3, 4, 5};
		IntStream i4 = Arrays.stream(i3, 2, 4);
		IntStream i5 = IntStream.of(1, 2, 3, 3);

		List<String> l = new ArrayList<String>();
		//Stream<Integer>转换IntStream
		IntStream i6 = l.stream().mapToInt(String::length);
		//IntStream转换Stream<Integer>
		Stream<Integer> i7 = l.stream().mapToInt(String::length).boxed();
	}

}
