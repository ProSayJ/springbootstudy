package com.prosayj.springboot.blog.manager.book.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.dto.BookDto;
import com.prosayj.springboot.blog.manager.book.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Api(value = "ArticleController", tags = "ArticleController", description = "图书前端控制器")
@RestController
@Slf4j
@RequestMapping("/admin/book")
public class BookController extends AbstractController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @ApiOperation(value = "图书列表_分页查询", nickname = "ArticleController-list")
    @GetMapping("/list")
    @RequiresPermissions("book:list")
    public Result list(
            @ApiParam(name = "params", value = "查询条件", required = true)
            @RequestParam Map<String, Object> params) {
        PageUtils page = bookService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 列表
     */
    @ApiOperation(value = "图书列表_all", nickname = "ArticleController-select")
    @GetMapping("/select")
    @RequiresPermissions("book:list")
    public Result select() {
        List<Book> bookList = bookService.list(null);
        return Result.ok().put("bookList", bookList);
    }


    /**
     * 信息
     */
    @ApiOperation(value = "图书信息", nickname = "ArticleController-info")
    @GetMapping("/info/{id}")
    @RequiresPermissions("book:info")
    public Result info(
            @ApiParam(name = "id", value = "图书id", required = true)
            @PathVariable("id") String id) {
        BookDto book = bookService.getBook(id);
        return Result.ok().put("book", book);
    }

    /**
     * 保存
     */
    @ApiOperation(value = "图书保存", nickname = "ArticleController-save")
    @PostMapping("/save")
    @RequiresPermissions("book:save")
    public Result save(
            @ApiParam(name = "book", value = "图书", required = true)
            @RequestBody BookDto book) {
        ValidatorUtils.validateEntity(book);
        bookService.saveBook(book);

        return Result.ok();
    }

    /**
     * 修改
     */
    @ApiOperation(value = "修改", nickname = "ArticleController-update")
    @PutMapping("/update")
    @RequiresPermissions("book:update")
    public Result update(
            @ApiParam(name = "book", value = "图书", required = true)
            @RequestBody BookDto book) {
        ValidatorUtils.validateEntity(book);
        bookService.updateBook(book);
        return Result.ok();
    }

    /**
     * 更新状态
     *
     * @param readBook
     * @return
     */
    @ApiOperation(value = "更新状态", nickname = "ArticleController-update-status")
    @PutMapping("/update/status")
    @RequiresPermissions("book:update")
    public Result updateStatus(
            @ApiParam(name = "book", value = "图书", required = true)
            @RequestBody Book readBook) {
        bookService.updateById(readBook);
        return Result.ok();
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除", nickname = "ArticleController-delete")
    @DeleteMapping("/delete")
    @RequiresPermissions("book:delete")
    public Result delete(
            @ApiParam(name = "ids", value = "图书ids", required = true)
            @RequestBody Integer[] ids) {
        bookService.deleteBatch(ids);

        return Result.ok();
    }


}
