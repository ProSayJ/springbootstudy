package com.prosayj.springboot.javase.base.day13_class.code.demo11;


import com.prosayj.springboot.javase.base.day13_class.code.demo10.A;

public class B extends A {
	public void show(){
		//受保护权限,只能是子类的里面!!!!! 调用父类的受保护成员
		// super
		abc();
	}
}
