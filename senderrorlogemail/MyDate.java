package com.senderrorlogemail;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: MyDate
 * @Description: error log命名函数 （辅助获取错误日志）
 * @author guochaolang
 * @Time: 2016-3-7 下午3:31:14
 */
public class MyDate {
	/**
	 * 时间函数
	 */
	public static String getFileName() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(new Date(System.currentTimeMillis()));
		return date;
	}

	public static String getDateEN() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1 = format1.format(new Date(System.currentTimeMillis()));
		return date1;
	}
}
