package com.prosayj.springboot.blog.core.entity.sys.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;


/**
 * @author yangjian
 * @description 登录表单对象
 * @Date 12:23 2019/5/13
 * @since 1.0.0
 */
@Data
public class SysLoginForm {
    @NotNull
    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "验证码", required = true)
    private String captcha;

    @ApiModelProperty(value = "随机串", required = true)
    private String uuid;
}
