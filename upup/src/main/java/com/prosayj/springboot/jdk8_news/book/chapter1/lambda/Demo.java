package com.prosayj.springboot.jdk8_news.book.chapter1.lambda;


import com.prosayj.springboot.jdk8_news.book.chapter1.domain.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Demo {

	//构造方法引用
	public void m1(){
		List<String> label = new ArrayList<String>(){{add("abc");add("dcf");add("sad");}};
		//调用Button(String s)构造器
		label.stream().map(Button::new);

		List<Integer> label2 = new ArrayList<Integer>(){{add(1);add(2);add(3);}};
		//int[]::new等价于x -> new int[x]
		label2.stream().map(int[]::new);

		//不允许new T[]，但可以将Button[]::new传递给toArray方法
		Button[] bs = label2.stream().toArray(Button[]::new);
	}

	//方法引用
	public void m2(){
		List<String> label = new ArrayList<String>(){{add("abc");add("dcf");add("sad");}};
		//System.out::println等价于x -> System.out.println(x)
		label.stream().forEach(System.out::println);

		//类::实例方法
		//String::compareToIgnoreCase等价于(x, y) -> x.compareToIgnoreCase(y)
		String[] s = new String[]{"a", "b", "c"};
		Arrays.sort(s, String::compareToIgnoreCase);

		//类::静态方法
		//Math::pow等价于(x, y) -> Math.pow(x, y)

		//this::equals等价于x -> this.equals(x)
		//super::实例方法等价于使用this作为执行方法的对象，并调用父类中指定的方法

	}

}
