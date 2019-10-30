package com.prosayj.springboot.mybatis3.execise.chapter1;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.prosayj.springboot.mybatis3.execise.chapter1.dao.ArticleDao;
import com.prosayj.springboot.mybatis3.execise.chapter1.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

/**
 * @author yangjian
 * @description
 * @Date 下午 12:22 2019/9/3
 * @since 1.0.0
 */
public class _01_MyBatisTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        String resource = "chapter1/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = session.getMapper(ArticleDao.class);
            List<Article> articles = articleDao.findByAuthorAndCreateTime("coolblog.xyz", "2018-06-10");
            System.out.println(articles);

        } finally {
            session.commit();
            session.close();
        }
    }

}
