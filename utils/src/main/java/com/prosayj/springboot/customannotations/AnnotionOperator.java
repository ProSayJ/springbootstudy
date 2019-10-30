package com.prosayj.springboot.customannotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/7/4 上午 09:57
 * @since 1.0.0
 */
public class AnnotionOperator {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AttachEmlement element = new AttachEmlement(); // 初始化一个实例，用于方法调用

        Method[] methods = AttachEmlement.class.getDeclaredMethods(); // 获得所有方法
        for (Method method : methods) {
            AttachAnnotation annotationTmp = null;
            if ((annotationTmp = method.getAnnotation(AttachAnnotation.class)) != null)
                method.invoke(element, annotationTmp.paramValue());
            else
                method.invoke(element, "新的设置的省");
        }
    }
}
