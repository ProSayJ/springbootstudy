package com.prosayj.springboot.blog.core.common.mq.aspect;

import com.prosayj.springboot.blog.core.common.constants.RabbitMqConstants;
import com.prosayj.springboot.blog.core.common.util.RabbitMqUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * @description
 * @author yangjian
 * @Date 16:20 2019/5/10
 * @since 1.0.0
 */
@Aspect
@Component
public class RefreshEsMqAspect {

    @Resource
    private RabbitMqUtils rabbitMqUtils;

    @Pointcut("@annotation(com.prosayj.springboot.blog.core.common.mq.annotation.RefreshEsMqSender)")
    public void pointCut() {

    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        //执行方法
        Object result = point.proceed();
        // 发送刷新信息
        rabbitMqUtils.send(RabbitMqConstants.REFRESH_ES_INDEX_QUEUE,"send refresh Es");
        return result;
    }
}
