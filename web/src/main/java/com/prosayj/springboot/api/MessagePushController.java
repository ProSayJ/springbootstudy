package com.prosayj.springboot.api;

import com.prosayj.eventsubscription.service.MessageService;
import com.prosayj.springboot.event.eventcore.event.IEventService;
import com.prosayj.springboot.event.eventcore.event.data.messageevent.MessageEvent;
import com.prosayj.springboot.event.eventcore.event.data.messageevent.SimpleMsgEvent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/20 18:25
 * @since 1.0.0
 */
@Api(value = "MessagePush-Controller-controller", tags = "MessagePush-Controller-controller", description = "消息及时推送控制器")
@Controller
@RequestMapping("/msg")
public class MessagePushController {
    @Autowired
    private IEventService iEventService;

    @ApiOperation("发送")
    @GetMapping("/send/{msg}")
    public @ResponseBody
    Boolean sendMsg(@PathVariable("msg") String message) {
        iEventService.publish(new SimpleMsgEvent(message));
        return Boolean.TRUE;
    }

    @ApiOperation("长连接接收")
    @GetMapping("/get")
    public void sendMsg() {
    }
}
