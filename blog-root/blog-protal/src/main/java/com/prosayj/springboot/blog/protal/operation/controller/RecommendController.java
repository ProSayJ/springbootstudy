package com.prosayj.springboot.blog.protal.operation.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.entity.operation.vo.RecommendVo;
import com.prosayj.springboot.blog.protal.operation.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Recommend
 *
 * @description
 */
@Api(value = "RecommendController", tags = "RecommendController", description = "系统推荐控制器")
@RestController("recommendPortalController")
@RequestMapping("/operation")
public class RecommendController {

    @Resource
    private RecommendService recommendService;

    @ApiOperation(value = "获取推荐阅读的文章", nickname = "RecommendController-listRecommend")
    @RequestMapping("/recommends")
    public Result listRecommend() {
        List<RecommendVo> recommendList = recommendService.listRecommendVo();
        return Result.ok().put("recommendList", recommendList);
    }

    @ApiOperation(value = "获取热推文章", nickname = "RecommendController-listHotRead")
    @RequestMapping("/hotReads")
    public Result listHotRead() {
        List<RecommendVo> hotReadList = recommendService.listHotRead();
        return Result.ok().put("hotReadList", hotReadList);
    }
}
