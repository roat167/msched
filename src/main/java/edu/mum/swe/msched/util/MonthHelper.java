package edu.mum.swe.msched.util;

import java.util.ArrayList;
import java.util.List;

import edu.mum.swe.msched.enumeration.MONTH;

public class MonthHelper {
	
	public static List<MONTH> getListOfMonth(){
		List<MONTH> listOfMonths = new ArrayList();
		listOfMonths.add(MONTH.JANUARY);
		listOfMonths.add(MONTH.FEBRUARY);
		listOfMonths.add(MONTH.MARCH);
		listOfMonths.add(MONTH.APRIL);
		listOfMonths.add(MONTH.MAY);
		listOfMonths.add(MONTH.JUNE);
		listOfMonths.add(MONTH.JULY);
		listOfMonths.add(MONTH.AUGUST);
		listOfMonths.add(MONTH.SEPTEMBER);
		listOfMonths.add(MONTH.OCTOBER);
		listOfMonths.add(MONTH.NOVEMBER);
		listOfMonths.add(MONTH.DECEMBER);
		
		return listOfMonths;
	}
}
