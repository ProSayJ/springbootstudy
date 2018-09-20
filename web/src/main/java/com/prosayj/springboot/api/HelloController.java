package com.prosayj.springboot.api;


import com.prosayj.models.user.service.UserService;
import com.prosayj.springboot.api.vo.output.UserVO;
import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
@Api(value = "hello-controller", tags = "hello-controller", description = "测试类")
@Controller
@RequestMapping("/user")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_WEB.getModuleNickName());

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户列表全量查询", nickname = "user-list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    List<UserVO> getAllUserList() {
        return BeanUtils.toBeanList(userService.queryAllUser(), UserVO.class);
    }

    @PostMapping(value = "/query")
    public @ResponseBody
    List<UserVO> queryList() {
        return BeanUtils.toBeanList(userService.queryAllUser(), UserVO.class);
    }


    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "张三");
        modelAndView.setViewName("hello");
        return modelAndView;
    }


}
