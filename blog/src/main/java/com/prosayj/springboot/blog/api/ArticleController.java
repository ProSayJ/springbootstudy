package com.prosayj.springboot.blog.api;

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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.FileWriter;
import java.io.IOException;
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


    @ApiOperation(value = "发布文章", nickname = "article-publish-article")
    @PostMapping("/publish-article")
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
        articleService.insert(articleDTO);
        return result;
    }

    @ApiOperation(value = "文章内容回显", nickname = "article-echo")
    @PostMapping("/echo")
    @ResponseBody
    public String articleEcho(IdVO idVO) {
        String articleMdContent = articleService.getArticelByPrimaryKey(1L).getArticleMdContent();
        return articleMdContent;
    }

    @ApiOperation(value = "文章列表", nickname = "article-list")
    @PostMapping("/list")
//    @ResponseBody
//    public List<ArticleVO> articleList(IdVO idVO) throws IOException {
    public void articleList(Model model) throws IOException {
        List<ArticleVO> articleVOS = BeanUtil.toBeanList(articleService.query(), ArticleVO.class);


        //构造模板引擎
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
//        这里必须是resolver.setPrefix("templates/");不能是resolver.setPrefix("/templates/");
        resolver.setPrefix("templates/");//模板所在目录，相对于当前classloader的classpath。
        resolver.setSuffix(".html");//模板文件后缀
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);

        //构造上下文(Model)
        Context context = new Context();
        context.setVariable("name", "蔬菜列表");
        context.setVariable("array", new String[]{"土豆", "番茄", "白菜", "芹菜"});

        //渲染模板
        FileWriter write = new FileWriter("result.html");
        templateEngine.process("example", context, write);


//        return articleVOS;

        model.addAttribute("title", "用户列表");
        model.addAttribute("hello", "Hello, Spring Boot!");


        model.addAttribute("articleList", articleVOS);
//        return "articlelist";
    }
}
