package com.zooz.extended.java.lib.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ZooZStringUtils {
	
	private static final String DATE_FORMAT = "yyyy-MM-dd";
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
	
	public static boolean isEmpty(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}
	
	public static String formatDate(Date date) {
		return dateFormat.format(date);
	}

}
