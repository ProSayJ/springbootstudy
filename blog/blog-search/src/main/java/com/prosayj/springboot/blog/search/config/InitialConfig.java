package com.prosayj.springboot.blog.search.config;


import com.prosayj.springboot.blog.search.controller.ArticleEsController;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * InitialConfig
 *
 * @description
 */
@Configuration
public class InitialConfig {

    @Resource
    private ArticleEsController articleEsController;

    /**
     * 项目启动时重新导入索引
     */
    @PostConstruct
    public void initEsIndex() {
        try {
            articleEsController.refresh("initial Index");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
