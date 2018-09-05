package com.prosayj.springboot.jdk8_news.book.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

public class Generate {

	//100个随机数的流
	public static void m1(){
		Stream.generate(Math::random).limit(100);
	}

}
