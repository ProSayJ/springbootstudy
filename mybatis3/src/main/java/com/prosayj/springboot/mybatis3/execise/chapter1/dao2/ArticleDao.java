package com.prosayj.springboot.mybatis3.execise.chapter1.dao2;

import com.prosayj.springboot.mybatis3.execise.chapter1.model2.Article;
import org.apache.ibatis.annotations.Param;

/**
 * @description
 * @author yangjian
 * @Date 下午 12:23 2019/9/3
 * @since 1.0.0
 */
public interface ArticleDao {

    Article findOne(@Param("id") int id);
}
