package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter2;

import java.util.stream.Stream;


public class Generate {

	//100个随机数的流
	public static void m1(){
		Stream.generate(Math::random).limit(100);
	}

}
