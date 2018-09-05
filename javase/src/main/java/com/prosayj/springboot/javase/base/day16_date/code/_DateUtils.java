package com.prosayj.springboot.javase.base.day16_date.code;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangjian
 * @description TODO
 * @email yangjian@bubi.cn
 * @creatTime 2018/1/16 9:32AtomicBoolean
 * @since 1.0.0
 */
public class _DateUtils {
    public static void main(String[] args) {
        printDate(1516705545718L);
    }


    public static void printDate(Long timesstap) {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:sss").format(new Date(timesstap)));
    }
}
