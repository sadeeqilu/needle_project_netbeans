package com.needle.util;

import java.text.NumberFormat;

/**
 * 
 * @author Sadiq Ilu
 * @version 1.1
 * @since jdk 1.8
 *
 */
public class Utility {

	// This method formats an output to show the naira sign before a price.
	public static String priceFormatter(double price) {
	
		NumberFormat number = NumberFormat.getInstance();
		return "NGN "+number.format(price);
	
	}
}
