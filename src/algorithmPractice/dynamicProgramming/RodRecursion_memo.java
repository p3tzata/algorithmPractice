package algorithmPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class RodRecursion_memo {

	
	static Integer[] rodLenghtTable;
	static Integer[] rodPriceTable;
	static Integer[] rodMaxPrice;
	static Integer[] rodBestCombination;
	static List<Integer> result;
	static int counter=0;
	static int lenght;
	
	public static void main(String[] args) {
		
		rodLenghtTable = new Integer[] {0,1,2,3,4, 5, 6, 7, 8, 9,10};
		rodPriceTable = new Integer[]  {0,1,5,8,9,10,17,17,20,24,30};
		rodMaxPrice = new Integer[rodLenghtTable.length];
		rodBestCombination = new Integer[rodLenghtTable.length];
		result=new ArrayList<>();
		lenght=5;
		r(lenght);
		
		Util.printlnLine("counter:" + counter);
		Util.printlnLine("result:" + rodMaxPrice[lenght]);
		String debug="debug";
	} 
	
	
	static int r(int lenght) {
		
		if(rodMaxPrice[lenght]!=null) {
			return rodMaxPrice[lenght];
		}
		
		counter++;
		
		
		
		if(lenght==0) {

		return 0;
		}
		
		
		
	   int currentPrice=0;
	   for (int i=1;i<=lenght;i++) {
		   //currentPrice =  Math.max( rodPriceTable[i] + r(lenght-rodLenghtTable[i]) , currentPrice );
		   int result =rodPriceTable[i] + r(lenght-rodLenghtTable[i]);
		   if( result >= currentPrice ) {
			   currentPrice=result;
			   rodBestCombination[lenght]=i;
			   
		   }
		  
		   
	   }
	    rodMaxPrice[lenght]=currentPrice;
		return currentPrice;
		
		
		
		
		
	}
	
	
	
	
	

}
