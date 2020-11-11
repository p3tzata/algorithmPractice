package algorithmPractice.recursion.gfg.myselfTry;

import java.util.spi.LocaleServiceProvider;

import util.Util;

public class IsPalindromNumber {
	
	static int number=12219;
	static Integer reversed=0;
	
	public static void main(String[] args) {
	
		
		int reverseNumber=0;
		
		
		
		reversed=func(number,reverseNumber);
			
		if (reversed!=number) {
			Util.printlnLine("No");
		} else {
			Util.printlnLine("Yes");
		}
	

	}

	private static int func(int curChunk, int reverseNumber) {
		
		if(curChunk==0) {
			
			return reverseNumber;
		}
		
		
		return func(curChunk/10,reverseNumber*10 + curChunk%10);
		
			
		
	}
	
	
	
	
	

}
