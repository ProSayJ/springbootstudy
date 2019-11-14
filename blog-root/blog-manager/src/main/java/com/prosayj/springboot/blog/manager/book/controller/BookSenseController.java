package com.prosayj.springboot.blog.manager.book.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.book.BookSense;
import com.prosayj.springboot.blog.manager.book.service.BookSenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Api(value = "BookSenseController", tags = "BookSenseController", description = "读后感 前端控制器")
@RestController
@Slf4j
@RequestMapping("/admin/book/sense")
public class BookSenseController extends AbstractController {

    @Autowired
    private BookSenseService bookSenseService;

    @ApiOperation(value = "获取读后感", nickname = "BookSenseController-getinfo")
    @GetMapping("/{bookId}")
    @RequiresPermissions("book:info")
    public Result getReadSense(
            @ApiParam(name = "bookId", value = "图书id", required = true)
            @PathVariable Integer bookId) {
        BookSense bookSense = bookSenseService.getBookSense(bookId);
        return Result.ok().put("bookSense", bookSense);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("book:save")
    public Result save(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSenseService.save(bookSense);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("book:update")
    public Result update(@RequestBody BookSense bookSense) {
        ValidatorUtils.validateEntity(bookSense);
        bookSense.setUpdateTime(new Date());
        bookSenseService.updateById(bookSense);
        return Result.ok();
    }
}
