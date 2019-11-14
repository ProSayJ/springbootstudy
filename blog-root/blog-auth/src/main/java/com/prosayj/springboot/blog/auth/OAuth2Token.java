package com.prosayj.springboot.blog.auth;


import org.apache.shiro.authc.AuthenticationToken;


/**
 * @author yangjian
 * @description Shiro 认证类
 * @Date 16:46 2019/5/10
 * @since 1.0.0
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
