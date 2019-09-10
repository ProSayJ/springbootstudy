package com.prosayj.springboot.mybatis3.execise;

import java.util.List;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author yangjian
 * @description
 * @Date 下午 03:24 2019/9/3
 * @since 1.0.0
 */
public class LoggableObjectFactory extends DefaultObjectFactory {

    private Logger logger = LoggerFactory.getLogger(LoggableObjectFactory.class);

    @Override
    public <T> T create(Class<T> type) {
//        System.out.println("using default constructor create " + type);
//        logger.info("using default constructor create {}", type);
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
//        System.out.println("using constructor create " + type + ", constructorArgs = " + constructorArgs);
//        logger.info("using constructor whith args {} create {}", constructorArgs, type);
        return super.create(type, constructorArgTypes, constructorArgs);
    }
}
