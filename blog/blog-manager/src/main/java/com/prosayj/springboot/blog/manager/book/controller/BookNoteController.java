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
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping("/admin/book/note")
public class BookNoteController {

    @Resource
    private BookNoteService bookNoteService;

    @Resource
    private RecommendService recommendService;

    @GetMapping("/list")
    @RequiresPermissions("book:note:list")
    public Result listBookNote(@RequestParam Map<String, Object> params) {
        PageUtils page = bookNoteService.queryPage(params);
        return Result.ok().put("page",page);
    }

    @GetMapping("/info/{bookNoteId}")
    @RequiresPermissions("book:note:list")
    public Result info(@PathVariable Integer bookNoteId) {
        BookNoteDto bookNote = bookNoteService.getBookNote(bookNoteId);
        return Result.ok().put("bookNote",bookNote);
    }

    @PostMapping("/save")
    @RequiresPermissions("book:note:save")
    public Result saveBookNote(@RequestBody BookNoteDto bookNote){
        ValidatorUtils.validateEntity(bookNote);
        bookNoteService.saveBookNote(bookNote);
        return Result.ok();
    }

    @PutMapping("/update")
    @RequiresPermissions("book:note:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result updateBookNote(@RequestBody BookNoteDto bookNote){
        ValidatorUtils.validateEntity(bookNote);
        bookNote.setUpdateTime(new Date());
        bookNoteService.updateBookNote(bookNote);
        return Result.ok();
    }
    
    @PutMapping("/update/status")
    @RequiresPermissions("book:note:update")
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result updateStatus(@RequestBody BookNote bookNote) {
        bookNoteService.updateById(bookNote);
        return Result.ok();
    }


    @DeleteMapping("/delete")
    @RequiresPermissions("book:note:delete")
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = RedisKeyConstants.PORTAL_RECOMMEND_LIST)
    public Result deleteBatch(@RequestBody Integer[] bookNoteIds){
        recommendService.deleteBatchByLinkId(bookNoteIds, ModuleEnum.BOOK_NOTE.getValue());
        bookNoteService.deleteBatch(bookNoteIds);
        return Result.ok();
    }

}
