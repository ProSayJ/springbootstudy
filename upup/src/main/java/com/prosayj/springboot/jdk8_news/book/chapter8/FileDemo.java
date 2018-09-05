package com.prosayj.springboot.jdk8_news.book.chapter8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

public class FileDemo {

	public static void m1(Path path) throws IOException{
		//Files.lines产生包含字符串的流，每个字符串就是文件中的一行，lines直接用utf-8打开，也可以指定
		Stream<String> s = Files.lines(path);
		Optional<String> o = s.filter(str -> str.contains("加班次数")).findFirst();
		System.out.println(o.get());
	}

	//读取文件以外的其他来源
	public static void m2(URL url) throws IOException{
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
			Stream<String> lines = reader.lines();
			lines.forEach(System.out::println);
		}
	}

	public static void m3(Path pathToDir) throws IOException{
		//读取目录，但不是递归包含的
		try(Stream<Path> entris = Files.list(pathToDir)){
			entris.forEach(System.out::println);
		}
		//可以读取子目录，递归的
		try(Stream<Path> entris = Files.walk(pathToDir)){
			entris.forEach(System.out::println);
		}
	}

	public static void main(String[] args) throws IOException {
		m1(Paths.get("记事.txt"));
		m2(new URL("http://www.cdeledu.com"));
		m3(Paths.get("E:/文档"));
	}

}
