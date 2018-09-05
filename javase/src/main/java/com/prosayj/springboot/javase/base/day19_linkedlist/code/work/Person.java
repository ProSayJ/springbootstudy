package com.prosayj.springboot.javase.base.day19_linkedlist.code.work;

public class Person {
	private  String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    public static void main(String[] args) {
		String str = "goOd gooD stUdy dAy dAy up";

		//全部转成小写
		str = str.toLowerCase();

		//截取空格变成数组
		String[] strArr = str.split(" ");

		//拼接字符串
		String sysoStr = "";
		for(String s : strArr){
			s = s.substring(0, 1).toUpperCase()+s.substring(1, s.length());
			sysoStr += s+" ";
		}

		//接去掉最后一个没用的空格
		sysoStr = sysoStr.substring(0, sysoStr.length()-1);

		System.out.println(sysoStr);
	}

}

