package com.prosayj.springboot.java数据结构.玩转数据结构._00_Array._07_dynamic_array;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/2/28 18:50
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        MyArray<Student> studentMyArray = new MyArray<>(1);
        studentMyArray.addLast(new Student("张一", 20));
        System.out.println(studentMyArray);
        studentMyArray.addLast(new Student("李二", 24));
        System.out.println(studentMyArray);
        studentMyArray.addLast(new Student("王三", 25));
        System.out.println(studentMyArray);
        studentMyArray.addLast(new Student("赵四", 27));
        System.out.println(studentMyArray);
        studentMyArray.addLast(new Student("王五", 28));
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
