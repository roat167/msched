package edu.mum.swe.msched.helper;

import java.util.Arrays;
import java.util.List;

import edu.mum.swe.msched.enumeration.PREFERED_BLOCK;

public class PreferedBlockHelper {

	public static List<PREFERED_BLOCK> getPreferedBlockList() {
		List<PREFERED_BLOCK> preferedBlockList = Arrays.asList(
				PREFERED_BLOCK.JANUARY, PREFERED_BLOCK.FEBRUARY, PREFERED_BLOCK.MARCH, PREFERED_BLOCK.APRIL, 
				PREFERED_BLOCK.MAY, PREFERED_BLOCK.JUNE, PREFERED_BLOCK.JULY, PREFERED_BLOCK.AUGUST, 
				PREFERED_BLOCK.SEPTEMBER, PREFERED_BLOCK.OCTOBER, PREFERED_BLOCK.NOVEMBER, PREFERED_BLOCK.DECEMBER);
		
		return preferedBlockList;
	}

	
}
