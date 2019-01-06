package com.prosayj.springboot.spring_annotation.controller;

import com.prosayj.springboot.spring_annotation.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author yangjian
 * @description
 * @Date 23:44 2018/9/24
 * @since 1.0.0
 */
@Controller
public class BookController {

    @Autowired
    private BookService bookService;

}
