package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.spirng1.demo.service.impl;


import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.spirng1.demo.service.IDemoService;
import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.spirng1.mvcframework.annotation.GPService;

/**
 * 核心业务逻辑
 */
@GPService
public class DemoService implements IDemoService {

	public String get(String name) {
		return "My name is " + name;
	}

}
