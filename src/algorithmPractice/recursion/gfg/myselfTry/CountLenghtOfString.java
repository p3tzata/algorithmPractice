package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class CountLenghtOfString {

	private static String[] array;
	
	public static void main(String[] args) {

		array = new String[] {"e","e","e","e"};

		
		Util.printlnLine(fun(0));
		
	}

	private static int fun(int i) {
		
		if(i==array.length-1) {
			return 1;
		}
		
		
		return 1+fun(i+1);
		
	}
	
	
	

}
