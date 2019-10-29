package com.prosayj.springboot.test.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.prosayj.springboot.test.model.AllData;
import com.prosayj.springboot.test.model.ChartType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangjian
 * @description 文章控制器
 * @email yangjian@bubi.cn
 * @creatTime 2019/3/12 10:57
 * @since 1.0.0
 */
@Api(value = "test-controller", tags = "test-controller", description = "测试controller")
@Controller
@RequestMapping("/test")
public class TestController {

    @PostMapping("/idlist")
    public void getIdsist(@RequestBody List<Long> ids) {
        System.out.println(ids);
    }


    @ApiOperation(value = "测试")
    @PostMapping("/getall")
    public void articlelist(@RequestParam("dataString") String dataString) {
        System.out.println(dataString);
        List<JSONObject> jsonObjects = JSONArray.parseArray(dataString).toJavaList(JSONObject.class);
        System.out.println(jsonObjects.toString());

    }

    @ApiOperation(value = "测试Thread获得的到底是谁的锁？是当前实例对象的锁？")
    @GetMapping("/mul")
    @ResponseBody
    public Object mul() {
        System.out.println("哈哈哈");
        try {
            Thread.sleep(5000L);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        List<AllData> allDatats = getAllDatats();
        String toJSONString = JSONObject.toJSONString(allDatats);
        System.out.println(toJSONString);
        List<AllData> jsonObjects = JSONArray.parseArray(toJSONString).toJavaList(AllData.class);
        System.out.println(jsonObjects.toString());
        return jsonObjects;
    }


    private static List<AllData> getAllDatats() {
        List<AllData> allDatas = new ArrayList<>();

        AllData allData = new AllData();
        List<ChartType> chartTypes = new ArrayList<>();
        chartTypes.add(new ChartType("WTI", "bar"));
        chartTypes.add(new ChartType("布伦特期货", "bar"));
        chartTypes.add(new ChartType("迪拜现货", "line"));
        chartTypes.add(new ChartType("布伦特现货", "line"));
        chartTypes.add(new ChartType("布伦特-迪拜", "bar"));
        chartTypes.add(new ChartType("布伦特-WTI", "bar"));
        chartTypes.add(new ChartType("三种油自然月", "bar"));
        allData.setId("113");
        allData.setPageNo(1);
        allData.setPptName("国际市场情况");
        allData.setPptType("chart");
        allData.setChartTypes(chartTypes);

        AllData allData2 = new AllData();
        allData2.setChartTypes(null);
        allData2.setId("115");
        allData2.setPageNo(2);
        allData2.setPptName("国际市场价格情况");
        allData2.setPptType("table");

        allDatas.add(allData);
        allDatas.add(allData2);
        return allDatas;
    }
}