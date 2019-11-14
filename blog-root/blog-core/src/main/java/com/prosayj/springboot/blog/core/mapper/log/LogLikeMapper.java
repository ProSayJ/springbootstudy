package com.prosayj.springboot.blog.core.mapper.log;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.log.LogLike;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 阅读日志 Mapper 接口
 * </p>
 */
@Mapper
public interface LogLikeMapper extends BaseMapper<LogLike> {

}
