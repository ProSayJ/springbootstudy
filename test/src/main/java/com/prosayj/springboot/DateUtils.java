package com.prosayj.springboot;

import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.*;

/**
 * 时间工具类 2019/12/4 下午 12:51
 *
 * @author yangjian
 * @since 1.0.0
 */
public class DateUtils {
    public static void main(String[] args) {
        //2.	获取当前天所在月的上周一和上周五的时间，有几周就获取几周（1组或2组或3组或4组）
        System.out.println(getMondayAndFridayFullMonth(new Date()));
        //3.	获取上月月初时间和上月月末时间（针对上周五这个日期来说的上月）
        System.out.println(getBeforeMonthStartTimeAndEndTime(new Date()));
        //4.	获取当前时间的上周五的时间
        System.out.println(getEndFriday());

    }

    /**
     * 获取周一和周五的时间List
     * <p>
     * 如果上周五所在天为上个月，则获取上个月的周一所在日期，周五所在日期
     * <p>
     * 如果上周五所在天为当前个月，则获取当前月完整的周一和周五
     */
    public static List<List<String>> getMondayAndFridayFullMonth(Date date) {
        List<List<String>> result;
        //获取上周五的时间
        Date beforeFriday = getBeforeFriday(date);
        //周五如果在本月
        boolean include = checkIsCurrentTimeOnMonth(beforeFriday);
        if (include) {
            //获取本月周一，周五时间
            result = getMondayAndFridayFullInThisMonth(beforeFriday);
        } else {
            //获取上个月周一，周五时间
            result = getMondayAndFridayFullInLastMonth(date);
        }
        //周五跨月的情况
        Date monthStartTime = new Date(getMonthStartTime(date));
        //如果本月的开始时间在大于周五小于周天，则返回该时间所在周一和周五的时间
        if (checkTimeIs567(monthStartTime)) {
            Date monday = getThisWeekDay(monthStartTime, MONDAY);
            Date firday = getThisWeekDay(monthStartTime, FRIDAY);
            result.add(0, Arrays.asList(formatDataFullSting(monday),
                    formatDataFullSting(firday),
                    formatDatadaySting(monday, firday)));
        }
        //排序
        return result;
    }

    /**
     * 获取上个月的开始时间和结束时间
     *
     * @return 返回时间list
     */
    public static List<String> getBeforeMonthStartTimeAndEndTime(Date date) {
        //获取上周五的时间
        Date beforeFriday = getBeforeFriday(date);
        //上个月的开始时间
        Calendar time = getInstance();
        time.setTime(beforeFriday);
        time.add(MONTH, -1);
        time.set(time.get(YEAR), time.get(MONTH), time.getActualMaximum(DAY_OF_MONTH), 23, 59, 59);
        String startTime = new SimpleDateFormat("yyyyMM01").format(time.getTime());
        String endTime = new SimpleDateFormat("yyyyMMdd").format(time.getTime());
        return Arrays.asList(startTime, endTime);
    }

    /**
     * 获取指定的开始时间，结束时间是当前时间最近的周五时间
     *
     * @return String
     */
    public static String getEndFriday() {
        Date now = new Date();
        boolean in1and5 = checkTimeIn1and5(now);
        Date friday;
        if (in1and5) {
            friday = getBeforeWeekday(now, FRIDAY);

        } else {
            friday = getThisWeekDay(now, FRIDAY);
        }
        return formatDataFullSting(friday);

    }


    ///////////////////////以下为辅助方法///////////////////

    /**
     * 判断指定的日期是不是在当前时间所在的月
     *
     * @param data 指定日期
     * @return true 在之内，false 不在
     */
    private static boolean checkIsCurrentTimeOnMonth(Date data) {
        Date now = new Date();
        return (data.getTime() > getMonthStartTime(now)) && (data.getTime() < getMonthEndTime(now));

    }

    /**
     * @param monthEndTime data
     * @return result                                                                                                                      String>>
     */
    private static List<List<String>> getMondayAndFridayFullInThisMonth(Date monthEndTime) {
        //获取本月的开始时间
        Date monthStartTime = new Date(getMonthStartTime(monthEndTime));
        //Date monthEndTime = new Date(getMonthEndTime(now));
        return assemblyData(new ArrayList<>(), monthStartTime, monthEndTime, null, null, true);
    }


    /**
     * 递归组装时间
     *
     * @param result         返回结果集
     * @param monthStartTime 开始时间
     * @param monthEndTime   结束时间
     * @param beforeMonday   递归周一
     * @param beforeFirday   递归周五
     * @param isfirstTime    是否是第一次递归
     * @return 返回结果集
     */
    private static List<List<String>> assemblyData(List<List<String>> result, Date monthStartTime, Date monthEndTime, Date beforeMonday, Date beforeFirday, boolean isfirstTime) {
        Date monday;
        Date firday;
        if (isfirstTime) {
            monday = getLastWeekday(monthStartTime, MONDAY);
            firday = getLastWeekday(monthStartTime, FRIDAY);
            isfirstTime = false;
        } else {
            monday = getLastWeekday(beforeMonday, MONDAY);
            firday = getLastWeekday(beforeFirday, FRIDAY);

        }
        if (firday.compareTo(monthEndTime) < 0) {
            result.add(Arrays.asList(
                    formatDataFullSting(monday),
                    formatDataFullSting(firday),
                    formatDatadaySting(monday, firday)
            ));
        } else {
            return result;
        }
        return assemblyData(result, monthStartTime, monthEndTime, monday, firday, isfirstTime);
    }


    /**
     * 当前时间的下周的周几的时间
     * <p>
     * Calendar.MONDAY 2        代表周一
     * Calendar.TUESDAY 3       代表周二
     * Calendar.WEDNESDAY 4     代表周三
     * Calendar.THURSDAY 5      代表周四
     * Calendar.FRIDAY 6        代表周五
     * Calendar.SATURDAY 7      代表周六
     * Calendar.SUNDAY 1        代表周日
     *
     * @param date     当前时间
     * @param whichDay 需要获取当前时间所在周的周几
     * @return 当前时间的下周的周几的时间
     */
    private static Date getLastWeekday(Date date, int whichDay) {
        Calendar cal = getInstance();
        cal.setTime(getThisWeekDay(date, whichDay));
        cal.add(DATE, 7);
        return cal.getTime();
    }

    /**
     * 指定时间的上周的周几的时间
     * <p>
     * Calendar.MONDAY 2        代表周一
     * Calendar.TUESDAY 3       代表周二
     * Calendar.WEDNESDAY 4     代表周三
     * Calendar.THURSDAY 5      代表周四
     * Calendar.FRIDAY 6        代表周五
     * Calendar.SATURDAY 7      代表周六
     * Calendar.SUNDAY 1        代表周日
     *
     * @param date     当前时间
     * @param whichDay 需要获取当前时间所在周的周几
     * @return 当前时间的上周的周几的时间
     */
    private static Date getFirstWeekday(Date date, int whichDay) {
        Calendar cal = getInstance();
        cal.setTime(getThisWeekDay(date, whichDay));
        cal.add(DATE, -7);
        return cal.getTime();
    }


    /**
     * init Calendar
     *
     * @param now date
     * @return Calendar
     */
    private static Calendar initCalendar(Date now) {
        Calendar calendar = getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTimeInMillis(now.getTime());
        calendar.add(YEAR, 0);
        calendar.add(MONTH, 0);
        return calendar;
    }


    /**
     * 获取指定时间所在月的开始时间戳
     *
     * @param now date
     * @return 时间戳
     */
    private static Long getMonthStartTime(Date now) {
        Calendar calendar = initCalendar(now);
        // 设置为1号,当前日期既为本月第一天
        calendar.set(DAY_OF_MONTH, 1);
        calendar.set(HOUR_OF_DAY, 0);
        calendar.set(MINUTE, 0);
        calendar.set(SECOND, 0);
        calendar.set(MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }


    /**
     * 获取指定时间所在月的结束时间戳
     *
     * @param now date
     * @return 时间戳
     */
    private static Long getMonthEndTime(Date now) {
        Calendar calendar = initCalendar(now);
        //设置为当前月的最后一天
        calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));
        calendar.set(HOUR_OF_DAY, 23);
        calendar.set(MINUTE, 59);
        calendar.set(SECOND, 59);
        calendar.set(MILLISECOND, 999);
        return calendar.getTimeInMillis();
    }


    /**
     * 获取指定的开始时间，结束时间是当前时间最近的周五的时间
     *
     * @param startTime 开始时间
     * @return 返回时间list
     */
    private static Date getBeforeFriday(Date startTime) {
        boolean in1and5 = checkTimeIn1and5(startTime);
        if (in1and5) {
            //如果当前时间是周一到周五之间，则周五为上周的周五
            return getBeforeWeekday(startTime, FRIDAY);

        } else {
            //否则周五为本周的周五
            return getThisWeekDay(startTime, FRIDAY);

        }

    }

    /**
     * 判断当前时间是不是在周一和周五之间
     * <p>
     * 注意：礼拜天为一周的第一天，礼拜六为一周的最后一天
     *
     * @param date data
     * @return boolean
     */
    private static boolean checkTimeIn1and5(Date date) {
        Calendar cal = getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(DAY_OF_WEEK);
        return dayWeek > 1 && dayWeek < 7;
    }

    /**
     * 判断当前时间是不是在周五和周天之间
     * <p>
     * 注意：礼拜天为一周的第一天，礼拜六为一周的最后一天
     *
     * @param date data
     * @return boolean
     */
    private static boolean checkTimeIs567(Date date) {
        Calendar cal = getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(DAY_OF_WEEK);
        return dayWeek >= 5 && dayWeek <= 7;
    }

    /**
     * 当前时间的上周的周几的时间
     * <p>
     * Calendar.MONDAY 2        代表周一
     * Calendar.TUESDAY 3       代表周二
     * Calendar.WEDNESDAY 4     代表周三
     * Calendar.THURSDAY 5      代表周四
     * Calendar.FRIDAY 6        代表周五
     * Calendar.SATURDAY 7      代表周六
     * Calendar.SUNDAY 1        代表周日
     *
     * @param date     当前时间
     * @param whichDay 需要获取当前时间所在周的周几
     * @return 当前时间的上周的周几的时间
     */
    public static Date getBeforeWeekday(Date date, int whichDay) {
        Calendar cal = getInstance();
        cal.setTime(getThisWeekDay(date, whichDay));
        cal.add(DATE, -7);
        return cal.getTime();
    }

    /**
     * 获取当前时间所在的周的周几是哪一天
     * <p>
     * Calendar.MONDAY 2        代表周一
     * Calendar.TUESDAY 3       代表周二
     * Calendar.WEDNESDAY 4     代表周三
     * Calendar.THURSDAY 5      代表周四
     * Calendar.FRIDAY 6        代表周五
     * Calendar.SATURDAY 7      代表周六
     * Calendar.SUNDAY 1        代表周日
     *
     * @param date     当前时间
     * @param whichDay 需要获取当前时间所在周的周几
     * @return 周几的时间
     */
    private static Date getThisWeekDay(Date date, int whichDay) {
        Calendar cal = getInstance();
        cal.setTime(date);
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(DAY_OF_MONTH, -1);
        }
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(whichDay);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(DATE, cal.getFirstDayOfWeek() - day);
        return cal.getTime();
    }


    //获取上个月月周一，周五时间
    private static List<List<String>> getMondayAndFridayFullInLastMonth(Date now) {
        //获取当前月的上个月的最后一天
        Date endTime = getBeforeMonthLastDay(now);
        //获取上个月的开始时间
        Date monthStartTime = new Date(getMonthStartTime(endTime));
        return assemblyData(new ArrayList<>(), monthStartTime, endTime, null, null, true);
    }


    /**
     * 获取上个月的最后一天
     *
     * @param date date
     * @return date
     */
    private static Date getBeforeMonthLastDay(Date date) {
        Calendar calendar = getInstance();
        calendar.setTime(date);
        calendar.setTime(new Date());
        calendar.add(MONTH, -1);
        calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));
        return calendar.getTime();
    }


    /**
     * 时间格式化
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatDataFullSting(Date date) {
        return new SimpleDateFormat("YYYYMMdd").format(date);
    }


    /**
     * 时间格式化
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatDataSting(Date date) {
        return new SimpleDateFormat("YYYY/MM月/dd日").format(date);
    }

    /**
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 时间字符串
     */
    private static String formatDatadaySting(Date startTime, Date endTime) {
        return new SimpleDateFormat("dd").format(startTime) + "日-" + new SimpleDateFormat("dd").format(endTime) + "日";
    }
}
