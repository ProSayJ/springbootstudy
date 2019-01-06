package com.prosayj.springboot.spring_annotation.service;


import javax.annotation.Resource;
import javax.inject.Inject;

import com.prosayj.springboot.spring_annotation.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;



@Service
public class BookService {

	//@Qualifier("bookDao")
	//@Autowired(required=false)
	//@Resource(name="bookDao2")
	@Inject
	private BookDao bookDao;

	public void print(){
		System.out.println(bookDao);
	}

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDao + "]";
	}


}
