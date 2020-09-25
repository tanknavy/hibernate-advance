package com.tanknavy.hibernate.bi;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
	
	public static Date parseDate(String dataStr) throws ParseException {
		Date theDate = formatter.parse(dataStr);
		return theDate;
	}
	
	
	public static String formatDate(Date theDate) {
		String result = null;
		
		if (theDate != null) {
			result = formatter.format(theDate);
		}
		
		return result;
	}
	
}


