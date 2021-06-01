package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class CountSubstrings {

	private static String[] str={"a","b","c","a","b"}; 
			
			
	public static void main(String[] args) {
		
	
		fun(0,str.length-1);
		
	}


	private static void fun(int s, int e) {
		
		if(s>e) {
			
			return;
			
		}
		
		for(int i=s;i<=e;i++) {
			
			if( str[s].equals(str[i]) ) {
				Util.printArraySlice(str, s, i, ",");
			}
			
		}
		
		fun(s+1,e);
		
		
		
		
	}
	
	
}
