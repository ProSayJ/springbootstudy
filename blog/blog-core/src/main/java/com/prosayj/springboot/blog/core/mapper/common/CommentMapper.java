package com.prosayj.springboot.blog.core.mapper.common;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.comment.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 文章评论 Mapper 接口
 * </p>
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {

}
