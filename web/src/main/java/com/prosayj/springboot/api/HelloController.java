package com.prosayj.springboot.api;


import com.prosayj.springboot.models.user.dto.UserDTO;
import com.prosayj.springboot.models.user.service.UserService;
import com.prosayj.springboot.api.vo.input.UserQuery;
import com.prosayj.springboot.api.vo.output.UserVO;
import com.prosayj.springboot.utils.BeanUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表全量查询", nickname = "user-list")
    public @ResponseBody
    List<UserVO> getAllUserList() {
        return BeanUtils.toBeanList(userService.queryAllUser(), UserVO.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "用户列表全量查询", nickname = "user")
    public ModelAndView getAll() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        List<UserDTO> list = userService.queryAllUser();
        modelAndView.addObject("list", list);
        modelAndView.setViewName("userList");
        return modelAndView;
    }

    @PostMapping(value = "/query")
    @ApiOperation(value = "用户列表条件查询", nickname = "user-query")
    public @ResponseBody
    List<UserVO> queryList(
            @ApiParam(name = "查询实体", value = "实体内容")
            @Valid @RequestBody UserQuery userQuery) {
        return BeanUtils.toBeanList(userService.queryAllUser(), UserVO.class);
    }

}
