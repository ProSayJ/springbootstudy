package com.prosayj.springboot._01_写给大忙人看的javase8.book.service;


import com.prosayj.springboot._01_写给大忙人看的javase8.book.domain.Person;

import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class PersonService {

	//加薪
	public void addSalary(Person p){
		if(p.getSalary() > 0){
			p.setSalary(p.getSalary() * 1.2);
		}
	}

	//加薪
	public Person addSalary2(Person p){
		if(p.getSalary() > 0){
			p.setSalary(p.getSalary() * 1.2);
		}
		return p;
	}

	//减薪
	public Person reduceSalary2(Person p){
		if(p.getSalary() > 0){
			p.setSalary(p.getSalary() * 0.95);
		}
		return p;
	}

	//组合
	public void compose(Person p, UnaryOperator<Person> fu, UnaryOperator<Person> fu2){
		fu.apply(fu2.apply(p));
	}

	//创建一个用户
	public Supplier<Person> getPerson(String gender, String name, int age, double salary){
		return () -> new Person(gender, name, age, salary);
	}

}
