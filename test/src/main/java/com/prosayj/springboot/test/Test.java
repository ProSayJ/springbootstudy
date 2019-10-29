package com.prosayj.springboot.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/10/8 下午 02:32
 * @since 1.0.0
 */
public class Test {
    public static void main(String[] args) {
        String abc = "周平均(09.23-09.27)";
        String start = abc.substring(abc.indexOf("(") + 1, 9);
        String end = abc.substring(abc.indexOf("-") + 1, 15);
        System.out.println(start);
        System.out.println(end);

        String startTime = Calendar.getInstance().get(Calendar.YEAR) + start.split("\\.")[0] + start.split("\\.")[1];
        String endtTime =  Calendar.getInstance().get(Calendar.YEAR) + start.split("\\.")[0] + start.split("\\.")[1];

        System.out.println(startTime);
        System.out.println(endtTime);

        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.add(Calendar.MONTH,-1);
        System.out.println("当前月份上个月所在年 = " + new SimpleDateFormat("yyyy-MM-dd").format(now.getTime()));

        //List<LongZhongNewsObjet> list = JSONObject.parseObject(jsoupBody).getJSONArray("list").toJavaList(LongZhongNewsObjet.class);


    }
}
