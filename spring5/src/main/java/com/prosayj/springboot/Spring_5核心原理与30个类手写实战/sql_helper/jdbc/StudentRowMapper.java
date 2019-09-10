package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/1 下午 07:28
 * @since 1.0.0
 */
class StudentRowMapper implements IRowMapper<List<Student>> {
    @Override
    public List<Student> mapping(ResultSet rs) throws Exception {
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

    public static List<Student> query(String sql, IRowMapper rsh, Object... params) {
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            ps = conn.prepareStatement(sql);
            //设置值
            for (int i = 0; i < params.length; i++) {
                ps.setObject(i + 1, params[i]);
            }
            rs = ps.executeQuery();
            return rsh.mapping(rs);
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return list;
    }


    public Student get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id = ?";
//        List<Student> list = JdbcTemplate.query(sql, new StudentRowMapper(), id);
        List<Student> list = new ArrayList<>();
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Student> list() {
        String sql = "SELECT * FROM t_student ";
//        return JdbcTemplate.query(sql, new StudentRowMapper());
        return new ArrayList<>();
    }

    public Long getCount() {
      /*  String sql = "SELECT COUNT(*) total FROM t_student";
        Long totalCount = (Long) JdbcTemplate.query(sql,
                new IRowMapper<Long>() {
                    public Long mapping(ResultSet rs) throws Exception {
                        Long totalCount = null;
                        if (rs.next()) {
                            totalCount = rs.getLong("total");
                        }
                        return totalCount;
                    }
                });
        return totalCount;*/
        return 0L;
    }


}