package com.prosayj.springboot.mybatis3.v2.executor;

import com.prosayj.springboot.mybatis3.v2.config.MapperData;

public interface SelfExecutor {

    <T> T query(MapperData mapperData, Object paramters);
}
