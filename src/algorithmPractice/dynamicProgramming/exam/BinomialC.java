package algorithmPractice.dynamicProgramming.exam;

import java.util.HashMap;

import util.Util;

public class BinomialC {

	static HashMap<String, Integer> cache;
	static int cnt=0;
	
	public static void main(String[] args) {

		int n=10;
		int k=5;
		cache=new HashMap<>();
		
		Util.printlnLine(calc(n, k));
		Util.printlnLine(cnt);
	}
	
	
	
	
	static int calc(int n, int k) {
		
		if (cache.containsKey(n+"-"+k)) {
			return cache.get(n+"-"+k);
		}
		
		cnt++;
		if(n==k || k==0) {
			return 1;
		}
		
		
		
		
		int resutl = calc(n-1, k-1) + calc(n-1, k);
		
		cache.put(n+"-"+k,resutl);
		
		return resutl; 
		
	}
	

}
