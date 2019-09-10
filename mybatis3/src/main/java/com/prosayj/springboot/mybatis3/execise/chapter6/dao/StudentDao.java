package com.prosayj.springboot.mybatis3.execise.chapter6.dao;

import com.prosayj.springboot.mybatis3.execise.chapter6.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:53:53
 */
public interface StudentDao {

    Student findOne(@Param("id") Integer id);

    int update(@Param("id") Integer id, @Param("name") String name);
}
