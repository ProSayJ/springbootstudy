package com.prosayj.springboot._01_写给大忙人看的javase8.book.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

//domain
public class Person {

    private String name;
    private int age;
    private String gender;
    private double salary;

    public Person() {
        super();
    }

    public Person(String gender, String name) {
        super();
        this.gender = gender;
        this.name = name;
    }

    public Person(String gender, String name, int age) {
        super();
        this.gender = gender;
        this.name = name;
        this.age = age;
    }

    public Person(String gender, String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

}
