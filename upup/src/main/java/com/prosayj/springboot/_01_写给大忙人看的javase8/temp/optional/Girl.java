package com.prosayj.springboot._01_写给大忙人看的javase8.temp.optional;


public class Girl {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Girl(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Girl [name=" + name + "]";
	}
	
	
}
