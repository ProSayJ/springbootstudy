package com.prosayj.springboot.blog.auth.service;


import com.prosayj.springboot.blog.core.entity.sys.SysUser;
import com.prosayj.springboot.blog.core.entity.sys.SysUserToken;

import java.util.Set;


/**
 * @author yangjian
 * @description ShiroService
 * @Date 16:22 2019/5/10
 * @since 1.0.0
 */
public interface ShiroService {

    /**
     * 获取用户的所有权限
     *
     * @param userId
     * @return
     */
    Set<String> getUserPermissions(Integer userId);

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 查询用户信息
     *
     * @param userId
     * @return
     */
    SysUser queryUser(Integer userId);

    /**
     * 续期
     *
     * @param userId
     * @param accessToken
     */
    void refreshToken(Integer userId, String accessToken);
}
