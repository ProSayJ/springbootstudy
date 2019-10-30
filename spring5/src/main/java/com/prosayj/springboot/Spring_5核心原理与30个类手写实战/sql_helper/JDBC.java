package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/1 下午 06:52
 * @since 1.0.0
 */

import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc.IRowMapper;
import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc.JdbcUtil;
import com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

class JDBC {
    private static Properties p = null;

    static {
        // 1. 加载注册驱动
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = loader.getResourceAsStream("db.properties");
            p = new Properties();
            p.load(inputStream);
            Class.forName(p.getProperty("driverClassName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        try {
            // 2. 获取数据库连接
            return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
                    p.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //查询统一模板
    public static List<Student> query(String sql, Object... params) {
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


    // 删除学生信息
    public void deleteSelf(Long id) {
        String sql = "DELETE  FROM t_student WHERE id=?";
        Connection conn = null;
        Statement st = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
            // 3. 创建语句对象
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
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

    public void saveSelf(Student stu) {
        String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
        Connection conn = null;
        Statement st = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
            // 3. 创建语句对象
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, stu.getName());
            ps.setObject(2, stu.getAge());
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
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


    // 修改学生信息
    public void updateSelf(Student stu) {
        String sql = "UPDATE t_student SET name=?,age=? WHERE id=?";
        Connection conn = null;
        Statement st = null;
        try {
            // 1. 加载注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2. 获取数据库连接
            conn = DriverManager.getConnection("jdbc:mysql:///jdbcdemo", "root", "root");
            // 3. 创建语句对象
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setObject(1, stu.getName());
            ps.setObject(2, stu.getAge());
            ps.setObject(3, stu.getId());
            // 4. 执行SQL语句
            ps.executeUpdate();
            // 5. 释放资源
        } catch (Exception e) {
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


  /*  // 增加学生信息
    public void save(Student stu) {
        String sql = "INSERT INTO t_student(name,age) VALUES(?,?)";
        Object[] params = new Object[]{stu.getName(), stu.getAge()};
        JdbcTemplate.update(sql, params);
    }

    // 删除学生信息
    public void delete(Long id) {
        String sql = "DELETE FROM t_student WHERE id = ?";
        JdbcTemplate.update(sql, id);
    }

    // 修改学生信息
    public void update(Student stu) {
        String sql = "UPDATE t_student SET name = ?,age = ? WHERE id = ?";
        Object[] params = new Object[]{stu.getName(), stu.getAge(), stu.getId()};
        JdbcTemplate.update(sql, params);
    }

    public Student get(Long id) {
        String sql = "SELECT * FROM t_student WHERE id=?";
        List<Student> list = JDBCTemplate.query(sql, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public List<Student> list() {
        String sql = "SELECT * FROM t_student ";
        return JDBCTemplate.query(sql);
    }*/


    /*public static <T> T query(String sql, IRowMapper<T> rsh, Object... params) {
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
        return null;
    }*/

}



