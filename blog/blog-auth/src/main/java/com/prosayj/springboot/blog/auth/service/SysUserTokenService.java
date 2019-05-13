package com.prosayj.springboot.blog.auth.service;


import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.sys.SysUserToken;

public interface SysUserTokenService {
    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    Result createToken(Integer userId);

    /**
     * 查询token
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 退出登录
     *
     * @param userId
     */
    void logout(Integer userId);

    /**
     * 续期
     *
     * @param userId
     * @param token
     */
    void refreshToken(Integer userId, String token);
}
