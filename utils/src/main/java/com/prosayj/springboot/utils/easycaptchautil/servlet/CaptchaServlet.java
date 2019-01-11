package com.prosayj.springboot.utils.easycaptchautil.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prosayj.springboot.utils.easycaptchautil.utils.CaptchaUtil;


/**
 * @author yangjian
 * @description 验证码servlet
 * @email yangjian@bubi.cn
 * @creatTime 2019/1/11 15:26
 * @since 1.0.0
 */
public class CaptchaServlet extends HttpServlet {
    private static final long serialVersionUID = -90304944339413093L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CaptchaUtil.out(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
