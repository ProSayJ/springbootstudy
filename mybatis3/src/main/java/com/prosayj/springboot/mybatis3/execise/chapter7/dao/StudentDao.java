package com.prosayj.springboot.mybatis3.execise.chapter7.dao;

import com.prosayj.springboot.mybatis3.execise.chapter7.model.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-08-25 18:25:33
 */
public interface StudentDao {

    List<Student> findByPaging(@Param("id") Integer id, RowBounds rb);
}
