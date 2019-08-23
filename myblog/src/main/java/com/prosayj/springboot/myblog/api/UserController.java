package com.prosayj.springboot.myblog.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


/**
 * @author yangjian
 * @description 用户控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/11 13:34
 * @since 1.0.0
 */
@Api(value = "user-controller", tags = "user-controller", description = "userController")
@Controller
public class UserController {
    /**
     * 处理跳转到登录页的请求
     *
     * @param session session
     * @return 模板路径admin/admin_login
     */
    //@GetMapping(value = "/login")
    public ModelAndView login(HttpSession session, ModelAndView mv) {
       /* final User user = (User) session.getAttribute(USER_SESSION_KEY);
        //如果session存在，跳转到后台首页
        if (null != user) {

        }
        return "admin/admin_login";
    }
    mv.
    return "redirect:/admin";*/
        mv.addObject("blog_title","ProSayJ的博客");
       mv.setViewName("admin/my/admin_login");
        return mv;
    }


}