package com.prosayj.springboot.log.aspect;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.prosayj.springboot.constants.LoggerModelEnum;
import com.prosayj.springboot.log.LogInfo;
import com.prosayj.springboot.log.aspect.model.PayPassWordRequestHeader;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;


/**
 * @author yangjian
 * @description 日志切面
 * @email yangjian@bubi.cn
 * @creatTime 2019/6/12 10:19
 * @since 1.0.0
 */
@Aspect
@Service
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LoggerModelEnum.PROSAYJ_MYBLOG.getModuleNickName());
    private static Set<MediaType> ignoreMediaType = new HashSet<MediaType>() {{
        add(MediaType.APPLICATION_OCTET_STREAM);
        add(MediaType.APPLICATION_PDF);
        add(MediaType.IMAGE_JPEG);
        add(MediaType.IMAGE_GIF);
        add(MediaType.IMAGE_PNG);
    }};

    /**
     * 定义日志切入点
     */
    @Pointcut("execution(* com.prosayj.springboot.myblog.api..*.*(..))" +
            "|| execution(* com.prosayj.springboot.myblog.api.*.*(..))" +
            "&& @within(org.springframework.web.bind.annotation.RequestMapping)")
    public void serviceAspect() {
    }

    /**
     * 前置通知 用于拦截service层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("serviceAspect()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        LogInfo loginInfo = getLoginInfo(joinPoint, false);
        logger.info("log before:" + JSONObject.toJSONString(loginInfo));
        // 交易密码
        checkTxSecurityToken(joinPoint);

    }

    /**
     * 后置通知 用于拦截service层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "serviceAspect() ", returning = "returnValue")
    public void doAfter(JoinPoint joinPoint, Object returnValue) {
        LogInfo loginInfo = getLoginInfo(joinPoint, false);
        if (returnValue != null) {
            if (returnValue instanceof ResponseEntity) {
                ResponseEntity responseEntity = (ResponseEntity) returnValue;
                MediaType mediaType = responseEntity.getHeaders().getContentType();

                if (ignoreMediaType.contains(mediaType)) {
                    loginInfo.setReturnStr("log print filter file");
                } else {
                    loginInfo.setReturnStr(JSONObject.toJSONString(returnValue));
                }
            } else {
                loginInfo.setReturnStr(returnValue.toString());
            }
        }
        logger.info("log return:" + JSONObject.toJSONString(loginInfo));
    }


    /**
     * 获取上下文信息
     *
     * @param joinPoint
     * @param needUser
     * @return
     */
    private LogInfo getLoginInfo(JoinPoint joinPoint, boolean needUser) {
        // 记录请求日志
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 获取被拦截的方法
        Method method = signature.getMethod();
        String methodName = method.getName();
        LogInfo logInfo = new LogInfo();
        logInfo.setCreateTime(new Date());
        logInfo.setFunction(method.getDeclaringClass() + "." + methodName);
        logInfo.setParamStr(getParamString(joinPoint));
        if (!needUser) {
            logInfo.setUser(null);

        } else {
            //TODO
        }
        return logInfo;
    }


    /**
     * 检验交易密码
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    private void checkTxSecurityToken(JoinPoint joinPoint) throws Exception {
        Method method = getMethod(joinPoint);
        Object[] objects = joinPoint.getArgs();
        Parameter[] params = method.getParameters();
        for (int i = 0; i < params.length; i++) {
            RequestHeader requestHeader = params[i].getAnnotation(RequestHeader.class);
            if (requestHeader == null) {
                continue;
            }
            //校验支付密码
        }
    }

    /**
     * 内部服务之间密码要密文传输 此处不再解密
     * 由user服务解密
     *
     * @return 支付密码密文 公钥
     */
    private Map<String, String> getPayPsw(String requestHeader) {
        String pubKey = null;
        String payPassWord = requestHeader;
        Map<String, String> map = new HashMap<>(2);
        try {
            PayPassWordRequestHeader payPassWordRequestHeader = JSONObject.parseObject(requestHeader,
                    PayPassWordRequestHeader.class);
            pubKey = payPassWordRequestHeader.getPubKey();
            payPassWord = payPassWordRequestHeader.getTxPsw();
        } catch (Exception e) {
            logger.warn("Request header was wrong,please check the request header.");
        }
        if (StringUtils.isEmpty(payPassWord)) {
            //支付密码不能为空
        }
        map.put("pubKey", pubKey);
        map.put("payPassWord", payPassWord);
        return map;
    }


    private Method getMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        return methodSignature.getMethod();
    }

    private String getParamString(JoinPoint joinPoint) {
        JSONArray jsonArray = new JSONArray();
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return jsonArray.toJSONString();
        }
        for (Object arg : args) {
            if (arg instanceof HttpServletRequest || arg instanceof HttpServletResponse) {
                continue;
            }
            jsonArray.add(arg);
        }
        return jsonArray.toJSONString();
    }

}
