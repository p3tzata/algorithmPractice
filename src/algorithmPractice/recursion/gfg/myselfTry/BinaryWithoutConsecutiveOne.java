package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class BinaryWithoutConsecutiveOne {

	
	private static int num;
	private static Integer[] vector;
	
	public static void main(String[] args) {
		
		num=3;
		vector=new Integer[num];
			
		fun(0,false);
		
	}

	private static void fun(int indx,boolean isPrevOne) {
		
		if (indx>vector.length-1) {
			Util.printArray(vector);
			return;
		}
		
		
		vector[indx]=0;
		fun(indx+1,false);
		
		if(!isPrevOne) {
		
		vector[indx]=1;
		fun(indx+1,true);
		}
		
		
		
	}

}
