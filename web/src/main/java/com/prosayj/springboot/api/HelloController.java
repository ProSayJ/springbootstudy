package com.prosayj.springboot.api;


import com.prosayj.models.user.service.UserService;
import com.prosayj.springboot.api.vo.output.UserVO;
import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.utils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
@Controller
@RequestMapping("/user")
public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_WEB.getModuleNickName());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public @ResponseBody
    List<UserVO> getAllUserList() {
        return BeanUtils.toBeanList(userService.queryAllUser(), UserVO.class);
    }

}
