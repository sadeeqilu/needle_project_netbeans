package com.needle.util;

/**
 * 
 * @author Sadiq Ilu
 * @version 1.1
 * @since jdk 1.8
 *
 */
public class DiscountCalculator {
	
	// calculates deposit using age and gender only
	// returns the percentage to be deducted from the total price
	public static double CalculateDiscount(int age, String gender) {
		
		// for age between 0 - 17, return 75%
		if(age > 0 && age < 18) {
			return 0.75;
		}
		// for age greater than 40, return 50%
		else if(age > 40) {
			return 0.5;
		}
		// for female between 18 - 40, return 25%
		else if(gender.equalsIgnoreCase("female")) {
			return 0.25;
		}
		// if none of the above conditions is met, return 0
		return 0.0;
	}
	
	// calculates additional discount if a guest when the guest comes back 
	// again using the frequency of his visit
	public static double CalculateDiscount(int freq) {
		double discount = 0.0;
		
		// the maximum amount to be received is NGN 1000
		// which is calculated by adding NGN250
		// for each visit
		// therefore, to save the system from over working we stop the execution if the
		// frequency is five or more
 		if(freq >= 5) {
			discount = 1000;
			return discount;
		}
		else {
			// adds 250 for each visit 
			for(int i = 0; i < freq; i++) {
				discount += 250;
			}
			return discount;
		}
	}

}
