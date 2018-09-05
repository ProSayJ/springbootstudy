package com.prosayj.springboot.constants;

/**
 * @author yangjian
 * @description 日期工具类DateUtils的輔助枚举
 * @email ProSayj@gmail.com
 * @creatTime 2018/7/30 15:59
 * @since 1.0.0
 */
public enum DatePattern {	
	/**
	 * 时间格式为"yyyy"
	 */
	Y("yyyy"),
	
	/**
	 * 时间格式为"yyyy-MM"
	 */
	Y_M("yyyy-MM"),
	
	/**
	 * 时间格式为"yyyy-MM-dd"
	 */
	Y_M_D("yyyy-MM-dd"), 
	
	/**
	 * 时间格式为"yyyy-MM-dd HH"
	 */
	Y_M_D_H("yyyy-MM-dd HH"), 
	
	/**
	 * 时间格式为"yyyy-MM-dd HH:mm"
	 */
	Y_M_D_H_M("yyyy-MM-dd HH:mm"),
	
	/**
	 * 时间格式为"yyyy-MM-dd HH:mm:ss"
	 */
	Y_M_D_H_M_S("yyyy-MM-dd HH:mm:ss"),
	
	/**
	 * 时间格式为"yyyy-MM-dd HH:mm:ss.SSS"
	 */
	Y_M_D_H_M_S_S("yyyy-MM-dd HH:mm:ss.SSS"),
	
	/**
	 * 时间格式为"yyyyMMdd HH:mm:ss"（年月日之间没有分隔符）
	 */
	YMD_H_M_S("yyyyMMdd HH:mm:ss"),
	
	/**
	 * 时间格式为"yyyyMMddHHmmss"（年月日之间没有分隔符）
	 */
	YMDHMS("yyyyMMddHHmmss"),

	/**
	 * 时间格式为"yyyyMMdd"
	 */
	YMD("yyyyMMdd"),

	/**
	 * 时间格式为"yyMMdd"
	 */
	YYMD("yyMMdd"),
	/**
	 * 时间格式为"yy/MM/dd"
	 */
	YY_MM_DD("yyyy/MM/dd");

	public String pVal;

	private DatePattern(String _pVal) {
		this.pVal = _pVal;
	}

}
