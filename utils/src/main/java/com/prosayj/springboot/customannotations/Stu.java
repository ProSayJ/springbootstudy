package com.prosayj.springboot.customannotations;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/22 23:48
 * @since 1.0.0
 */
public class Stu {


    private String name;
    private String age;

    public String getName() {
        return name;
    }

    @InitUserName(value = "张三")
    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
