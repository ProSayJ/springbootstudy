package com.prosayj.springboot.blog.search.search.mapper;

import com.prosayj.springboot.blog.core.entity.article.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * ArticleRepository
 *
 * @description
 */
@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Integer> {
}
