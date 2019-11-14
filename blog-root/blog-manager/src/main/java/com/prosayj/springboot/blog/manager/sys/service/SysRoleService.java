package com.prosayj.springboot.blog.manager.sys.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.sys.SysRole;

import java.util.List;
import java.util.Map;

/**
 * SysRoleService
 */
public interface SysRoleService extends IService<SysRole> {

    /**
     * 分页查询角色
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);

    /**
     * 批量删除
     *
     * @param roleIds
     */
    void deleteBatch(Integer[] roleIds);

    /**
     * 查询roleId
     *
     * @param createUserId
     * @return
     */
    List<Integer> queryRoleIdList(Integer createUserId);
}
