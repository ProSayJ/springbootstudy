package com.prosayj.springboot.log.annoation;

import java.lang.annotation.*;


/**
 * @author yangjian
 * @description
 * @Date 10:20 2019/6/12
 * @since 1.0.0
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 日志操作描述
     *
     * @return
     */
    String value() default "";
}