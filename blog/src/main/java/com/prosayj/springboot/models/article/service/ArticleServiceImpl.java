package com.prosayj.springboot.models.article.service;

import com.prosayj.springboot.models.article.ArticleService;
import com.prosayj.springboot.models.article.domain.ArticleDomain;
import com.prosayj.springboot.models.article.mapper.ArticleDomainMapper;
import com.prosayj.springboot.models.article.module.ArticleDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDomainMapper articleDomainMapper;

    @Override
    public void insert(ArticleDTO articleDTO) {
        ArticleDomain articleDomain = new ArticleDomain();
        articleDomain.setArticleHtmlContent(articleDTO.getArticleHtmlContent());
        articleDomain.setArticleMdContent(articleDTO.getArticleMdContent());

        articleDomain.setArticleId(2L);
        articleDomain.setAuthorId(2L);
        articleDomain.setOriginalAuthor("张三");
        articleDomain.setArticleTitle("文章标题");
        articleDomain.setArticleSummary("文章摘要");
        articleDomain.setArticleType((byte)1);
        articleDomain.setArticleCategories("博客分类");
        articleDomain.setArticleUrl("www.baidu.com");
        articleDomain.setLikes("喜欢");
        articleDomain.setLastArticleId("111");
        articleDomain.setArticleTags("文章标签");
        articleDomain.setNextArticleId(2);
        articleDomain.setPublishDate(new Date());
        articleDomain.setUpdateDate(new Date());
        articleDomain.setIsDelete((byte)2);
        articleDomainMapper.insert(articleDomain);

    }

    @Override
    public ArticleDTO getArticelByPrimaryKey(Long id) {
        ArticleDTO result = new ArticleDTO();
        ArticleDomain articleDomain = articleDomainMapper.selectByPrimaryKey(id);
        if (articleDomain != null) {
            result.setArticleMdContent(articleDomain.getArticleMdContent());
        }
        return result;
    }
}
