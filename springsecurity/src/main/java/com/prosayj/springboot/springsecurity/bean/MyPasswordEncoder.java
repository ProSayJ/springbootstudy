package com.prosayj.springboot.springsecurity.bean;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author yangjian
 * @description 使用springboot，权限管理使用spring security，使用内存用户验证，但无响应报错：
 * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
 * 解决方法：
 * 这是因为Spring boot 2.0.3引用的security 依赖是 spring security 5.X版本，此版本需要提供一个PasswordEncorder的实例，否则后台汇报错误：
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/30 上午 08:59
 * @since 1.0.0
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
