package com.prosayj.springboot._01_写给大忙人看的javase8._01_lambda;





/**
 * @description
 * lambda表达式包括：一段代码、参数、自由变量
 * 自由变量：这里的自由指的是那些不是参数并且没有在代码中定义的变量。含有自由变量的代码块被称为闭包
 *
 * @author yangjian
 * @Date 14:38 2019/4/10
 * @since 1.0.0
 */
public class Closure {

	//需要遵守一个重要的约束，就是被引用的变量的值不可以被更改，以前要求变量必须是final的，现在取消了这个强制限制
	public static void repeatMessage(String text, int count){
		Runnable r = () -> {
			for(int i=0; i<count; i++){
				System.out.println(text);
				Thread.yield();
			}
		};

		new Thread(r).start();
	}

	public static void main(String[] args) {
		repeatMessage("hello", 1000);
	}

}
