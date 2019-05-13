package com.prosayj.springboot.blog.protal.book.controller;

import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.protal.book.service.BookNoteService;
import com.prosayj.springboot.blog.protal.common.annotation.LogLike;
import com.prosayj.springboot.blog.protal.common.annotation.LogView;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController("bookNotePortalController")
public class BookNoteController {

    @Resource
    private BookNoteService bookNoteService;


    @GetMapping("/bookNote/{bookNoteId}")
    @LogView(type = "bookNote")
    public Result getBookNote(@PathVariable Integer bookNoteId) {
        BookNote bookNote = bookNoteService.getById(bookNoteId);
        return Result.ok().put("bookNote", bookNote);
    }

    @GetMapping("/bookNotes")
    public Result listLatest(@RequestParam Map<String, Object> params) {
        PageUtils page = bookNoteService.queryPageCondition(params);
        return Result.ok().put("page", page);
    }

    @PutMapping("/bookNote/like/{id}")
    @LogLike(type = "bookNote")
    public Result likeBookNote(@PathVariable Integer id) {
        return Result.ok();
    }


}
