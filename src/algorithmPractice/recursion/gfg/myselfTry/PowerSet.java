package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class PowerSet {

	private static String[] array;
	
	public static void main(String[] args) {
		
		array = new String[] {"a","b","c"};
		
		
		fun(0,"");
	}

	private static void fun(int b,String result) {

		
		
		
		for(int i=b;i<array.length;i++) {
			Util.printlnLine(result + array[i]);
			
			
			fun(i+1,result + array[i]);
			
			
		}
		
		
	}
	
	
	
	
	

}
