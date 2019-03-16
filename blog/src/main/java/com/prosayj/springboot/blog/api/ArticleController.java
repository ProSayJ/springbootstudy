package com.prosayj.springboot.blog.api;

import com.prosayj.springboot.blog.api.vo.input.BlogUpdateVO;
import com.prosayj.springboot.blog.api.vo.output.ArticleVO;
import com.prosayj.springboot.blog.models.article.ArticleService;
import com.prosayj.springboot.blog.models.article.module.ArticleDTO;
import com.prosayj.springboot.blog.api.vo.input.BlogCreateVO;
import com.prosayj.springboot.blog.api.vo.input.IdVO;
import com.prosayj.springboot.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Api(value = "article-controller", tags = "article-controller", description = "文章操作类")
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @ApiOperation(value = "文章列表", nickname = "article-controller-list")
    @GetMapping("/list")
    public String articlelist(Model model) {
        /*
        model.addAttribute("title", "用户列表");
        model.addAttribute("hello", "Hello, Spring Boot!");
        */
        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.query(), ArticleVO.class);
        model.addAttribute("articleList", articleVOS);
        return "articlelist";
    }

    @ApiOperation(value = "发布文章", nickname = "article-controller-publish")
    @PostMapping("/publish")
    @ResponseBody
    public Map<String, String> publishArticle(BlogCreateVO blogs) {
        String mdArticleContent = blogs.getArticleContent();
        System.out.println(mdArticleContent);
        //获得文章html代码并生成摘要
        String articleHtmlContent = blogs.getArticleHtmlContent();
        System.out.println(articleHtmlContent);
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(blogs.getArticleContent());
        articleDTO.setArticleHtmlContent(blogs.getArticleHtmlContent());

        articleDTO.setArticleTitle(blogs.getArticleTitle());
        articleDTO.setArticleCategories(blogs.getArticleCategories());
        articleDTO.setOriginalAuthor(blogs.getAuthor());
        articleService.insert(articleDTO);
        return result;
    }


    @ApiOperation(value = "文章详情", nickname = "article-controller-detail")
    @PostMapping("/detail")
    @ResponseBody
    public String articleEcho(IdVO idVO) {
        String articleMdContent = articleService.getArticelByPrimaryKey(idVO.getId()).getArticleMdContent();
        return articleMdContent;
    }

    @ApiOperation(value = "更新文章内容", nickname = "article-controller-update")
    @PostMapping("/update")
    @ResponseBody
    public Map<String, String> update(BlogUpdateVO updateVO) {
        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(updateVO.getArticleContent());
        articleDTO.setArticleHtmlContent(updateVO.getArticleHtmlContent());
        articleDTO.setId(updateVO.getId());
        articleService.updateByCondition(articleDTO);
        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
        return result;
    }
}