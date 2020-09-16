package algorithmPractice.recursion.exam;

import util.Util;

public class Parentheses {

	
	static Character[] result;
	static int n=2;
	static int cnt=0;
	public static void main(String[] args) {
		
	
	result = new Character[n*2];
	
	result[0]='(';	
	
	long start = System.currentTimeMillis();
	gen(0,0,0);
	//Util.printlnLine(System.currentTimeMillis()-start);	
		

	}

	private static void gen(int indx, int openedBrecket, int closetBrecket) {
		
		if(indx==result.length) {
			Util.printArray(result, "");
			return;
		}
		
		if(openedBrecket<n) {
		result[indx]='(';	
		gen(indx+1,openedBrecket+1,closetBrecket);
		
		}
		
		if(openedBrecket>closetBrecket) {
		result[indx]=')';
		gen(indx+1,openedBrecket,closetBrecket+1);
		
		}
		
		Util.printlnLine(cnt++);
		
		
	}

}
