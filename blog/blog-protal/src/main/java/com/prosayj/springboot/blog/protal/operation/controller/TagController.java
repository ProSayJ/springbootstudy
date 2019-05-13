package com.prosayj.springboot.blog.protal.operation.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.operation.vo.TagVo;
import com.prosayj.springboot.blog.protal.operation.service.TagService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TagController
 */
@RestController("tagPortalController")
@RequestMapping("/operation")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    public Result listTag() {
        List<TagVo> tagList = tagService.listTagVo();
        return Result.ok().put("tagList", tagList);
    }

}
