package com.prosayj.springboot.blog.core.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.operation.Link;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 友链 Mapper 接口
 * </p>
 *
 */
@Mapper
public interface LinkMapper extends BaseMapper<Link> {

}
