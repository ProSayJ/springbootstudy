package com.prosayj.springboot.jdk8_news.book.chapter8;

public class MathDemo {

	public static void main(String[] args) {
		//以前直接相乘会得出错误结果：1410065408
		System.out.println(100000 * 100000);
		//新的Exact会报异常：integer overflow
		//System.out.println(Math.multiplyExact(100000, 100000));
		//返回-11，不合理
		System.out.println(-47%12);
		//新的Mod方法会永远返回整数（除数不为负数的前提下）
		System.out.println(Math.floorMod(-47, +12));
		//产生一个比指定数字小，但最接近于指定数字的浮点数
		System.out.println(Math.nextDown(3.2));
	}

}
