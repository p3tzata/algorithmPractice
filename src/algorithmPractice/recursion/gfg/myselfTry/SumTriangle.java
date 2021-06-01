package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class SumTriangle {
	
	
private static Integer[] array;
	
	
	public static void main(String[] args) {
		array = new Integer[] {1,2,3,4,5};
		
		Util.printlnLine(fun(array));
	}


	private static int fun(Integer[] array) {
		
		
		if(array.length==1) {
			return array[0];
		}
		
		Integer[] newArrayInteger =  new Integer [array.length-1];
		
		for(int i=0;i<=array.length-2;i++) {
			newArrayInteger[i]=array[i]+array[i+1];
		}
		
		return fun(newArrayInteger);
		
	}
	
}
