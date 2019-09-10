package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/1 下午 07:29
 * @since 1.0.0
 */ //工具类
public class JdbcUtil {
    private JdbcUtil() {
    }

    static {
        //	1. 加载注册驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            // 2. 获取数据库连接
            return DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //释放资源
    public static void close(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null)
                rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null)
                    st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null)
                        conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 增加学生信息
    public void save(Student stu) {
        String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setObject(1, stu.getName());
            ps.setObject(2, stu.getAge());
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.close(null, ps, conn);
        }

    }

    // 删除学生信息
    public void delete(Long id) {
        String sql = "DELETE  FROM t_student WHERE id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = this.getConnection();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }

    }

    // 修改学生信息
    public void update(Student stu) {
        String sql = "UPDATE t_student SET name=?,age=? WHERE id=?";
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setObject(1, stu.getName());
            ps.setObject(2, stu.getAge());
            ps.setObject(3, stu.getId());
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(null, ps, conn);
        }

    }

    public Student get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id=?";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            // 4. 执行SQL语句
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student stu = new Student(id, name, age);
                return stu;
            }
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return null;
    }

    public List<Student> list() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM t_student ";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = JdbcUtil.getConnection();
            // 3. 创建语句对象
            ps = conn.prepareStatement(sql);
            // 4. 执行SQL语句
            rs = ps.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                Student stu = new Student(id, name, age);
                list.add(stu);
            }
            // 5. 释放资源
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs, ps, conn);
        }
        return list;
    }
}



