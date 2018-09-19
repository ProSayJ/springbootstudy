package com.prosayj.springboot.api;


import com.prosayj.springboot.api.vo.output.Article;
import com.prosayj.springboot.constants.LoggerModelEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_WEB.getModuleNickName());

    @RequestMapping(value = "/list")
    public @ResponseBody
    List<Article> list() {
        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Article article = new Article("图片" + i, "图片内容" + i, "http://www.baidu.com/pic/001.png" + i);
            articles.add(article);
        }
        return articles;
    }

    @RequestMapping("/hello")
    public String index() {
        return "backindex.html";
    }

}
