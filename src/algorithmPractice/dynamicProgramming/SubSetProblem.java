package algorithmPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Util;

public class SubSetProblem {
	
	
	static Integer[] elements;
	static List<Integer> possibleSum;
	static Map<Integer, Integer> resultTracker;
	public static void main(String[] args) {
		
		resultTracker=new HashMap<Integer, Integer>();
		elements=new Integer[] {3,5,1,9};
		possibleSum=new ArrayList<>();
		int targetSum=8;
		possibleSum.add(0);
		
		
		for (int j=0;j<elements.length;j++) {
		List<Integer> tmpList=new ArrayList<>();
		//int j=0;
		for(int i=0;i<possibleSum.size();i++) {
			int tmp=possibleSum.get(i)+elements[j];
			tmpList.add(tmp);
			resultTracker.put(tmp, elements[j]);
		}
		possibleSum.addAll(tmpList);
		}
		
		String debug="";
		int currentSum=targetSum;
		Integer i=-1;
		if (resultTracker.get(currentSum)!=null){
		while(currentSum>0) {
			
			i = resultTracker.get(currentSum);
			Util.printlnLine(i);
			
			currentSum=currentSum-i;
			
			
			
		}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
