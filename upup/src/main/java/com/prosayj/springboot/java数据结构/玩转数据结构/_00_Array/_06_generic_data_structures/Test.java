package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._06_generic_data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 18:50
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        MyArray<Student> studentMyArray = new MyArray<>();
        studentMyArray.addList(new Student("张三", 20));
        studentMyArray.addList(new Student("李四", 24));
        studentMyArray.addList(new Student("王五", 25));
        System.out.println(studentMyArray);
        studentMyArray.remove(1);
        System.out.println(studentMyArray);

    }
}

class Student {
    private String name;
    private int score;

    public Student(String studentName, int studentScore) {
        name = studentName;
        score = studentScore;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

}
