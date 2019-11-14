package com.prosayj.springboot.blog.core.entity.article.dto;

import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.List;


@Data
public class ArticleDto extends Article {

    private List<Tag> tagList;

}
