package com.prosayj.springboot.blog.protal.book.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.prosayj.springboot.blog.core.common.enums.ModuleEnum;
import com.prosayj.springboot.blog.core.common.util.PageUtils;
import com.prosayj.springboot.blog.core.common.util.Query;
import com.prosayj.springboot.blog.core.entity.book.Book;
import com.prosayj.springboot.blog.core.entity.book.vo.BookVo;
import com.prosayj.springboot.blog.core.mapper.book.BookMapper;
import com.prosayj.springboot.blog.manager.book.service.BookSenseService;
import com.prosayj.springboot.blog.manager.operation.service.TagService;
import com.prosayj.springboot.blog.protal.book.service.BookNoteService;
import com.prosayj.springboot.blog.protal.book.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * <p>
 * 图书表 服务实现类
 * </p>
 */
@Service("bookPortalService")
@Slf4j
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Resource
    private TagService tagService;

    @Resource
    private BookSenseService bookSenseService;

    @Resource
    private BookNoteService bookNoteService;

    /**
     * 分页分类获取列表
     *
     * @param params
     * @return
     */
    @Override
    public PageUtils queryPageCondition(Map<String, Object> params) {
        Page<BookVo> page = new Query<BookVo>(params).getPage();
        List<BookVo> bookList = baseMapper.queryPageCondition(page, params);
        if (!CollectionUtils.isEmpty(bookList)) {
            bookList.forEach(bookVo -> {
                // 设置标签列表
                bookVo.setTagList(tagService.listByLinkId(bookVo.getId(), ModuleEnum.BOOK.getValue()));
            });
        }

        page.setRecords(bookList);
        return new PageUtils(page);
    }

    /**
     * 获取Book对象
     *
     * @param id
     * @return
     */
    @Override
    public BookVo getBookVo(Integer id) {
        BookVo book = Optional.ofNullable(this.baseMapper.selectById(id)).flatMap(book1 -> {
            BookVo bookVo = new BookVo();
            BeanUtils.copyProperties(book1, bookVo);
            return Optional.ofNullable(bookVo);
        }).map(bookVo -> {
            bookVo.setTagList(tagService.listByLinkId(bookVo.getId(), ModuleEnum.BOOK.getValue()));
            bookVo.setBookNoteList(bookNoteService.listSimpleBookNote(bookVo.getId()));
            bookVo.setBookSense(bookSenseService.getBookSense(bookVo.getId()));
            return bookVo;
        }).orElse(null);
        return book;
    }
}
