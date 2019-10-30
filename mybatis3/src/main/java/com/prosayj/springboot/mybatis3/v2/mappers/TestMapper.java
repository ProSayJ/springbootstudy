package com.prosayj.springboot.mybatis3.v2.mappers;


import com.prosayj.springboot.mybatis3.v2.beans.Test;

/**
 *
 */
public interface TestMapper {
    Test selectByPrimaryKey(Integer userId);
}
