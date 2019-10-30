package com.prosayj.springboot.mybatis3.execise.chapter1.dao;

import com.prosayj.springboot.mybatis3.execise.chapter1.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangjian
 * @description
 * @Date 上午 09:33 2019/9/3
 * @since 1.0.0
 */
public interface ArticleDao {
    List<Article> findByAuthorAndCreateTime(@Param("author") String author, @Param("createTime") String createTime);
}
