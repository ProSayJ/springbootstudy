package com.prosayj.springboot.baseutils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yangjian
 * @description 工具类
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/28 22:23
 * @since 1.0.0
 */
public class JsonUtil {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
