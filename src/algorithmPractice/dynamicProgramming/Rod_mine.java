package algorithmPractice.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class Rod_mine {

	static Integer[] rodLenghtTable;
	static Integer[] rodPriceTable;
	static Integer[] rodMaxPrice;
	static List<Integer> result;
	
	
	public static void main(String[] args) {
		
		rodLenghtTable = new Integer[] {1,2,3,4, 5, 6, 7, 8, 9,10};
		rodPriceTable = new Integer[]  {1,5,8,9,10,17,17,20,24,30};
		rodMaxPrice = new Integer[rodLenghtTable.length];
		result=new ArrayList<>();
		calculate(4);
		
		
	}

	private static void calculate(int rodLenght) {
		
		
		int indx=0;
		while(rodLenghtTable[indx]<rodLenght) {

			indx++;
		}
		
		//Util.printlnLine(indx);
		rodMaxPrice[0]=rodLenghtTable[0];
		
		for(int i=1;i<=indx;i++) {
			if (i==3) {
				String debug="";
			}
			
		int rodCurrentPrice=rodPriceTable[i];
		int rodCurrentLenght=rodLenghtTable[i];
		int rodTmpMaxPrice=0;
		int border=i-1;
		while(rodCurrentLenght>0) {
		
			int curMaxIndex=getMaxPriceIndex(border);
			rodCurrentLenght =rodCurrentLenght - rodLenghtTable[curMaxIndex];
			rodTmpMaxPrice=rodTmpMaxPrice+rodMaxPrice[curMaxIndex];
			
			
			border=rodCurrentLenght-1;
		}
			
		if (rodCurrentPrice>=rodTmpMaxPrice) {
			rodMaxPrice[i]=rodCurrentPrice;
		} else {
			rodMaxPrice[i]=rodTmpMaxPrice;
		}
		
			
		}
		
		Util.printlnLine(rodMaxPrice);
		
		
	}
	
	static int getMaxPriceIndex(int toIndx) {
		int tempPrice=0;
		int tempIndx=0;
		
		for (int i=0; i<=toIndx;i++) {
			
			if (rodMaxPrice[i]>tempPrice) {
				tempPrice=rodMaxPrice[i];
				tempIndx=i;
			}
			
		}
		
		return tempIndx;
		
	}
	
	
	
	

}
