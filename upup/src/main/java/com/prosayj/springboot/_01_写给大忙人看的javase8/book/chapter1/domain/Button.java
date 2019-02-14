package com.prosayj.springboot._01_写给大忙人看的javase8.book.chapter1.domain;

public class Button {

	private int id;
	private String name;

	public Button(String name) {
		super();
		this.name = name;
	}

	public Button(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Button [name=" + name + "]";
	}


}
