package com.prosayj.springboot.blog.core.entity.book.dto;

import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.List;


@Data
public class BookDto extends Book {

    List<Tag> tagList;
}
