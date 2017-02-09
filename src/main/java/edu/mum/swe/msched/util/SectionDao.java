package edu.mum.swe.msched.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SectionDao {
	private static final String DATE_PATTERN = "MM/dd/yyyy";
	private static final String DATE_TIME_PATTERN = "MM/dd/yyyy HH:mm:ss";

	public static String displayDateFormat(Date date) {
		DateFormat dFormat = new SimpleDateFormat(DATE_PATTERN);
		if (date != null) {			
			return dFormat.format(date);
		}
		return dFormat.format(new Date());
	}

	public static String displayDateTimeFormat(Date date) {
		DateFormat dFormat = new SimpleDateFormat(DATE_TIME_PATTERN);
		if (date != null) {			
			return dFormat.format(date);
		}
		return dFormat.format(new Date());
	}
}
