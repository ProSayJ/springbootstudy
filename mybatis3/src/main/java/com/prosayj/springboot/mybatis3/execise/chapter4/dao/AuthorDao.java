package com.prosayj.springboot.mybatis3.execise.chapter4.dao;


import com.prosayj.springboot.mybatis3.execise.chapter4.model.Author;

import java.util.List;

/**
 * StudentDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-14 21:53:53
 */
public interface AuthorDao {

    int insertMany(List<Author> authors);
}
