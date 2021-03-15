package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class FirstUppercaseLetter {

	
	private static String[] array;
	
	public static void main(String[] args) {
		
		array = new String[] {"e","M","o"};
		
		
		fun(0);
		
	}

	private static void fun(int i) {
		
		if(i==array.length) {
			return;
		}
		
		if(array[i].toUpperCase()==array[i]) {
			
			Util.printlnLine(array[i]);
			return;
		}
		
		fun(i+1);
		
	}

}
