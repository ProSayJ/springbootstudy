package com.prosayj.springboot.blog.auth.service;


import java.awt.image.BufferedImage;


/**
 * @author yangjian
 * @description 验证码类
 * @Date 16:45 2019/5/10
 * @since 1.0.0
 */
public interface SysCaptchaService {

    /**
     * 获取验证码
     *
     * @param uuid
     * @return
     */
    BufferedImage getCaptcha(String uuid);

    /**
     * 验证验证码
     *
     * @param uuid
     * @param code
     * @return
     */
    boolean validate(String uuid, String code);
}
