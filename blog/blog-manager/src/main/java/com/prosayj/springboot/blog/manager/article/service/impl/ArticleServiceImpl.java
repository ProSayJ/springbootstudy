package com.prosayj.springboot.blog.manager.article.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.util.Query;
import com.prosayj.springboot.blog.core.entity.article.Article;
import com.prosayj.springboot.blog.core.entity.article.dto.ArticleDto;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;
import com.prosayj.springboot.blog.core.entity.operation.Category;
import com.prosayj.springboot.blog.core.mapper.article.ArticleMapper;
import com.prosayj.springboot.blog.manager.article.service.ArticleService;
import com.prosayj.springboot.blog.manager.operation.service.CategoryService;
import com.prosayj.springboot.blog.manager.operation.service.TagService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * articleAdminServiceImpl
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Autowired
    private TagService tagService;

    @Autowired
    private CategoryService categoryService;

    /**
     * 分页查询博文列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ArticleVo> page = new Query<ArticleVo>(params).getPage();
        List<ArticleVo> articleList = baseMapper.listArticleVo(page, params);
        // 查询所有分类
        List<Category> categoryList = categoryService.list(new QueryWrapper<Category>().lambda().eq(Category::getType, ModuleEnum.ARTICLE.getValue()));
        // 封装ArticleVo
        Optional.ofNullable(articleList).ifPresent((articleVos ->
                articleVos.forEach(articleVo -> {
                    // 设置类别
                    articleVo.setCategoryListStr(categoryService.renderCategoryArr(articleVo.getCategoryId(), categoryList));
                    // 设置标签列表
                    articleVo.setTagList(tagService.listByLinkId(articleVo.getId(), ModuleEnum.ARTICLE.getValue()));
                })));
        page.setRecords(articleList);
        return new PageUtils(page);
    }


    /**
     * 保存博文文章
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveArticle(ArticleDto article) {
        baseMapper.insert(article);
        tagService.saveTagAndNew(article.getTagList(), article.getId(), ModuleEnum.ARTICLE.getValue());
    }

    /**
     * 更新博文
     *
     * @param article
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateArticle(ArticleDto article) {
        // 删除多对多所属标签
        tagService.deleteTagLink(article.getId(), ModuleEnum.ARTICLE.getValue());
        // 更新所属标签
        tagService.saveTagAndNew(article.getTagList(), article.getId(), ModuleEnum.ARTICLE.getValue());
        // 更新博文
        baseMapper.updateById(article);
    }

    /**
     * 获取文章对象
     *
     * @param articleId
     * @return
     */
    @Override
    public ArticleDto getArticle(Integer articleId) {
        ArticleDto articleDto = new ArticleDto();
        Article article = this.baseMapper.selectById(articleId);
        BeanUtils.copyProperties(article, articleDto);
        // 查询所属标签
        articleDto.setTagList(tagService.listByLinkId(articleId, ModuleEnum.ARTICLE.getValue()));
        return articleDto;
    }

    @Override
    public boolean checkByCategory(Integer categoryId) {
        return baseMapper.checkByCategory(categoryId) > 0;
    }

    /**
     * 批量删除
     *
     * @param articleIds
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteBatch(Integer[] articleIds) {
        //先删除博文标签多对多关联
        Arrays.stream(articleIds).forEach(articleId -> {
            tagService.deleteTagLink(articleId, ModuleEnum.ARTICLE.getValue());
        });
        this.baseMapper.deleteBatchIds(Arrays.asList(articleIds));
    }


}
