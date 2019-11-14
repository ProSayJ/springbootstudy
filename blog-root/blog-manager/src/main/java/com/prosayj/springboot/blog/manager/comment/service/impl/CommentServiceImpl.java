package com.prosayj.springboot.blog.manager.comment.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.util.Query;
import com.prosayj.springboot.blog.core.entity.comment.Comment;
import com.prosayj.springboot.blog.core.mapper.common.CommentMapper;
import com.prosayj.springboot.blog.manager.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 文章评论 服务实现类
 * </p>
 */
@Service
@Slf4j
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {

    /**
     * 分页查询
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String type = (String) params.get("type");
        IPage<Comment> page = baseMapper.selectPage(new Query<Comment>(params).getPage(),
                new QueryWrapper<Comment>().lambda()
                        .eq(StringUtils.isNotEmpty(type), Comment::getType, type));
        return new PageUtils(page);
    }

}
