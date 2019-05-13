package com.prosayj.springboot.blog.core.entity.book.vo;

import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.BookSense;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.List;

@Data
public class BookVo extends Book {

    /**
     * 所属分类，以逗号分隔
     */
    private String categoryListStr;

    /**
     * 所属标签
     */
    private List<Tag> tagList;

    /**
     * 所属笔记
     */
    private List<BookNote> bookNoteList;

    /**
     * 读后感
     */
    private BookSense bookSense;
}
