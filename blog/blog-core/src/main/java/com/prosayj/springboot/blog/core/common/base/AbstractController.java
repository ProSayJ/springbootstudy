package com.prosayj.springboot.blog.core.common.base;

import com.prosayj.springboot.blog.core.entity.sys.SysUser;
import org.apache.shiro.SecurityUtils;


/**
 * @author yangjian
 * @description AbstractController
 * @Date 16:48 2019/5/10
 * @since 1.0.0
 */
public class AbstractController {

    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Integer getUserId() {
        return getUser().getUserId();
    }
}
