package com.prosayj.springboot.javase.base.day11_interface.code.demo09;

public class Keyboard implements USB{
	public void open(){
		System.out.println("开启键盘");
	}
	public void close(){
		System.out.println("关闭键盘");
	}
}
