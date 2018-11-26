package com.prosayj.springboot.customannotations;

import java.lang.annotation.*;

/**
 * @author yangjian
 * @description 初始化用户姓名的注解
 * @email ProSayj@gmail.com
 * @creatTime 2018/11/22 23:39
 * @since 1.0.0
 */
@Documented
@Inherited
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface InitUserName {
    public String value() default "";
}
