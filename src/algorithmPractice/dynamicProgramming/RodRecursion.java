package algorithmPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class RodRecursion {

	
	static Integer[] rodLenght;
	static Integer[] rodPrice;
	static List<Integer> result;
	static int counter=0;
	
	public static void main(String[] args) {
		rodLenght = new Integer[] {1,2,3,4, 5, 6, 7, 8, 9,10};
		rodPrice = new Integer[]  {1,5,8,9,10,17,17,20,24,30};
		result=new ArrayList<>();
		r(4);
		
	} 
	
	
	static void r(int lenght) {
		counter++;
		//Util.printlnLine(counter);
		
		if(lenght==0) {
			
		Util.printlnLine(result);
		return;
		}
		
		
		
		int tmpLenght=lenght;
		int indx=0;
		while (tmpLenght>=0) {
			
			tmpLenght = lenght - rodLenght[indx];
			
			
			result.add(rodPrice[indx]);
			
			
			r(tmpLenght);
			
			
			
			
			result.remove(result.size()-1);
			
			
			indx++;
			
			
			
			
			
			
		}
		
		
		
		
	}
	
	
	
	
	

}
