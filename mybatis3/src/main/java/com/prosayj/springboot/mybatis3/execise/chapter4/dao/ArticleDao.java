package com.prosayj.springboot.mybatis3.execise.chapter4.dao;

import com.prosayj.springboot.mybatis3.execise.chapter4.model.Article;
import com.prosayj.springboot.mybatis3.execise.chapter4.model.Author;
import org.apache.ibatis.annotations.Param;


/**
 * ArticleDao
 *
 * @author Tian ZhongBo
 * @date 2018-07-01 13:20:51
 */
public interface ArticleDao {

    Article findOne(@Param("id") int id);

    Author findAuthor(@Param("article_author_id") int authorId);
}
