package com.prosayj.springboot.myblog.api_freemark;

import com.prosayj.springboot.myblog.api.vo.input.BlogCreateVO;
import com.prosayj.springboot.myblog.api.vo.input.BlogUpdateVO;
import com.prosayj.springboot.myblog.api.vo.input.IdVO;
import com.prosayj.springboot.myblog.api.vo.output.ArticleVO;
import com.prosayj.springboot.myblog.models.dto.ArticleDTO;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.myblog.models.service.ArticleService;
import com.prosayj.springboot.myblog.models.service.TagService;
import com.prosayj.springboot.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
@Api(value = "articlefee-controller", tags = "article-controller", description = "文章操作类")
@Controller
@RequestMapping("/articlefee")
public class ArticleControllerFreemk {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;

    @ApiOperation(value = "文章列表", nickname = "article-controller-list")
    @GetMapping("/list")
    public ModelAndView articlelist(ModelAndView mv) {
        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.query(), ArticleVO.class);
        List<TagsDTO> allTags = tagService.getAllTags();
        mv.addObject("articleList", articleVOS);
        mv.addObject("allTags", allTags);
        mv.setViewName("freemark/articlelist");
        return mv;
    }

    @ApiOperation(value = "创建文章", nickname = "article-controller-create")
    @GetMapping("/create")
    public ModelAndView create(ModelAndView mv) {
        List<TagsDTO> allTags = tagService.getAllTags();
        mv.addObject("allTags", allTags);
        mv.setViewName("freemark/create");
        return mv;
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

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setArticleMdContent(blogs.getArticleContent());
        articleDTO.setArticleHtmlContent(blogs.getArticleHtmlContent());

        articleDTO.setArticleTitle(blogs.getArticleTitle());
        articleDTO.setArticleTags(blogs.getArticleTags());
        articleDTO.setOriginalAuthor(blogs.getAuthor());
        articleService.insert(articleDTO);

        Map<String, String> result = new HashMap<>();
        result.put("status", "200");
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

    @ApiOperation(value = "获取文章所有的标签", nickname = "article-controller-getalltags")
    @PostMapping("/getalltags")
    @ResponseBody
    public List<TagsDTO> getAllTags() {
        List<TagsDTO> allTags = tagService.getAllTags();
        return allTags;
    }

    @ApiOperation(value = "文章列表", nickname = "article-controller-list")
    @GetMapping("/list/articlelistbytagid")
    public ModelAndView articlelistbytagid(@ModelAttribute("id") Long id, ModelAndView mv) {
        System.out.println("11111111>" + id);
        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.queryByTags(id), ArticleVO.class);
        List<TagsDTO> allTags = tagService.getAllTags();
        mv.addObject("articleList", articleVOS);
        mv.addObject("allTags", allTags);
        mv.setViewName("freemark/articlelist");
        return mv;
    }
}