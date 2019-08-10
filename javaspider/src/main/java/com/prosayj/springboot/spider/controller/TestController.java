package com.prosayj.springboot.spider.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Api(value = "test-controller", tags = "test-controller", description = "测试controller")
@Controller
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "测试")
    @PostMapping("/getall")
    public void articlelist(@RequestParam("dataString") String dataString) {

    }

}