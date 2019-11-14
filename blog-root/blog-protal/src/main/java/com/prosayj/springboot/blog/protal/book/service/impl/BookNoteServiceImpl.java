package com.prosayj.springboot.blog.protal.book.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.util.Query;
import com.prosayj.springboot.blog.core.entity.book.BookNote;
import com.prosayj.springboot.blog.core.entity.book.vo.BookNoteVo;
import com.prosayj.springboot.blog.core.mapper.book.BookNoteMapper;
import com.prosayj.springboot.blog.manager.operation.service.TagService;
import com.prosayj.springboot.blog.protal.book.service.BookNoteService;
import com.prosayj.springboot.blog.protal.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("BookNotePortalService")
public class BookNoteServiceImpl extends ServiceImpl<BookNoteMapper, BookNote> implements BookNoteService {

    @Autowired
    private TagService tagService;

    @Resource
    private BookService bookService;


    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<BookNoteVo> page = new Query<BookNoteVo>(params).getPage();
        List<BookNoteVo> bookNoteList = baseMapper.queryPageCondition(page, params);
        // 封装BookNoteVo
        Optional.ofNullable(bookNoteList).ifPresent((bookNoteVos ->
                bookNoteVos.forEach(bookNoteVo -> {
                    // 设置标签列表
                    bookNoteVo.setTagList(tagService.listByLinkId(bookNoteVo.getId(), ModuleEnum.BOOK_NOTE.getValue()));
                    // 设置所属书本
                    bookNoteVo.setBook(bookService.getBookVo(bookNoteVo.getBookId()));
                })));
        page.setRecords(bookNoteList);
        return new PageUtils(page);
    }

    /**
     * 获取简单对象
     *
     * @param bookNoteId
     * @return
     */
    @Override
    public BookNoteVo getSimpleBookNoteVo(Integer bookNoteId) {
        BookNoteVo bookNoteVo = baseMapper.getSimpleBookNoteVo(bookNoteId);
        bookNoteVo.setBook(bookService.getBookVo(bookNoteVo.getBookId()));
        return bookNoteVo;
    }

    /**
     * 获取简单List
     *
     * @param bookId
     * @return
     */
    @Override
    public List<BookNote> listSimpleBookNote(Integer bookId) {
        return baseMapper.listSimpleBookNote(bookId);
    }


}
