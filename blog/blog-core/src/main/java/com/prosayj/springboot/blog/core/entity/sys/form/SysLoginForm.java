package com.prosayj.springboot.blog.core.entity.sys.form;

import lombok.Data;


/**
 * @author yangjian
 * @description 登录表单对象
 * @Date 12:23 2019/5/13
 * @since 1.0.0
 */
@Data
public class SysLoginForm {
    private String username;
    private String password;
    private String captcha;
    private String uuid;
}
