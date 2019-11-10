package com.prosayj.springboot.security.web.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;


/**
 * @description 线程之间传递对象
 * @author yangjian
 * @Date 下午 11:07 2019/11/10
 * @since 1.0.0
 */
@Component
public class DeferredResultHolder {

    //订单号：订单处理结果
    private Map<String, DeferredResult<String>> map = new HashMap<String, DeferredResult<String>>();

    public Map<String, DeferredResult<String>> getMap() {
        return map;
    }

    public void setMap(Map<String, DeferredResult<String>> map) {
        this.map = map;
    }

}
