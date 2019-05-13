package com.prosayj.springboot.blog.core.mapper.book;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.prosayj.springboot.blog.core.entity.book.BookSense;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 读后感 Mapper 接口
 * </p>
 */
@Mapper
public interface BookSenseMapper extends BaseMapper<BookSense> {

}
