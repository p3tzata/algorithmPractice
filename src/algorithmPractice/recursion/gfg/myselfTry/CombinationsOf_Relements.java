package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class CombinationsOf_Relements {

private static Integer[] array;
private static Integer[] vector;

	private static int r=2;
	
	public static void main(String[] args) {
		array = new Integer[] {1,2,3,4};
		vector=new Integer[r];
		fun(0,0);
		
	}

	private static void fun(int depth, int border) {
		
		if(depth==r) {
			Util.printArray(vector);
			return;
		}
		
		for(int i=border;i<array.length;i++) {
			
			vector[depth]=array[i];
			fun(depth+1,i+1);
			
		}
		
		
		
		
	}
}
