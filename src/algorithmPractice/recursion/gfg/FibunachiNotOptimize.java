package algorithmPractice.recursion.gfg;

import util.Util;

public class FibunachiNotOptimize {

	public static void main(String[] args) {
		Util.printlnLine(1%2);
		//fib(5);
				

	}

	private static int fib(int i) {
		
		if(i==1||i==2) {
			return 1;
		}
		
		int result=fib(i-1) + fib(i-2);
		Util.printlnLine(result);
		return result;
		
		
	}

}
