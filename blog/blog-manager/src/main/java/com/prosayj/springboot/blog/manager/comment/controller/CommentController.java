package com.prosayj.springboot.blog.manager.comment.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.comment.Comment;
import com.prosayj.springboot.blog.manager.comment.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

/**
 * <p>
 * 文章评论 前端控制器
 * </p>
 */
@RestController
@Slf4j
@RequestMapping("/admin/comment")
public class CommentController extends AbstractController {
    @Autowired
    private CommentService commentService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("comment:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = commentService.queryPage(params);

        return Result.ok().put("page", page);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("comment:info")
    public Result info(@PathVariable("id") String id) {
        Comment comment = commentService.getById(id);

        return Result.ok().put("comment", comment);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("comment:save")
    public Result save(@RequestBody Comment comment) {
        ValidatorUtils.validateEntity(comment);
        commentService.save(comment);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("comment:update")
    public Result update(@RequestBody Comment comment) {
        ValidatorUtils.validateEntity(comment);
        commentService.updateById(comment);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("comment:delete")
    public Result delete(@RequestBody String[] ids) {
        commentService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
