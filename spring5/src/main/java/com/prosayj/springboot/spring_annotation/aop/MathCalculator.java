package com.prosayj.springboot.spring_annotation.aop;
/**
 * @description
 * @author yangjian
 * @Date 0:00 2018/9/25
 * @since 1.0.0
 */
public class MathCalculator {
	
	public int div(int i,int j){
		System.out.println("MathCalculator...div...");
		return i/j;	
	}

}
