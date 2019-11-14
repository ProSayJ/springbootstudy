package com.prosayj.springboot.blog.core.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.sys.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//SysUserRoleMapper
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    /**
     * 查询roleId
     *
     * @param userId
     * @return
     */
    List<Integer> queryRoleIdList(Integer userId);
}
