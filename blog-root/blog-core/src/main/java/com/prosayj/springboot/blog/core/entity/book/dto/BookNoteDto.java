package com.prosayj.springboot.blog.core.entity.book.dto;

import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.operation.Tag;
import lombok.Data;

import java.util.List;


@Data
public class BookNoteDto extends BookNote {

    private List<Tag> tagList;

}
