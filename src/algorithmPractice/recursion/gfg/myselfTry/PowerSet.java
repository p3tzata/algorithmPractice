package algorithmPractice.recursion.gfg.myselfTry;


import util.Util;

public class PowerSet {

	private static String[] array;
	private static String result ="";
	
	public static void main(String[] args) {
		
		array = new String[] {"a","b","c"};
		
		
		fun(0,result);
	}

	private static void fun(int b,String result) {

		
		
		
		for(int i=b;i<array.length;i++) {
			
			result = result + array[i];
			Util.printlnLine(result);
			
			
			fun(i+1,result);
			
			result = result.substring(0,result.length()-1);
		}
		
		
	}
	
	
	
	
	

}
