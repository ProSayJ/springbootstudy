package com.prosayj.springboot.halo.web.controller.admin;

import com.prosayj.springboot.halo.model.domain.Menu;
import com.prosayj.springboot.halo.model.dto.JsonResult;
import com.prosayj.springboot.halo.model.enums.ResultCodeEnum;
import com.prosayj.springboot.halo.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <pre>
 *     后台菜单管理控制器
 * </pre>
 *
 * @author : ProSayJ
 * @date : 2018/1/30
 */
@Slf4j
@Controller
@RequestMapping(value = "/admin/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    /**
     * 渲染菜单设置页面
     *
     * @return 模板路径/admin/admin_menu
     */
    @GetMapping
    public String menus() {
        return "/admin/admin_menu";
    }

    /**
     * 新增/修改菜单
     *
     * @param menu menu
     * @return 重定向到/admin/menus
     */
    @PostMapping(value = "/save")
    @ResponseBody
    public JsonResult saveMenu(@Valid Menu menu, BindingResult result) {
        if (result.hasErrors()) {
            for (ObjectError error : result.getAllErrors()) {
                return new JsonResult(ResultCodeEnum.FAIL.getCode(), error.getDefaultMessage());
            }
        }
        menu = menuService.create(menu);
        if (null != menu) {
            return new JsonResult(ResultCodeEnum.SUCCESS.getCode(), "菜单保存成功！");
        } else {
            return new JsonResult(ResultCodeEnum.FAIL.getCode(), "菜单保存成功！");
        }
    }

    /**
     * 跳转到修改页面
     *
     * @param menuId 菜单编号
     * @param model  model
     * @return 模板路径/admin/admin_menu
     */
    @GetMapping(value = "/edit")
    public String updateMenu(@RequestParam("menuId") Long menuId, Model model) {
        final Menu menu = menuService.fetchById(menuId).orElse(new Menu());
        model.addAttribute("updateMenu", menu);
        return "/admin/admin_menu";
    }

    /**
     * 删除菜单
     *
     * @param menuId 菜单编号
     * @return 重定向到/admin/menus
     */
    @GetMapping(value = "/remove")
    public String removeMenu(@RequestParam("menuId") Long menuId) {
        try {
            menuService.removeById(menuId);
        } catch (Exception e) {
            log.error("Deleting menu failed: {}", e.getMessage());
        }
        return "redirect:/admin/menus";
    }
}
