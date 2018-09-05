package com.prosayj.springboot.javase.homework.day01_a;

/**
 * @author yangjian
 * @description TODO
 * @email ProSayj@gmail.com
 * @creatTime 2018/5/14 22:38
 * @since 1.0.0
 */
public class _Test02 {
    public static void main(String[] args) {
        System.out.println(splitString("s|asdf|sa|po", "|"));
    }

    public static String splitString(String str, String regExp) {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if (!regExp.equals(Character.toString(aChar))) {
                sb.append(aChar);
            } else {
                sb.append(" ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}

