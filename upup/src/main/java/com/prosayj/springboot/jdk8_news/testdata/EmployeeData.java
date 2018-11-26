package com.prosayj.springboot.jdk8_news.testdata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/11 0:46
 * @since 1.0.0
 */
public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1001, "马化腾", 34, 6000.38));
        list.add(new Employee(1002, "马云马", 12, 9876.12));
        list.add(new Employee(1003, "刘强东", 33, 3000.82));
        list.add(new Employee(1004, "雷军", 26, 7657.37));
        list.add(new Employee(1005, "李彦宏", 65, 5555.32));
        list.add(new Employee(1006, "比尔盖茨", 42, 9500.43));
        list.add(new Employee(1007, "任正非", 26, 4333.32));
        list.add(new Employee(1008, "尔扎克伯格", 35, 2500.32));

        return list;
    }

}