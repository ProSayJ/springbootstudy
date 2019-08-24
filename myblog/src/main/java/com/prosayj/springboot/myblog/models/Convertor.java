package com.prosayj.springboot.myblog.models;

import com.prosayj.springboot.myblog.api.vo.input.BlogCreateVO;
import com.prosayj.springboot.myblog.api.vo.input.BlogUpdateVO;
import com.prosayj.springboot.myblog.models.dto.ArticleDTO;
import com.prosayj.springboot.myblog.repository.domain.TagsDomain;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.utils.BeanUtil;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/5/16 17:27
 * @since 1.0.0
 */
public class Convertor {
    public static List<TagsDTO> toTagsDtos(List<TagsDomain> tagsByArticelId) {
        List<TagsDTO> tagsDTOS = BeanUtil.toBeanList(tagsByArticelId, TagsDTO.class);

//        List<TagsDTO> tagsDTOS = new ArrayList<>(tagsByArticelId.size());
//        tagsByArticelId.forEach(data -> {
//            TagsDTO tagsDTO = new TagsDTO();
//            tagsDTO.setId(data.getId());
//            tagsDTO.setTagName(data.getTagName());
//            tagsDTOS.add(tagsDTO);
//        });
        return tagsDTOS;
    }

    public static ArticleDTO toArticleDTO(BlogCreateVO blogs) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(blogs.getArticleContent());
        articleDTO.setArticleHtmlContent(blogs.getArticleHtmlContent());
        articleDTO.setArticleTitle(blogs.getArticleTitle());
        articleDTO.setArticleTags(blogs.getArticleTags());
        articleDTO.setOriginalAuthor(blogs.getAuthor());
        return articleDTO;
    }

    public static ArticleDTO toArticleDTO(BlogUpdateVO updateVO) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(updateVO.getArticleContent());
        articleDTO.setArticleHtmlContent(updateVO.getArticleHtmlContent());
        articleDTO.setId(updateVO.getId());
        return articleDTO;
    }
}
