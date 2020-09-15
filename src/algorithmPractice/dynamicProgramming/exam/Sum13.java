package algorithmPractice.dynamicProgramming.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import util.Util;

public class Sum13 {

	static List<Integer> numbers;
	static Set<Integer> sums;
	static Set<Integer> newCalculatedSums;
	
	public static void main(String[] args) {
		
		sums=new HashSet<>();
		newCalculatedSums=new HashSet<Integer>();
		numbers = new ArrayList<>();
		numbers.add(8);
		numbers.add(-2);
		numbers.add(-2);
		
		sums.add(0);
		
		
		for(int i=0;i<numbers.size();i++) {
			
			Integer number = numbers.get(i);
			Integer oppositNumber = number*-1;
			
			Iterator<Integer> sumsIterator = sums.iterator();
			
			while (sumsIterator.hasNext()) {
				Integer sum = (Integer) sumsIterator.next();
				
				newCalculatedSums.add(sum + number);
				newCalculatedSums.add(sum + oppositNumber);
				
			}
			
			sums.addAll(newCalculatedSums);
			
			
		}
		
		if(sums.contains(12)) {
			Util.printlnLine("YES");
		}
		
		
		String debugString = "";
		System.out.print(debugString);
		
		
	}

}
