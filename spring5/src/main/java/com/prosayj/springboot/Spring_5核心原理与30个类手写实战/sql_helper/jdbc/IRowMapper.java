package com.prosayj.springboot.Spring_5核心原理与30个类手写实战.sql_helper.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/1 下午 07:28
 * @since 1.0.0
 */
public interface IRowMapper<T> {
    //处理结果集
    //List rowMapper(ResultSet rs) throws Exception;


    List mapping(ResultSet rs) throws Exception;
}
