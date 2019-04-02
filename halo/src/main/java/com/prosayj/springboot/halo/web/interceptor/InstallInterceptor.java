package com.prosayj.springboot.halo.web.interceptor;

import com.prosayj.springboot.halo.model.enums.BlogPropertiesEnum;
import com.prosayj.springboot.halo.model.enums.TrueFalseEnum;
import cn.hutool.core.util.StrUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.prosayj.springboot.halo.model.dto.HaloConst.OPTIONS;

/**
 * <pre>
 *     博客初始化拦截器
 * </pre>
 *
 * @author : ProSayJ
 * @date : 2018/1/28
 */
@Component
public class InstallInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (StrUtil.equals(TrueFalseEnum.TRUE.getDesc(), OPTIONS.get(BlogPropertiesEnum.IS_INSTALL.getProp()))) {
            return true;
        }
        response.sendRedirect("/install");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
