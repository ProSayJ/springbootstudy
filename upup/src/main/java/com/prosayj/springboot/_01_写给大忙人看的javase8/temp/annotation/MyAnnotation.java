package com.prosayj.springboot._01_写给大忙人看的javase8.temp.annotation;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_USE})
@Retention(RetentionPolicy.SOURCE)
@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
	String value();
}
