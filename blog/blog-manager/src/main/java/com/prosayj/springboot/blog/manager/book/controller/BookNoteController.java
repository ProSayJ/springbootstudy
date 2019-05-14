package com.prosayj.springboot.blog.manager.book.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.constants.RedisKeyConstants;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.dto.BookNoteDto;
import com.prosayj.springboot.blog.manager.book.service.BookNoteService;
import com.prosayj.springboot.blog.manager.operation.service.RecommendService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@Api(value = "BookNoteController", tags = "BookNoteController", description = "读书前端控制器")
@RestController
@RequestMapping("/admin/book/note")
public class BookNoteController {

    @Resource
    private BookNoteService bookNoteService;

    @Resource
    private RecommendService recommendService;

    @ApiOperation(value = "读书笔记_分页查询", nickname = "BookNoteController-list")
    @GetMapping("/list")
    @RequiresPermissions("book:note:list")
    public Result listBookNote(
            @ApiParam(name = "params", value = "查询条件", required = true)
            @RequestParam Map<String, Object> params) {
        PageUtils page = bookNoteService.queryPage(params);
        return Result.ok().put("page", page);
    }

    @ApiOperation(value = "获取读书笔记的标签", nickname = "BookNoteController-info")
    @GetMapping("/info/{bookNoteId}")
    @RequiresPermissions("book:note:list")
    public Result info(
            @ApiParam(name = "bookNoteId", value = "读书笔记id", required = true)
            @PathVariable Integer bookNoteId) {
        BookNoteDto bookNote = bookNoteService.getBookNote(bookNoteId);
        return Result.ok().put("bookNote", bookNote);
    }

    @ApiOperation(value = "保存读书笔记", nickname = "BookNoteController-save")
    @PostMapping("/save")
    @RequiresPermissions("book:note:save")
    public Result saveBookNote(
            @ApiParam(name = "bookNote", value = "读书笔记实体", required = true)
            @RequestBody BookNoteDto bookNote) {
        ValidatorUtils.validateEntity(bookNote);
        bookNoteService.saveBookNote(bookNote);
        return Result.ok();
    }

    @ApiOperation(value = "更新读书笔记", nickname = "BookNoteController-update")
    @PutMapping("/update")
    @RequiresPermissions("book:note:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result updateBookNote(
            @ApiParam(name = "bookNote", value = "读书笔记实体", required = true)
            @RequestBody BookNoteDto bookNote) {
        ValidatorUtils.validateEntity(bookNote);
        bookNote.setUpdateTime(new Date());
        bookNoteService.updateBookNote(bookNote);
        return Result.ok();
    }

    @ApiOperation(value = "更新读书笔记状态", nickname = "BookNoteController-update-status")
    @PutMapping("/update/status")
    @RequiresPermissions("book:note:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result updateStatus(
            @ApiParam(name = "bookNote", value = "读书笔记实体", required = true)
            @RequestBody BookNote bookNote) {
        bookNoteService.updateById(bookNote);
        return Result.ok();
    }

    @ApiOperation(value = "删除读书笔记", nickname = "BookNoteController-delete")
    @DeleteMapping("/delete")
    @RequiresPermissions("book:note:delete")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result deleteBatch(
            @ApiParam(name = "bookNoteIds", value = "待删除的读书笔记ids", required = true)
            @RequestBody Integer[] bookNoteIds) {
        recommendService.deleteBatchByLinkId(bookNoteIds, ModuleEnum.BOOK_NOTE.getValue());
        bookNoteService.deleteBatch(bookNoteIds);
        return Result.ok();
    }

}
