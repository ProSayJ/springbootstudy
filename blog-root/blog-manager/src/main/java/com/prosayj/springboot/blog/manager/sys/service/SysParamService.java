package com.prosayj.springboot.blog.manager.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.sys.SysParam;

import java.util.Map;

/**
 * <p>
 * 系统参数 服务类
 * </p>
 *
 */
public interface SysParamService extends IService<SysParam> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
}
