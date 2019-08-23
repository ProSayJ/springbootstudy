package com.prosayj.springboot.javase.base.day29_jdbc.code.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author yangjian
 * @description select字段不能参与预编译
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/8/12 下午 02:42
 * @since 1.0.0
 */
public class JDBCDemo4 {
    public static void main(String[] args)throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/blog?serverTimezone=UTC&characterEncoding=UTF-8&serverTimezone=Hongkong";
        Connection con = DriverManager.getConnection(url, "root", "root");
        String sql = "SELECT article_id,article_title,article_summary,original_author FROM article WHERE id=? AND article_tags=?";
        //String sql = "SELECT article_id,article_title,article_summary,? FROM article WHERE id=? AND article_tags=?";
        PreparedStatement pst =  con.prepareStatement(sql);
        System.out.println(pst);
        pst.setObject(1, "1");
        pst.setObject(2, "1");
        //pst.setObject(1, "original_author");
        //pst.setObject(2, "1");
        //pst.setObject(3, "1");
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            System.out.println(rs.getString("article_title"));
            System.out.println(rs.getString("article_summary"));
            System.out.println(rs.getString("original_author"));
        }
        rs.close();
        pst.close();
        con.close();
    }
}
