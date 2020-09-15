package algorithmPractice.dynamicProgramming.exam;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import util.Util;

public class Parentheses {

	static Set<String> resultSet;
	static Set<String> tempResultSet;
	static int n=16;
	
	public static void main(String[] args) {
		
		resultSet=new HashSet<>();
		resultSet.add("()");
		
		if (n==1) {
			return;
		}
		
		int i=2;
		long start = System.currentTimeMillis();
		while(i<=n) {
		i++;
		tempResultSet = new HashSet<>();
		
		Iterator<String> iterator = resultSet.iterator();
		while (iterator.hasNext()) {
			String curResult = (String) iterator.next();
			tempResultSet.add("()"+curResult);
			tempResultSet.add(curResult+"()");
			tempResultSet.add("("+curResult+")");
			
			
		}
		resultSet=new HashSet<>();
		resultSet.addAll(tempResultSet);
		
		
		
		}
		
		//Iterator<String> iterator = resultSet.iterator();
		//while (iterator.hasNext()) {
		//	String string = (String) iterator.next();
		//	Util.printlnLine(string);
		//	Util.printlnLine("====");
		//}
		
		
		
		Util.printlnLine(System.currentTimeMillis()-start);
		
		

	}

}
