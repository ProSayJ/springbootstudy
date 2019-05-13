package com.prosayj.springboot.blog.protal.operation.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.operation.vo.RecommendVo;
import com.prosayj.springboot.blog.protal.operation.service.RecommendService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Recommend
 *
 * @description
 */
@RestController("recommendPortalController")
@RequestMapping("/operation")
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @RequestMapping("/recommends")
    public Result listRecommend() {
        List<RecommendVo> recommendList = recommendService.listRecommendVo();
        return Result.ok().put("recommendList", recommendList);
    }

    @RequestMapping("/hotReads")
    public Result listHotRead() {
        List<RecommendVo> hotReadList = recommendService.listHotRead();
        return Result.ok().put("hotReadList", hotReadList);
    }
}
