package com.prosayj.springboot.myblog.api;

import com.prosayj.springboot.myblog.models.tags.domain.TagsDomain;
import com.prosayj.springboot.myblog.models.tags.mapper.TagsDomainMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Api(value = "tag-controller", tags = "tag-controller", description = "tagcontroller")
@Controller
public class TagController {
    @Autowired
    TagsDomainMapper tagsDomainMapper;


    @ApiOperation(value = "taglist", nickname = "tag-controller",notes = "控制器标签页面")
    @GetMapping("/taglist")
    public ModelAndView taglist(ModelAndView mv) {
        List<TagsDomain> all = tagsDomainMapper.getAll();
        mv.addObject("tags",all);
        mv.setViewName("/skins/Pinghsu/tags");
        return mv;
    }


}