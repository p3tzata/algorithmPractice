package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class MaxElement {

	private static Integer[] array;
	
	
	public static void main(String[] args) {
		array = new Integer[] {100,25,6,98,9};
		Util.printlnLine(fun(0));
		
	}

	private static int fun(int indx) {
		
		if(indx==array.length-1) {
			return array[indx];
		}
		
		
		int max = fun(indx+1);
		if (max<array[indx]) {
			return array[indx]; 
		} else {
			return max;
		}
		
		
	}
	
	
	
	
	
}
