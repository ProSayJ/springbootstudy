package com.prosayj.springboot._04_Java高并发编程详解._01_._06_jdbcexample;

import java.sql.ResultSet;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/4/19 12:07
 * @since 1.0.0
 */
public interface RowHandler<T> {
    T handle(ResultSet rs);
}
