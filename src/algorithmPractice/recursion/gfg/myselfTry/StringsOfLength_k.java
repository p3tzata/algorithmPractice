package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class StringsOfLength_k {

	private static String[] set;
	private static String[] vector;
	private static int k;
	
	public static void main(String[] args) {
		k=3;
		set = new String[] {"A","B"};
		vector = new String[k];
		
		
		func(0);

	}

	private static void func(int indx) {
		
		if(indx==k) {
			Util.printArray(vector);
			return;
		}
		
		
		for(int i=0;i<set.length;i++) {
			vector[indx]=set[i];
			func(indx+1);
		}
		
	}

}
