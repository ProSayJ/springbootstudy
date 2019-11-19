package com.prosayj.springboot.toword.controller;

import com.prosayj.springboot.toword.dto.Table;
import com.prosayj.springboot.toword.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/11/19 下午 05:34
 * @since 1.0.0
 */
public class WordController {
    @Autowired
    private WordService tableService;


    /** @deprecated */
    @Deprecated
    @RequestMapping({"/toWord"})
    public String getWord(Model model, @RequestParam(value = "url",required = false) String url) {
        Map<String, List<Table>> tables = this.tableService.tableList(url);
        model.addAttribute("maps", tables);
        return "word";
    }
}
