package com.prosayj.springboot.blog.manager.operation.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import com.prosayj.springboot.blog.core.entity.operation.TagLink;
import com.prosayj.springboot.blog.core.mapper.operation.TagLinkMapper;
import com.prosayj.springboot.blog.manager.operation.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 标签 前端控制器
 * </p>
 */
@RestController
@Slf4j
@RequestMapping("/admin/operation/tag")
public class TagController extends AbstractController {
    @Autowired
    private TagService tagService;

    @Resource
    private TagLinkMapper tagLinkMapper;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("operation:tag:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = tagService.queryPage(params);

        return Result.ok().put("page", page);
    }

    @GetMapping("/select")
    @RequiresPermissions("operation:tag:list")
    public Result select(@RequestParam("type") Integer type) {
        List<Tag> tagList = tagService.list(new QueryWrapper<Tag>().lambda().eq(type != null, Tag::getType, type));
        return Result.ok().put("tagList", tagList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("operation:tag:info")
    public Result info(@PathVariable("id") String id) {
        Tag tag = tagService.getById(id);

        return Result.ok().put("tag", tag);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("operation:tag:save")
    @CacheEvict(value = RedisKeyConstants.PORTAL_TAG_LIST)
    public Result save(@RequestBody Tag tag) {
        ValidatorUtils.validateEntity(tag);
        tagService.save(tag);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("operation:tag:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_TAG_LIST)
    public Result update(@RequestBody Tag tag) {
        ValidatorUtils.validateEntity(tag);
        tagService.updateById(tag);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("operation:tag:delete")
    @CacheEvict(value = RedisKeyConstants.PORTAL_TAG_LIST)
    public Result delete(@RequestBody String[] ids) {
        for (String id : ids) {
            List<TagLink> tagLinkList = tagLinkMapper.selectList(new QueryWrapper<TagLink>().lambda().eq(TagLink::getTagId, id));
            if (!CollectionUtils.isEmpty(tagLinkList)) {
                TagLink tagLink = tagLinkList.get(0);
                if (tagLink.getType().equals(ModuleEnum.ARTICLE.getValue())) {
                    return Result.error("该标签下有文章，无法删除");
                }
                if (tagLink.getType().equals(ModuleEnum.BOOK.getValue())) {
                    return Result.error("该标签下有图书，无法删除");
                }
                if (tagLink.getType().equals(ModuleEnum.BOOK_NOTE.getValue())) {
                    return Result.error("该标签下有笔记，无法删除");
                }
            }
        }
        tagService.removeByIds(Arrays.asList(ids));

        return Result.ok();
    }
}
