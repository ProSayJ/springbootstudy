package com.prosayj.springboot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/7 10:16
 * @since 1.0.0
 */
public class BeanUtils {
    public static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * @description 对象转json字符串
     * @author yangjian
     * @Date 10:57 2018/9/19
     * @since 1.0.0
     */
    public static String objectConvertToString(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }

    /**
     * @description 拷贝属性
     * @author yangjian
     * @Date 10:53 2018/9/19
     * @since 1.0.0
     */
    public static void copyProperties(Object source, Object target) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

  /**
   * @description 将实体转换成Map
   * @author yangjian
   * @Date 10:55 2018/9/19
   * @since 1.0.0
   */
    public static Map<String, String> objectConvertToMap(Object object) {
        Map<String, String> result = new HashMap<>();
        for (Class<?> clazz = object.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object eleContent;
                try {
                    eleContent = field.get(object);
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
                if (eleContent == null) {
                    result.put(field.getName(), null);
                    continue;
                }
                result.put(field.getName(), eleContent.toString());
            }
        }
        return result;
    }

    /**
     * @param jsonString
     * @param object
     * @throws
     * @description jsonSting to object
     * @author yangjian
     * @Date 11:26 2018/7/27
     * @since 1.0.0
     */
    public static <T> T toBean(String jsonString, Class<T> object) {
        try {
            return objectMapper.readValue(jsonString, object);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
