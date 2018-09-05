package com.prosayj.springboot.javase.homework.day02;

import java.util.*;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/16 0:13
 * @since 1.0.0
 */
public class _Test01 {
    public static void main(String[] args) {
        //九九乘法表
        System.out.println("请输入数字：");
        int i;
        Scanner reader=new Scanner(System.in);
        i=reader.nextInt();
         Add(i);
    //自定义一个学生对象(姓名(英文)+年纪+性别),按年龄排序
        List<Student> list = new ArrayList<Student>();
        list.add(new Student("lucy",21,"女"));
        list.add(new Student("amy",28,"男"));
        list.add(new Student("daming",35,"女"));
        list.add(new Student("ob",23,"女"));
        list.add(new Student("linda",25,"男"));
        list.add(new Student("crystal",25,"女"));
        list.add(new Student("frank",27,"男"));
        list.add(new Student("tom",28,"男"));
        list.add(new Student("jack",28,"女"));
        list.add(new Student("demo",23,"女"));

        // 排序
        // 自然排序
        // Collections.sort(list);
        // 比较器排序
        // 如果同时有自然排序和比较器排序，以比较器排序为主
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if(s1.getAge()-(s2.getAge())!=0){
                    return s1.getAge()-(s2.getAge());
                }else{
                    return  s1.getName().compareTo(s2.getName());
                }
            }
        });
        // 遍历集合
        for (Student s : list) {
            System.out.println(s.getName() + "---" + s.getAge());
        }

    }

   public static void Add(int n){
        int s=1;
        for(int i=1;i<=n;i++){
            for (int j=1;j<=i;j++){
                s=i*j;
                if(s<10){                                  //用于乘法表的对齐
                    System.out.print(j+"*"+i+"="+s+"  ");
                }
                else System.out.print(j+"*"+i+"="+s+" ");
            }
            System.out.println("");
        }
    }


}
