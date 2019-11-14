package com.prosayj.springboot.blog.core.mapper.article;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.article.ArticleComment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 文章评论 Mapper 接口
 * </p>
 */
@Mapper
public interface ArticleCommentMapper extends BaseMapper<ArticleComment> {

    /**
     * 根据articleId查询评论
     *
     * @param articleId
     * @return
     */
    List<ArticleComment> listByArticleId(Integer articleId);
}
