package algorithmPractice.dynamicProgramming.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class ZigzagSubsequence_mine {

	
	
	
	public static void main(String[] args) {
		
	int[] elements = new int[] {8 ,3 ,5 ,7,0 ,8,9 ,10, 20 ,20 ,20 ,12 ,19 ,11};	
	//	int[] elements = new int[] {8 ,3 ,5};	
	int[] elementsStats = new int[elements.length];
	
	Map<Integer,List<Integer>> tracker=new HashMap<>();
	Integer[] fndElementsLessThen = new Integer[elements.length];	
	Integer[] fndElementsGreatThen = new Integer[elements.length];
	
	for (int i=0; i<elements.length;i++) {
		
		
		fndElementsLessThen[i]=elements[i];
		elementsStats[i]=1;
		List<Integer> el=new ArrayList<>();
		el.add(i);
		tracker.put(i+1, el );
		
		for (int j=0;j<i;j++) {
			
			if (fndElementsLessThen[j]!=null) {
				 if (elements[i]<fndElementsLessThen[j]) {
					 elementsStats[j]++; 
					 fndElementsLessThen[j]=null;
					 fndElementsGreatThen[j]=elements[i];
					 tracker.get(j+1).add(i);
				 }
				
			} else {
				
				if (elements[i]>fndElementsGreatThen[j] ) {
					elementsStats[j]++;
					fndElementsGreatThen[j]=null;
					fndElementsLessThen[j]=elements[i];
					tracker.get(j+1).add(i);
				}
				
			}
	
		}
		
		
		
	}
	
	
	
	
	
	
	
	String debugString="";
	
	
	
	
	

	}

}
