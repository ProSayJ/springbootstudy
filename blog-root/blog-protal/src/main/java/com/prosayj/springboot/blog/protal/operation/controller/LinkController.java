package com.prosayj.springboot.blog.protal.operation.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.operation.Link;
import com.prosayj.springboot.blog.protal.operation.service.LinkService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * LinkController
 *
 * @description
 */
@RequestMapping("/operation")
@RestController("LinkPortalController")
public class LinkController {

    @Resource
    private LinkService linkService;

    @RequestMapping("/links")
    public Result listLink() {
        List<Link> linkList = linkService.listLink();
        return Result.ok().put("linkList",linkList);
    }
}
