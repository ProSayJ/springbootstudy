package com.prosayj.springboot.blog.protal.book.controller;


import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.vo.BookVo;
import com.prosayj.springboot.blog.protal.book.service.BookService;
import com.prosayj.springboot.blog.protal.common.annotation.LogLike;
import com.prosayj.springboot.blog.protal.common.annotation.LogView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 文章 前端控制器
 * </p>
 */
@RestController("bookPortalController")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book/{bookId}")
    @LogView(type = "book")
    public Result getBook(@PathVariable Integer bookId) {
        BookVo book = bookService.getBookVo(bookId);
        return Result.ok().put("book", book);
    }

    @GetMapping("/books")
    public Result listLatest(@RequestParam Map<String, Object> params) {
        PageUtils page = bookService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

    @PutMapping("/book/like/{id}")
    @LogLike(type = "book")
    public Result likeBook(@PathVariable Integer id) {
        return Result.ok();
    }


}
