package com.prosayj.springboot.blog.protal.common.annotation;

import java.lang.annotation.*;

/**
 * ViewLog
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogLike {

    String type();
}
