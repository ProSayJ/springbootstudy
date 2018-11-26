package com.prosayj.springboot.javase.homework.day03;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/17 1:_01_SingleThreadedExecution
 * @since 1.0.0
 */
public class _Test02 {
    private static int daysSince_01_01_1900(int month, int date, int year) {
        int days = (int)((year - 1900) * 365.25);
        switch(month) {
            case 12:
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                days += (year % 4 == 0)?  29 : 28;
            case 2:
                days += 31;
        }
        days += date;
        return days;
    }

}
