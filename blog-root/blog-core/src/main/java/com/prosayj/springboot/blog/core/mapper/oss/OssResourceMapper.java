package com.prosayj.springboot.blog.core.mapper.oss;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.oss.OssResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 云存储资源表 Mapper 接口
 * </p>
 */
@Mapper
public interface OssResourceMapper extends BaseMapper<OssResource> {

}
