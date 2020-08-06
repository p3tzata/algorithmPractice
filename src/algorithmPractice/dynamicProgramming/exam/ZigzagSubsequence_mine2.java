package algorithmPractice.dynamicProgramming.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Util;



public class ZigzagSubsequence_mine2 {

	
	
	
	public static void main(String[] args) {
		
	//int[] elements = new int[] {8 ,3 ,5 ,7,0 ,8,9 ,10, 20 ,20 ,20 ,12 ,19 ,11};	
	//int[] elements = new int[] {12,19,11};	
	
	int[] elements = new int[] {24, 5, 31, 3, 3, 342, 51, 114, 52, 55, 56, 58};
	
	int[] elementsStats = new int[elements.length];
	
	elementsStats[elements.length-1]=1;
		
		
	for (int i=elements.length-2;i>=0;i--)  {
		
		int tmpMaxStat=1;
		for(int j=i+1;j<elements.length;j++) {
			
			if(elementsStats[j]%2==0) {
				
				if (elements[i]>elements[j]) {
					if (elementsStats[j]>=tmpMaxStat) {
						tmpMaxStat=elementsStats[j]+1;
					}
				}
				
			} else {
				if (elements[i]<elements[j]) {
					if (elementsStats[j]>=tmpMaxStat) {
						tmpMaxStat=elementsStats[j]+1;
					}
				}
				
			}
			
			
			
			
			
			
		}
		
		elementsStats[i]=tmpMaxStat;
		
		
	}
	
	
	int indx=0;

	
	
	
	
	int lastMaxFoundIdex=-1;
	
	while(indx<elements.length) {
		
		int tmpMaxIndex=-1;
		int tmpMaxStat=0;
	while(indx<elements.length) {
		
				
		
		
		
		if(elementsStats[indx]>=tmpMaxStat) {
			
			if (lastMaxFoundIdex>0) {
			
			if(elementsStats[lastMaxFoundIdex]%2==1) {
				
				if (elements[lastMaxFoundIdex]>elements[indx]) {
					
					tmpMaxIndex=indx;
					tmpMaxStat=elementsStats[indx];
				}
				
			}
			
			if(elementsStats[lastMaxFoundIdex]%2==0) {
				
				if (elements[lastMaxFoundIdex]<elements[indx]) {
					
					tmpMaxIndex=indx;
					tmpMaxStat=elementsStats[indx];
				}
				
			}
			
			} else {
				tmpMaxIndex=indx;
				tmpMaxStat=elementsStats[indx];
			}
		
		}	
			
			
		
		

		indx++;
	
	}
	Util.printlnLine(elements[tmpMaxIndex]);
	lastMaxFoundIdex=tmpMaxIndex;
	indx=tmpMaxIndex+1;
	
	}
	
	
	
	String debugString="";
	
	
	
	
	

	}

}
