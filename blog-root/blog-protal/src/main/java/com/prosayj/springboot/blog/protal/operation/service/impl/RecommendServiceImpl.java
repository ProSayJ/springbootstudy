package com.prosayj.springboot.blog.protal.operation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.entity.article.vo.ArticleVo;
import com.prosayj.springboot.blog.core.entity.book.vo.BookNoteVo;
import com.prosayj.springboot.blog.core.entity.operation.Recommend;
import com.prosayj.springboot.blog.core.entity.operation.vo.RecommendVo;
import com.prosayj.springboot.blog.manager.operation.mapper.RecommendMapper;
import com.prosayj.springboot.blog.protal.article.service.ArticleService;
import com.prosayj.springboot.blog.protal.book.service.BookNoteService;
import com.prosayj.springboot.blog.protal.operation.service.RecommendService;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * RecommendServiceImpl
 */
@Service("recommendPortalService")
public class RecommendServiceImpl extends ServiceImpl<RecommendMapper, Recommend> implements RecommendService {

    @Resource
    private ArticleService articleService;

    @Resource
    private BookNoteService bookNoteService;


    @Override
    @Cacheable(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public List<RecommendVo> listRecommendVo() {
        List<RecommendVo> recommendList = this.baseMapper.listRecommendVo();
        return genRecommendList(recommendList);
    }

    @Override
    public List<RecommendVo> listHotRead() {
        List<RecommendVo> hotReadList = this.baseMapper.listHotRead();
        genRecommendList(hotReadList);
        hotReadList.get(0).setTop(true);
        return hotReadList;
    }

    private List<RecommendVo> genRecommendList(List<RecommendVo> recommendList) {
        recommendList.forEach(recommendVo -> {
            if (ModuleEnum.ARTICLE.getValue() == recommendVo.getType()) {
                ArticleVo simpleArticleVo = articleService.getSimpleArticleVo(recommendVo.getLinkId());
                BeanUtils.copyProperties(simpleArticleVo, recommendVo);
                recommendVo.setUrlType("article");
            } else if (ModuleEnum.BOOK_NOTE.getValue() == recommendVo.getType()) {
                BookNoteVo simpleBookNoteVo = bookNoteService.getSimpleBookNoteVo(recommendVo.getLinkId());
                recommendVo.setUrlType("bookNote");
                BeanUtils.copyProperties(simpleBookNoteVo, recommendVo);
            }
        });
        return recommendList;
    }
}
