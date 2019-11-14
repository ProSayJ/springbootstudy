package com.prosayj.springboot.blog.core.entity.article.vo;

import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.List;

//文章列表VO
@Data
public class ArticleVo extends Article {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

}
