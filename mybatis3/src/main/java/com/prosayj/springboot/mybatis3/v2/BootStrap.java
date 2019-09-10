package com.prosayj.springboot.mybatis3.v2;


import com.prosayj.springboot.mybatis3.v2.beans.Test;
import com.prosayj.springboot.mybatis3.v2.config.SelfConfiguration;
import com.prosayj.springboot.mybatis3.v2.executor.SelfExecutorFactory;
import com.prosayj.springboot.mybatis3.v2.mappers.TestMapper;
import com.prosayj.springboot.mybatis3.v2.session.SelfSqlSession;

import java.io.IOException;

/**
 * @author lijun
 * @since 2018-04-03 8:59
 */
public class BootStrap {
    public static void main(String[] args) throws IOException {
        SelfConfiguration configuration = new SelfConfiguration();
        configuration.scanPath("com.prosayj.springboot.mybatis3.v2.mappers");
        configuration.build();
        // SelfSqlSession session = new SelfSqlSession(configuration, new SimpleSelfExecutor(configuration));
        SelfSqlSession session = new SelfSqlSession(configuration,
                SelfExecutorFactory.get(SelfExecutorFactory.ExecutorType.CACHING.name(), configuration));
        TestMapper mapper = session.getMapper(TestMapper.class);
        Test test = mapper.selectByPrimaryKey(1);
        System.out.println("test" + test);
        Test test1 = mapper.selectByPrimaryKey(1);
        System.out.println("test1" + test1);
    }
}
