package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class IncreasingSequencesOfLength_k {

	static int k=3;
	static int n=5;
	static Integer[] vector;
	
	public static void main(String[] args) {
		vector=new Integer[k];
		fun(0,1);
		
	}


	private static void fun(int depth, int border) {
		
		if(depth==k) {
			Util.printArray(vector);
			return;
		}
		
		
		for(int i=border;i<=n;i++) {
			vector[depth]=i;
			fun(depth+1,i+1);
		}
		
		
		
	}

}
