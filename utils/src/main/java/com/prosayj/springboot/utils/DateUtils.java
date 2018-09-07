package com.prosayj.springboot.utils;

import com.prosayj.springboot.constants.DatePattern;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author yangjian
 * @description 日期工具类
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/30 16:20
 * @since 1.0.0
 */
public class DateUtils {

    public static final Calendar calendar = new GregorianCalendar();

    /**
     * 将Date类型日期格式化为字符串类型日期
     *
     * @param date    Date
     * @param pattern 枚举
     * @return
     */
    public static String formatDateToString(Date date, DatePattern pattern) {
        return new SimpleDateFormat(pattern.pVal).format(date);
    }

    /**
     * 将Date类型日期格式化为字符串类型日期
     *
     * @param pattern
     * @return
     */
    public static String formatCurrentDateToString(DatePattern pattern) {
        return new SimpleDateFormat(pattern.pVal).format(new Date());
    }

    /**
     * 将字符串类型日期格式化为Date类型日期
     *
     * @param strDate 字符串类型日期
     * @param pattern 枚举
     * @return
     */
    public static Date formatStringToDate(String strDate, DatePattern pattern) {
        try {
            return new SimpleDateFormat(pattern.pVal).parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获得当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        return new Date();
    }

    /**
     * 获取当前时间，以从历元至现在所经过的 UTC 毫秒数形式。
     *
     * @return
     */
    public static Long getCurrentMillis() {
        return Calendar.getInstance().getTimeInMillis();
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getCurrentChDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);
        StringBuffer bf = new StringBuffer();
        bf.append(year).append("年").append(month + 1).append("月").append(day).append("日").append(hour).append("时")
                .append(min).append("分").append(sec).append("秒");
        return bf.toString();
    }

    /**
     * 指定天数 N天后的时间
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date getAddDate(Date date, Integer addDay) {
        calendar.setTime(date);
        calendar.add(calendar.DATE, addDay);
        date = calendar.getTime();
        return date;
    }

    /**
     * 指定天数 N月后的时间
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date getAddDateMonth(Date date, Integer addMonth) {
        calendar.setTime(date);
        calendar.add(calendar.MONTH, addMonth);
        date = calendar.getTime();
        return date;
    }

    /**
     * 得到本月第一天的日期
     *
     * @return Date
     * @Methods Name getFirstDayOfMonth
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, 1);
        return cDay.getTime();
    }

    /**
     * 得到本月最后一天的日期
     *
     * @return Date
     * @Methods Name getLastDayOfMonth
     */
    public static Date getLastDayOfMonth(Date date) {
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(date);
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cDay.getTime();
    }


    /**
     * 计算两个日期之间相差的天数
     *
     * @param startDate 较小的时间
     * @param endDate   较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static int daysBetween(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.Y_M_D.pVal);
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    /**
     * 计算两个日期之间相差的秒数
     *
     * @param startDate 较小的时间
     * @param endDate   较大的时间
     * @return 相差天数
     * @throws ParseException
     */
    public static long daysBetweenM(Date startDate, Date endDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.Y_M_D_H_M_S.pVal);
        startDate = sdf.parse(sdf.format(startDate));
        endDate = sdf.parse(sdf.format(endDate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(endDate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1);

        return between_days;
    }


    /**
     * 得到当天时间的最后一秒
     *
     * @return Date
     * @throws ParseException
     * @Methods Name getLastSecond
     */
    public static Date getLastSecond(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DatePattern.Y_M_D.pVal);
            SimpleDateFormat sdfm = new SimpleDateFormat(DatePattern.Y_M_D_H_M_S.pVal);
            Calendar cDay = Calendar.getInstance();
            cDay.setTime(sdfm.parse(sdf.format(date) + " 23:59:59"));
            return cDay.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @description 获取当天的0时的毫秒值
     * @author yangjian
     * @Date 16:37 2018/4/10
     * @since 1.0.0
     */
    public static long getFirstSeconds(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime().getTime();
    }

    /**
     * @description 获取当天的最后一毫秒值
     * @author yangjian
     * @Date 16:34 2018/4/10
     * @since 1.0.0
     */
    public static Long getLastSeconds(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime().getTime();
    }

    /**
     * @description 获取当前时间距离当天最后一秒的时间(分)
     * @author yangjian
     * @Date 14:14 2018/5/24
     * @since 1.0.0
     */
    public static Long getMinuteFromNow(Date date) {
        return (getLastSeconds(date) - System.currentTimeMillis()) / 1000 / 60;
    }

    /**
     * @description 获取指定毫秒值指定时间前的毫秒值
     * @author yangjian
     * @Date 17:14 2018/4/10
     * @since 1.0.0
     */
    public static long getBetweenSeconds(long startTime, int minute) {
        return startTime - minute * 60 * 1000;
    }

    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        System.out.println(DateUtils.getAddDate(DateUtils.getLastSecond(new Date()), 1));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cDay = Calendar.getInstance();
        cDay.setTime(sdfm.parse(sdf.format(date) + " 23:59:59"));
        cDay.set(Calendar.DAY_OF_MONTH, cDay.getActualMaximum(Calendar.DAY_OF_MONTH));


        Calendar end = Calendar.getInstance();
        Date formatStringToDate = DateUtils.formatStringToDate("2017-07-05 10:52:07", DatePattern.Y_M_D_H_M_S);
        System.out.println("===" + DateUtils.formatDateToString(formatStringToDate, DatePattern.Y_M_D_H_M_S));
        end.setTime(formatStringToDate);

        System.out.println("===between==" + DateUtils.daysBetween(new Date(), formatStringToDate));

        System.out.println("yyyy-MM-dd HH:mm:ss==" + DateUtils.formatCurrentDateToString(DatePattern.Y_M_D_H_M_S));
        System.out.println("YYYYMMDDHHmmss==" + DateUtils.formatCurrentDateToString(DatePattern.Y_M_D_H_M_S));

        System.out.println(DateUtils.formatCurrentDateToString(DatePattern.Y_M_D_H_M_S));

        String time = "20170720121211";
        Date formatStringToDate2 = DateUtils.formatStringToDate(time, DatePattern.Y_M_D_H_M_S);
        String formatDateToString = DateUtils.formatDateToString(formatStringToDate2, DatePattern.Y_M_D_H_M_S);
        System.out.println("formatStringToDate2==" + formatStringToDate2);
        System.out.println("formatDateToString==" + formatDateToString);


    }


}
