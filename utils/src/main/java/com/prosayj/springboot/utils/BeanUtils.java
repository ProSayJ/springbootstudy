package com.prosayj.springboot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/7 10:16
 * @since 1.0.0
 */
public class BeanUtils {
    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
