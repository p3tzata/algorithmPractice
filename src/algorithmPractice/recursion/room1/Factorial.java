package algorithmPractice.recursion.room1;

import util.Util;

public class Factorial {

	
	
	
	public static void main(String[] args) {
		
			
		Util.printlnLine(factorial(5));
		
				

	}
	
	
	static private Integer factorial(Integer num) {
		
		if (num==0) {
			return Integer.valueOf(1);
		}
		
		return num * factorial(num-1);
		
	}
	
	
	
	
}
