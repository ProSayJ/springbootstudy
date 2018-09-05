package com.prosayj.springboot.jdk8_news._01_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/17 17:26
 * @since 1.0.0
 */
public class _Test01 {
    public static void main(String[] args) {
        /**
         * 创建线程的第第一种方式
         * 这段代码的关键在于， run方法中包含了你希望在另一个线程中执行的代码。
         */
        Work work = new Work();
        new Thread(work).start();

        /**
         * 自定义比较器排序
         */
        List<Student> students = new ArrayList<>();
        students.add(new Student(20, "张三"));
        students.add(new Student(19, "李四"));
        students.add(new Student(26, "王五"));
        System.out.println(students);
        Collections.sort(students, new StudengComparator());
        System.out.println(students);
    }


    /**
     * 工人工作线程
     */
    static class Work implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "--->" + "在工作");
        }
    }

    /**
     * 学生类
     */
    static class Student {
        private int age;
        private String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    /**
     * 学生类比较器
     */
    static class StudengComparator implements Comparator<Student> {
        @Override
        public int compare(Student stu1, Student stu2) {
            return Integer.valueOf(stu2.getAge()).compareTo(Integer.valueOf(stu1.getAge()));
        }
    }
}

