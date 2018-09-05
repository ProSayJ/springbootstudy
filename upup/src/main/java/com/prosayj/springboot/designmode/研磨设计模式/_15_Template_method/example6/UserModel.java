package com.prosayj.springboot.designmode.研磨设计模式._15_Template_method.example6;
/**
 * 描述用户的数据模型
 */
public class UserModel {
	private String uuid;
	private String name;
	private int age;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString(){
		return "uuid="+uuid+",name="+name+",age="+age;
	}
}
