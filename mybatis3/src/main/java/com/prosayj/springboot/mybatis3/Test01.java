package com.prosayj.springboot.mybatis3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/16 17:56
 * @since 1.0.0
 */
public class Test01 {
    public static void main(String[] args) {
//        SqlSessionFactory sqlSessionFactoryFromJava = getSqlSessionFactoryFromJava();
        SqlSessionFactory sqlSessionFactoryFromXml = getSqlSessionFactoryFromXml();
        SqlSession session = sqlSessionFactoryFromXml.openSession();
        try {
            Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
        } finally {
            session.close();
        }

    }

    private static SqlSessionFactory getSqlSessionFactoryFromXml() {
//        String resource = "org/mybatis/example/mybatis-config.xml";
        String resource = "com/prosayj/springboot/mybatis3/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

/*
    private static SqlSessionFactory getSqlSessionFactoryFromJava() {
        DataSource dataSource = BlogDataSourceFactory.getBlogDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(BlogMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        return sqlSessionFactory;
        return null;
    }*/
}
