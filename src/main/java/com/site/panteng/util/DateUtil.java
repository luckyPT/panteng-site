package com.site.panteng.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static String longToDate(long timeStamp,String format){
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date date= new Date(timeStamp);
            return sdf.format(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void main(String[] arges){
		String dateString = DateUtil.longToDate(System.currentTimeMillis(), "yyyy-MM-dd HH:mm:ss");
		System.out.println(dateString);
	}
}
