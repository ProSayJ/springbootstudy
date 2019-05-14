package com.prosayj.springboot.blog.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IOUtils;
import com.prosayj.springboot.blog.auth.service.SysCaptchaService;
import com.prosayj.springboot.blog.auth.service.SysUserTokenService;
import com.prosayj.springboot.blog.core.common.Result;
import com.prosayj.springboot.blog.core.common.base.AbstractController;
import com.prosayj.springboot.blog.core.common.exception.enums.ErrorEnum;
import com.prosayj.springboot.blog.core.entity.sys.SysUser;
import com.prosayj.springboot.blog.core.entity.sys.form.SysLoginForm;
import com.prosayj.springboot.blog.core.mapper.sys.SysUserMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.IOException;


/**
 * @author yangjian
 * @description SysLoginController
 * @Date 16:21 2019/5/10
 * @since 1.0.0
 */
@Api(value = "SysLoginController", tags = "SysLoginController", description = "登陆系统控制器")
@RestController
public class SysLoginController extends AbstractController {

    @Autowired
    private SysCaptchaService sysCaptchaService;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserTokenService sysUserTokenService;

    @ApiOperation(value = "图片验证码", nickname = "SysLoginController-captcha")
    @GetMapping("captcha.jpg")
    public void captcha(HttpServletResponse response,
                        @ApiParam(name = "uuid", value = "随机串",required = true)
                        @Valid @NotNull @NotEmpty  @PathVariable("uuid") String uuid) throws IOException {


        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //获取图片验证码
        BufferedImage image = sysCaptchaService.getCaptcha(uuid);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    @ApiOperation(value = "登陆", nickname = "SysLoginController-admin-sys-login")
    @PostMapping("/admin/sys/login")
    public Result login(
            @ApiParam(name = "loginForm", value = "用户登陆入参")
            @RequestBody SysLoginForm form) {
        boolean captcha = sysCaptchaService.validate(form.getUuid(), form.getCaptcha());
        if (!captcha) {
            // 验证码不正确
            return Result.error(ErrorEnum.CAPTCHA_WRONG);
        }

        // 用户信息
        SysUser user = sysUserMapper.selectOne(new QueryWrapper<SysUser>()
                .lambda()
                .eq(SysUser::getUsername, form.getUsername()));
        if (user == null || !user.getPassword().equals(new Sha256Hash(form.getPassword(), user.getSalt()).toHex())) {
            // 用户名或密码错误
            return Result.error(ErrorEnum.USERNAME_OR_PASSWORD_WRONG);
        }
        if (user.getStatus() == 0) {
            return Result.error("账号已被锁定，请联系管理员");
        }

        //生成token，并保存到redis
        return sysUserTokenService.createToken(user.getUserId());
    }

    /**
     * 退出
     */
    @ApiOperation(value = "登出系统", nickname = "SysLoginController-sys-logout")
    @PostMapping("/sys/logout")
    public Result logout() {
        sysUserTokenService.logout(getUserId());
        return Result.ok();
    }
}
