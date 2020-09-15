package algorithmPractice.dynamicProgramming.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import util.Util;

public class Parties {

	static List<Integer> numbers;
	
	static Map<Integer,Integer> path;
	static Map<Integer, Character> mappingMap;
	static Map<Integer,Integer> newCalculatedSums;
	
	
	public static void main(String[] args) {
		path = new HashMap<Integer, Integer>();
		mappingMap = new HashMap<>();
		numbers = new ArrayList<>();
		numbers.add(10);
		numbers.add(4);
		numbers.add(2);
		mappingMap.put(10, 'A');
		mappingMap.put(4, 'B');
		mappingMap.put(2, 'C');
		
		
		
		
		path.put(0,0);
		
		
		for(int i=0;i<numbers.size();i++) {
		
			Integer number = numbers.get(i);
			newCalculatedSums=new HashMap<Integer, Integer>();
			
			for (Iterator<Entry<Integer, Integer>> iterator = path.entrySet().iterator(); iterator.hasNext();) {
				Entry<Integer, Integer> entry = iterator.next();
				Integer sum = (Integer) entry.getKey();
				
				newCalculatedSums.put(sum+number, sum);				
			}
			

			
			path.putAll(newCalculatedSums);
			
			
		}
		
		
		
		for (Iterator<Entry<Integer, Integer>> iterator2 = path.entrySet().iterator(); iterator2.hasNext();) {
			Entry<Integer, Integer> entry2 = iterator2.next();
			
			if(entry2.getKey()>=10) {
				
				//find participants.
				
				int previous = entry2.getValue();
				int sum = entry2.getKey();
				while(sum>0) {
					int number=sum-previous;
					sum=previous;
					previous = path.get(sum);
										
					Util.printlnLine(mappingMap.get(number)+"("+ number +")");	
					
				}
				
				
				
			}
			Util.printlnLine("---");	
			
			
		}
		
		
		String debugString = "";
		System.out.print(debugString);
		
		
	}

}
