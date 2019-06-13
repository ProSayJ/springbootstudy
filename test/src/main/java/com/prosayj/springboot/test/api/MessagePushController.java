package com.prosayj.springboot.test.api;

import com.prosayj.springboot.event.eventcore.event.IEventService;
import com.prosayj.springboot.event.eventcore.event.data.messageevent.SimpleMsgEvent;
import com.prosayj.springboot.websocketutils.WebSocketServer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/9/20 18:25
 * @since 1.0.0
 */
@Api(value = "MessagePush-Controller-controller", tags = "MessagePush-Controller-controller", description = "消息及时推送控制器")
//@Controller
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

    @PostMapping(value = "/pushlist")
    public @ResponseBody
    Map<String,Object> pushVideoListToWeb(@RequestBody Map<String,Object> param) {
        Map<String,Object> result =new HashMap<>();

        try {
//            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:"+CommonUtils.getValue(param, "sltAccountId"));
            WebSocketServer.sendInfo("有新客户呼入,sltAccountId:");
            result.put("operationResult", true);
        }catch (IOException e) {
            result.put("operationResult", true);
        }
        return result;
    }

}
