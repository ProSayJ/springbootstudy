package com.prosayj.springboot.utils.test;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/18 17:33
 * @since 1.0.0
 */
public class Student {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Student(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

