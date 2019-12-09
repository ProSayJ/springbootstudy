package com.prosayj.springboot.javase.base.day26_thread.code.demo5_callable;
/*
 * Callable 接口的实现类,作为线程提交任务出现
 * 使用方法返回值
 */

import java.util.concurrent.Callable;

public class ThreadPoolCallable implements Callable<String>{
	@Override
	public String call(){
		return "abc";
	}
}
