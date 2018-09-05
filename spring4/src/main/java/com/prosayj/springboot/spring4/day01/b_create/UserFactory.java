package com.prosayj.springboot.spring4.day01.b_create;


import spring4.day01.bean.User;

public class UserFactory {

	public static User createUser(){
		
		System.out.println("静态工厂创建User");
		
		return new User();
		
	}
	
	public  User createUser2(){
		
		System.out.println("实例工厂创建User");
		
		return new User();
		
	}
	
}
