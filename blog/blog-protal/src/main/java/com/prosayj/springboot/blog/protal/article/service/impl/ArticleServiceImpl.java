package com.prosayj.springboot.blog.protal.article.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.util.Query;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;
import com.prosayj.springboot.blog.core.mapper.article.ArticleMapper;
import com.prosayj.springboot.blog.manager.operation.service.TagService;
import com.prosayj.springboot.blog.protal.article.service.ArticleService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 文章 服务实现类
 * </p>
 */
@Service("ArticlePortalService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Resource
    private TagService tagService;

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<ArticleVo> page = new Query<ArticleVo>(params).getPage();
        List<ArticleVo> articleList = baseMapper.queryPageCondition(page, params);
        // 封装ArticleVo
        Optional.ofNullable(articleList).ifPresent((articleVos ->
                articleVos.forEach(articleVo -> {
                    // 设置标签列表
                    articleVo.setTagList(tagService.listByLinkId(articleVo.getId(), ModuleEnum.ARTICLE.getValue()));
                })));
        page.setRecords(articleList);
        return new PageUtils(page);
    }

    /**
     * 获取ArticleVo对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVo getArticleVo(Integer articleId) {
        Article article = baseMapper.selectById(articleId);
        ArticleVo articleVo = new ArticleVo();
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setTagList(tagService.listByLinkId(articleId, ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

    /**
     * 获取简单的Article对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleVo getSimpleArticleVo(Integer articleId) {
        ArticleVo articleVo = baseMapper.getSimpleArticleVo(articleId);
        articleVo.setTagList(tagService.listByLinkId(articleId, ModuleEnum.ARTICLE.getValue()));
        return articleVo;
    }

}
