package algorithmPractice.recursion.room1;

import util.Util;

public class FibonacciNoRecursion {

	public static void main(String[] args) {
	
		
		int n=8;
		int result1=0;
		int result2=0;
		int resultF=0;
		
		for(int i=1;i<=n;i++) {
			
			if (i==1||i==2) {
				result1=1;
				result2=1;
			} else {
				resultF=result1 + result2;
				result2=result1;
				result1=resultF;
			}
			

			
			
			
		}
		
		
		Util.printlnLine(resultF);
		
		
		

	}

}
