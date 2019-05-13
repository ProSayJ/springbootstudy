package com.prosayj.springboot.blog.protal.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 *
 * @description
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogView {

    String type();
}
