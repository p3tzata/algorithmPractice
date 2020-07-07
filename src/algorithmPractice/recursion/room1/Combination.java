package algorithmPractice.recursion.room1;



import java.util.Stack;

import util.Util;

public class Combination {
	static Integer vector[];
	static Integer n;
	static Integer setArray[] = { 1, 2, 3};
	static Stack<Integer> tmpStack;
	public static void main(String[] args) {
		tmpStack= new Stack<>();
		n=2;
		vector = new Integer[n];
				//recursion_dynamic(0,tempIntArray);
		//GenerateCombo(tempIntArray,0,0);
		recursion_star();
		
		
		
	}
	
	
	
	static public void recursion_star() {
	
		
		    recursion_dynamic_p(0,0);
			//recursion_dynamic(0,0);			
		
	
	
	}
	
	
	
	
		
	static public void recursion_dynamic(int indx, int depth) {
		
		
		if (depth==vector.length) {
			Util.printArray(vector, "-");
			return;
		}
		
		
		for(int i=0;i<setArray.length;i++) {
			vector[depth]=setArray[i];
			recursion_dynamic(i, depth+1);
			
			
		}
		
		
		
		
	}
	
	static public void recursion_dynamic_p(int indx, int depth) {
		
		
		if (depth==vector.length) {
			Util.printArray(vector, "-");
			return;
		}
		
		
		for(int i=indx;i<setArray.length;i++) {
			vector[depth]=setArray[i];
			recursion_dynamic_p(i, depth+1);
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	static public void recursion_static(int index,int c) {
		
			if (index==setArray.length-1 || c==setArray.length) {
				return;
			}
			
				
		
		Util.printlnLine(setArray[index] + " - " + setArray[c]);
		//Print.printArraySlice(intArray, index, c , " - ");	
			
		
		if (c==setArray.length-1) {
			recursion_static(index+1,index+2);
		} else {
			recursion_static(index,c+1);
		}
		
		
		
		
	}
	

}
