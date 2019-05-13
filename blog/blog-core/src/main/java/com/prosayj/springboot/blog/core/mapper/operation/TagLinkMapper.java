package com.prosayj.springboot.blog.core.mapper.operation;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.operation.TagLink;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章标签多对多维护表 Mapper 接口
 * </p>
 *
 */
@Mapper
public interface TagLinkMapper extends BaseMapper<TagLink> {

}
