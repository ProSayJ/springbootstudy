package com.prosayj.springboot.java数据结构.leetcode;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayJ@gmail.cn
 * @creatTime 2019/9/27 上午 11:00
 * @since 1.0.0
 */
public class Tets02 {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MONTH, -2); //当前月的上个月负数为上个月                                                                                           的下个月）
        System.out.println(new SimpleDateFormat("yyyyMM").format(cal.getTime()));

    }
}
