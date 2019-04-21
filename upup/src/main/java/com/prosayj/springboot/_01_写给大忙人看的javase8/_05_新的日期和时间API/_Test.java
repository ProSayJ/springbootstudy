package com.prosayj.springboot._01_写给大忙人看的javase8._05_新的日期和时间API;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/8/20 1:22
 * @since 1.0.0
 */
public class _Test {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(now);
        LocalDate now1 = LocalDate.now();
        System.out.println(now1.atStartOfDay().format(DateTimeFormatter.ISO_DATE));
    }
}
