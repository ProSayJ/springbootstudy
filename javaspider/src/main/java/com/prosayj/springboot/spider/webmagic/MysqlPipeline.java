package com.prosayj.springboot.spider.webmagic;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MysqlPipeline implements Pipeline {
    public static final Lock lock = new ReentrantLock();

    @Override
    public void process(ResultItems resultitems, Task task) {
        Map<String, Object> mapResults = resultitems.getAll();
        Iterator<Map.Entry<String, Object>> iter = mapResults.entrySet().iterator();
        Map.Entry<String, Object> entry;
        // 输出到控制台
        while (iter.hasNext()) {
            entry = iter.next();
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }
        // 持久化
        /*News news = new News();
        if (!mapResults.get("Title").equals("")) {
            news.setTitle((String) mapResults.get("Title"));
            news.setContent((String) mapResults.get("Content"));
        }
        SqlSessionFactory sessionFactory = getSqlSessionFactoryByXml();
        SqlSession session = sessionFactory.openSession();
        session.insert("add", news);
        session.commit();
        session.close();*/
    }

    /**
     * 获取sqlSession
     *
     * @return
     */
    public static SqlSessionFactory getSqlSessionFactoryByXml() {
        SqlSessionFactory sqlSessionFactory = null;
        synchronized (lock) {
            if (null != sqlSessionFactory) {
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream;
            InputStream is = null;
            try {
                // 加载数据库配置文件
                is = Resources.getResourceAsStream("db.properties");
                Properties properties = new Properties();
                properties.load(is);

                // 获取加密信息
                String userName = properties.getProperty("db.username");
                String pwd = properties.getProperty("db.pwd");

                // 解密用户名和密码，并重置属性
                properties.setProperty("db.username", userName);
                properties.setProperty("db.pwd", pwd);
                // 读取mybatis配置文件
                inputStream = Resources.getResourceAsStream(resource);
                // 通过SqlSessionFactoryBuilder类的builder方法进行构建，并使用程序传递的方式覆盖原有属性
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
            return sqlSessionFactory;
        }
    }
}
