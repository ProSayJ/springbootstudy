package com.prosayj.springboot.blog.manager.operation.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.operation.Link;

import java.util.Map;

/**
 * <p>
 * 友链 服务类
 * </p>
 *
 */
public interface LinkService extends IService<Link> {

    /**
     * 分页查询
     * @param params
     * @return
     */
     PageUtils queryPage(Map<String, Object> params);
}
