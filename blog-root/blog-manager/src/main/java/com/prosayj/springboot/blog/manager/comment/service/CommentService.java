package com.prosayj.springboot.blog.manager.comment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.comment.Comment;

import java.util.Map;

/**
 * <p>
 * 文章评论 服务类
 * </p>
 */
public interface CommentService extends IService<Comment> {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    PageUtils queryPage(Map<String, Object> params);
}
