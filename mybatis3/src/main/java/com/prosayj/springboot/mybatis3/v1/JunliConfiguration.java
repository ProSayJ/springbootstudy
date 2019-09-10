package com.prosayj.springboot.mybatis3.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class JunliConfiguration {


    public <T> T getMapper(Class<T> tClass ,JunliSqlSession junliSqlSession) {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{tClass},
                new JunliMapperProxy(junliSqlSession));
    }

    /**
     * XML
     */
    static class TestMapperXml {
        public static final String namespace = "com.prosayj.springboot.mybatis3.v1.TestMapper";

        public static final Map<String,String> methodSqlMapping = new HashMap<>();

        static {
            methodSqlMapping.put("selectByPrimaryKey","select * from test where id =%d");
        }
    }
}
