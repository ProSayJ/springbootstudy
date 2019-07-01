package com.prosayj.springbootstudy.api;


import org.springframework.stereotype.Controller;

/**
 * @author yangjian
 * @description 第一个测试类
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/5 16:20
 * @since 1.0.0
 */
//@Api(value = "security-controller", tags = "security-controller", description = "图形验证码测试类")
@Controller
public class SecurityCodeController {/*
    @GetMapping("/index")
    public String index() {
        return "index";
    }

    *//**
     * 验证图形验证码
     *
     * @param username
     * @param password
     * @param code
     *//*
    @PostMapping("/login")
    public void login(String username, String password, String code) {
        HttpServletRequest request = null;
        if (!CaptchaUtil.ver(code, request)) {
            CaptchaUtil.clear(request);
        }
    }


    @GetMapping("/images/captcha1")
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


    @GetMapping("/images/captcha3")
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

    @GetMapping("/login2")
    public void login2(String username, String password, String code) {
        HttpServletRequest request = null;
        // 获取session中的验证码
        String sessionCode = (String) request.getSession().getAttribute("captcha");
        // 判断验证码
        if (code == null || !sessionCode.equals(code.trim().toLowerCase())) {
        }
    }
*/

}
