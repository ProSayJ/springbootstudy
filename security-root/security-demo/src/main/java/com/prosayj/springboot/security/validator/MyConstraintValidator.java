package com.prosayj.springboot.security.validator;

import com.prosayj.springboot.security.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author yangjian
 * @description 常量自定义注解, MyConstraintValidator不用加@Component可以注入@Autowired
 * @Date 下午 05:10 2019/11/10
 * @since 1.0.0
 */

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint constraintAnnotation) {
        System.out.println("自定义验证器初始化。。。");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        //自定义验证器可以注入任何service
        helloService.greeting("tom");
        System.out.println("自定义验证器开始工作，待验证的字段是：" + value + "。默认返回自定义验证器返回是：false");
        return false;
    }

}
