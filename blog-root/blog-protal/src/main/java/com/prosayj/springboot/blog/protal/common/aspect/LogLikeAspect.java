package com.prosayj.springboot.blog.protal.common.aspect;

import com.prosayj.springboot.blog.core.common.util.HttpContextUtils;
import com.prosayj.springboot.blog.core.common.util.IPUtils;
import com.prosayj.springboot.blog.core.common.util.JsonUtils;
import com.prosayj.springboot.blog.core.mapper.article.ArticleMapper;
import com.prosayj.springboot.blog.core.mapper.book.BookMapper;
import com.prosayj.springboot.blog.core.mapper.book.BookNoteMapper;
import com.prosayj.springboot.blog.core.mapper.log.LogLikeMapper;
import com.prosayj.springboot.blog.protal.common.annotation.LogLike;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.time.LocalDateTime;

/**
 * ViewLogAspect
 */
@Aspect
@Component
@Slf4j
public class LogLikeAspect {

    @Autowired
    private LogLikeMapper logLikeMapper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookNoteMapper bookNoteMapper;

    @Pointcut("@annotation(com.prosayj.springboot.blog.protal.common.annotation.LogLike)")
    public void logPointCut() {

    }

    @Around("logPointCut()")
    @Transactional(rollbackFor = Exception.class)
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        //保存日志
        saveLogLike(point, time);

        return result;
    }

    private void saveLogLike(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        com.prosayj.springboot.blog.core.entity.log.LogLike logLikeEntity = new com.prosayj.springboot.blog.core.entity.log.LogLike();
        LogLike viewLog = method.getAnnotation(LogLike.class);
        //注解上的类型
        String type = viewLog.type();
        logLikeEntity.setType(type);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        String id = JsonUtils.toJson(args[0]);
        // 根据注解类型增加数量
        switch (type) {
            case "article":
                articleMapper.updateLikeNum(Integer.parseInt(id));
                break;
            case "book":
                bookMapper.updateLikeNum(Integer.parseInt(id));
                break;
            case "bookNote":
                bookNoteMapper.updateLikeNum(Integer.parseInt(id));
                break;
            default:
                break;
        }
        logLikeEntity.setParams(id);
        //获取request
        HttpServletRequest request = HttpContextUtils.getHttpServletRequest();
        //设置IP地址
        logLikeEntity.setIp(IPUtils.getIpAddr(request));
        logLikeEntity.setTime(time);
        logLikeEntity.setCreateDate(LocalDateTime.now());
        logLikeMapper.insert(logLikeEntity);

    }
}
