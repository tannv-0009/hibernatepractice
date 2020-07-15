package com.example.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class DateUtil {

	public static Calendar defaultCalendar()
	{

		return Calendar.getInstance(TimeZone.getTimeZone("GMT+7"));
	}
	
	public static SimpleDateFormat dateFormat() {
		
		return new SimpleDateFormat("yyyy/mm/dd");
		
	}
}
