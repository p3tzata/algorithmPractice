package algorithmPractice.recursion.gfg;

import util.Util;

public class PartyHandShake {
	static int Npeople=4;

	public static void main(String[] args) {
		 
		callHandShake(1,0);

	}

	private static void callHandShake(int i,int sum) {
		
		if (i==Npeople) {
			Util.printlnLine(sum);
			return;
		}
		
		int tempSum=Npeople-i;
		
		
		callHandShake(i+1,sum+tempSum);
		
		
		
	}
	
	
	

}
