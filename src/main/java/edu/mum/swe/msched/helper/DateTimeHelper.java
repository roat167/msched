package edu.mum.swe.msched.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import edu.mum.swe.msched.util.SectionDao;

public class DateTimeHelper {
	
	public static String getDisplayDateBetween(Date date1, Date date2) {
		return SectionDao.displayDateFormat(date1) + "-" + SectionDao.displayDateFormat(date2);
	}
	
}
