package com.prosayj.springboot.myblog.api;

import com.prosayj.springboot.myblog.api.vo.input.IdVO;
import com.prosayj.springboot.myblog.api.vo.output.ArticleVO;
import com.prosayj.springboot.myblog.models.dto.TagsDTO;
import com.prosayj.springboot.myblog.service.ArticleService;
import com.prosayj.springboot.myblog.service.TagService;
import com.prosayj.springboot.utils.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/11 13:28
 * @since 1.0.0
 */
@Api(value = "static-jump-controller", tags = "static-jump-controller", description = "静态资源跳转类")
@Controller
public class StaticJumpController {



    @ApiOperation(value = "首页")
    @GetMapping("/index")
    public String index() {
        return "freemark/index";
    }


    @ApiOperation(value = "文章详情")
    @GetMapping("/articedetail")
    public String articedetail() {
        return "freemark/articedetail";
    }

    @ApiOperation(value = "归档")
    @GetMapping("/archives")
    public String archives() {
        return "freemark/archives";
    }

    @ApiOperation(value = "分类")
    @GetMapping("/categories")
    public String categories() {
        return "freemark/categories";
    }






    @ApiOperation(value = "登陆跳转", nickname = "static-jump-controller")
    //@GetMapping("/")
    public String root() {
//        return "redirect:/login";
        return "redirect:/taglist";
    }


    @ApiOperation(value = "登陆", nickname = "static-jump-controller-login")
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @ApiOperation(value = "注册", nickname = "static-jump-controller-register")
    @GetMapping("/register")
    public String register() {
        return "register";
    }


    @ApiOperation(value = "新建文章", nickname = "static-jump-controller-create")
    @GetMapping("/create")
    public String create() {
        return "redirect:/article/create";
    }


    @ApiOperation(value = "文章预览", nickname = "static-jump-controller-preview")
    @GetMapping("/preview")
    public ModelAndView preview(IdVO idVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("freemark/preview");
        modelAndView.addObject("previewId", idVO.getId());
        return modelAndView;
    }

    @ApiOperation(value = "文章编辑", nickname = "static-jump-controller-editor")
    @GetMapping("/editor")
    public ModelAndView editor(IdVO idVO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("freemark/editor");
        modelAndView.addObject("editorId", idVO.getId());
        return modelAndView;
    }

    @ApiOperation(value = "example", nickname = "static-jump-controller-example")
    @GetMapping("/example")
    public String example() {
        return "freemark/example";
    }

    @ApiOperation(value = "注册", nickname = "static-jump-controller-register")
    @GetMapping("/article/register.html")
    public String registerIframe() {
        return "freemark/register";
    }

    @ApiOperation(value = "articlelistbytagid", nickname = "static-jump-controller-articlelistbytagid")
    @GetMapping("/articlelistbytagid")
    public String registerIframe(IdVO idVO, RedirectAttributes model) {
        model.addFlashAttribute("id", idVO.getId());
        return "redirect:/article/list/articlelistbytagid";
    }
}
