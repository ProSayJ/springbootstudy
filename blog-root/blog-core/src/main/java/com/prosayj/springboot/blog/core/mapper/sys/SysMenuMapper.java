package com.prosayj.springboot.blog.core.mapper.sys;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.sys.SysMenu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 查询非按钮的菜单
     *
     * @return
     */
    List<SysMenu> queryNotButtonList();

    /**
     * 根据parentId查询菜单
     *
     * @param parentId
     * @return
     */
    List<SysMenu> queryListParentId(Integer parentId);
}