package com.prosayj.springboot.myblog.api;

import com.prosayj.springboot.myblog.api.vo.input.IdVO;
import com.prosayj.springboot.myblog.api.vo.output.ArticleVO;
import com.prosayj.springboot.myblog.api.vo.output.ImageVO;
import com.prosayj.springboot.myblog.models.dto.ImageDTO;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.myblog.service.ArticleService;
import com.prosayj.springboot.myblog.service.FileService;
import com.prosayj.springboot.myblog.service.TagService;
import com.prosayj.springboot.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author yangjian
 * @description 管理员角色控制器
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/7 下午 04:05
 * @since 1.0.0
 */
@Api(value = "admin-controller", tags = "admin-controller", description = "管理员角色控制器")
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private TagService tagService;
    @Autowired
    private FileService fileService;

    @ApiOperation(value = "控制台首页")
    @GetMapping("/index")
    public String adminIndex() {
        return "freemark/admin/admin_index";
    }

    @ApiOperation(value = "控制台_仪表盘")
    @GetMapping("/console")
    public String adminConsole() {
        return "freemark/admin/admin_console";
    }

    @ApiOperation(value = "控制台_新建文章")
    @GetMapping("/article/create")
    public String adminCreateArticle() {
        return "freemark/admin/admin_article_create";
    }

    @ApiOperation(value = "控制台_文章列表")
    @GetMapping("/article/list")
    public ModelAndView adminArticleList() {
        ModelAndView mv = new ModelAndView();
        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.queryByTags(null), ArticleVO.class);
        List<TagsDTO> allTags = tagService.getAllTags();
        mv.addObject("articleList", articleVOS);
        mv.addObject("allTags", allTags);
        mv.setViewName("freemark/admin/admin_article_list");
        return mv;
    }

    @ApiOperation(value = "控制台_文章预览")
    @GetMapping("/article/preview")
    public ModelAndView preview(IdVO idVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("freemark/admin/admin_article_preview");
        modelAndView.addObject("previewId", idVO.getId());
        return modelAndView;
    }

    @ApiOperation(value = "控制台_图片管理")
    @GetMapping("/file/list/imgs")
    public ModelAndView fileListImgs() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("freemark/admin/admin_file_list");
        List<ImageVO> imageVOS = BeanUtil.toBeanList(fileService.getAllImgsDetails(), ImageVO.class);
        modelAndView.addObject("imgs", imageVOS);
        return modelAndView;
    }


    @ApiOperation(value = "控制台_图片和标签管理")
    @GetMapping("/categories-tags")
    public ModelAndView categoriesAndTags() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("freemark/admin/admin_categories_tags");
        List<TagsDTO> allTags = tagService.getAllTags();
        mv.addObject("allTags", allTags);
        return mv;
    }

}
