package com.prosayj.springboot.api;


import com.prosayj.springboot.models.user.dto.UserDTO;
import com.prosayj.springboot.models.user.service.UserService;
import com.prosayj.springboot.api.vo.input.UserQuery;
import com.prosayj.springboot.api.vo.output.UserVO;
import com.prosayj.springboot.utils.BeanUtil;
import com.prosayj.springboot.utils.easycaptchautil.Captcha;
import com.prosayj.springboot.utils.easycaptchautil.GifCaptcha;
import com.prosayj.springboot.utils.easycaptchautil.utils.CaptchaUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.awt.*;
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
        return BeanUtil.toBeanList(userService.queryAllUser(), UserVO.class);
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
        return BeanUtil.toBeanList(userService.queryAllUser(), UserVO.class);
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 验证图形验证码
     *
     * @param username
     * @param password
     * @param code
     */
    @PostMapping("/login")
    public void login(String username, String password, String code) {
        HttpServletRequest request = null;
        if (!CaptchaUtil.ver(code, request)) {
            CaptchaUtil.clear(request);
        }
    }


    @RequestMapping("/images/captcha1")
    public void captcha1(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @GetMapping("/images/captcha2")
    public void captcha2(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置位数
        CaptchaUtil.out(5, request, response);

        // 设置宽、高、位数
        CaptchaUtil.out(130, 48, 5, request, response);
    }


    @RequestMapping("/images/captcha3")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 设置请求头为输出图片类型
        CaptchaUtil.setHeader(response);

        // 三个参数分别为宽、高、位数
        GifCaptcha gifCaptcha = new GifCaptcha(130, 48, 5);

        // 设置字体
        gifCaptcha.setFont(new Font("Verdana", Font.PLAIN, 32));  // 有默认字体，可以不用设置

        // 设置类型，纯数字、纯字母、字母数字混合
        gifCaptcha.setCharType(Captcha.TYPE_ONLY_NUMBER);

        // 验证码存入session
        request.getSession().setAttribute("captcha", gifCaptcha.text().toLowerCase());

        // 输出图片流
        gifCaptcha.out(response.getOutputStream());
    }

    @PostMapping("/login2")
    public void login2(String username, String password, String code) {
        HttpServletRequest request = null;
        // 获取session中的验证码
        String sessionCode = (String) request.getSession().getAttribute("captcha");
        // 判断验证码
        if (code == null || !sessionCode.equals(code.trim().toLowerCase())) {
        }
    }


}
