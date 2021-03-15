package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class CopyString {

	private static String[] copyFrom;
	private static String[] copyTo;
	
	public static void main(String[] args) {
		
		copyFrom = new String[] {"e","m","o"};
		copyTo = new String[copyFrom.length];
		
		strCpyFun(0);
		
	}

	private static void strCpyFun(int i) {

		if(i== copyFrom.length) {
			Util.printArray(copyTo);
			return;
		}
			
		copyTo[i]=copyFrom[i];
		
		strCpyFun(i+1);
		
	}

}
