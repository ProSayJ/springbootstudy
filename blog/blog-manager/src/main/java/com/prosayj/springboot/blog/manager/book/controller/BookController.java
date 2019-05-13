package com.prosayj.springboot.blog.manager.book.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.validator.ValidatorUtils;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.dto.BookDto;
import com.prosayj.springboot.blog.manager.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 图书表 前端控制器
 * </p>
 */
@RestController
@Slf4j
@RequestMapping("/admin/book")
public class BookController extends AbstractController {
    @Autowired
    private BookService bookService;

    /**
     * 列表
     */
    @GetMapping("/list")
    @RequiresPermissions("book:list")
    public Result list(@RequestParam Map<String, Object> params) {
        PageUtils page = bookService.queryPage(params);

        return Result.ok().put("page", page);
    }

    /**
     * 列表
     */
    @GetMapping("/select")
    @RequiresPermissions("book:list")
    public Result select() {
        List<Book> bookList = bookService.list(null);
        return Result.ok().put("bookList", bookList);
    }


    /**
     * 信息
     */
    @GetMapping("/info/{id}")
    @RequiresPermissions("book:info")
    public Result info(@PathVariable("id") String id) {
        BookDto book = bookService.getBook(id);
        return Result.ok().put("book", book);
    }

    /**
     * 保存
     */
    @PostMapping("/save")
    @RequiresPermissions("book:save")
    public Result save(@RequestBody BookDto book) {
        ValidatorUtils.validateEntity(book);
        bookService.saveBook(book);

        return Result.ok();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    @RequiresPermissions("book:update")
    public Result update(@RequestBody BookDto book) {
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
    @PutMapping("/update/status")
    @RequiresPermissions("book:update")
    public Result updateStatus(@RequestBody Book readBook) {
        bookService.updateById(readBook);
        return Result.ok();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete")
    @RequiresPermissions("book:delete")
    public Result delete(@RequestBody Integer[] ids) {
        bookService.deleteBatch(ids);

        return Result.ok();
    }


}
