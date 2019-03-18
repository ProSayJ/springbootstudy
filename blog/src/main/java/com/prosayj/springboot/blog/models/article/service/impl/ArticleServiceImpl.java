package com.prosayj.springboot.blog.models.article.service.impl;

import com.prosayj.springboot.blog.models.article.service.ArticleService;
import com.prosayj.springboot.blog.models.article.domain.ArticleDomain;
import com.prosayj.springboot.blog.models.article.mapper.ArticleDomainMapper;
import com.prosayj.springboot.blog.models.article.module.ArticleDTO;
import com.prosayj.springboot.utils.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDomainMapper articleDomainMapper;

    @Override
    public void insert(ArticleDTO articleDTO) {
        ArticleDomain articleDomain = new ArticleDomain();
        articleDomain.setArticleHtmlContent(articleDTO.getArticleHtmlContent());
        articleDomain.setArticleMdContent(articleDTO.getArticleMdContent());
        articleDomain.setArticleCategories(articleDTO.getArticleCategories());
        articleDomain.setOriginalAuthor(articleDTO.getOriginalAuthor());
        articleDomain.setArticleTitle(articleDTO.getArticleTitle());

        articleDomain.setArticleId(2L);
        articleDomain.setAuthorId(2L);
        articleDomain.setArticleSummary("文章摘要");
        articleDomain.setArticleType((byte) 1);
        articleDomain.setArticleUrl("www.baidu.com");
        articleDomain.setLikes("喜欢");
        articleDomain.setLastArticleId("111");
        articleDomain.setArticleTags("文章标签");
        articleDomain.setNextArticleId(2);
        articleDomain.setPublishDate(new Date());
        articleDomain.setUpdateDate(new Date());
        articleDomain.setIsDelete((byte) 2);
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

    @Override
    public List<ArticleDTO> query() {
        List<ArticleDomain> articleDomains = articleDomainMapper.selectByCondition();
        return BeanUtil.toBeanList(articleDomains, ArticleDTO.class);
    }

    @Override
    public void updateByCondition(ArticleDTO articleDTO) {
        ArticleDomain articleDomain = new ArticleDomain();
        BeanUtil.copyProperties(articleDTO, articleDomain);
        articleDomain.setUpdateDate(new Date());
        articleDomainMapper.updateByPrimaryKeySelective(articleDomain);

    }
}
