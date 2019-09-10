package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/1 下午 07:32
 * @since 1.0.0
 */
public class StudentRowMapper2 implements IRowMapper {
    @Override
    public List mapping(ResultSet rs) throws Exception {
        List<Student> list = new ArrayList<>();
        while (rs.next()) {
            long id = rs.getLong("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            Student stu = new Student(id, name, age);
            list.add(stu);
        }
        return list;
    }
}