package com.prosayj.springboot.blog.core.common.util;

import java.util.HashMap;


/**
 * @author yangjian
 * @description Map工具类
 * @Date 12:12 2019/5/13
 * @since 1.0.0
 */
public class MapUtils extends HashMap<String, Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
