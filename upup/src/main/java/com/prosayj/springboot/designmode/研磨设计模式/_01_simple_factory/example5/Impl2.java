package com.prosayj.springboot.designmode.研磨设计模式._01_simple_factory.example5;
/**
 * 对某个接口的一种实现
 */
public class Impl2 implements Api{

	@Override
	public void test1(String s) {
		System.out.println("Now In Impl222222. The input s=="+s);
	}
}