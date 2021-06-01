package algorithmPractice.recursion.gfg.myselfTry;

import static util.funcPrintTree.StrBuilder.gArrayVar;
import static util.funcPrintTree.StrBuilder.gVar;


import util.Util;
import util.funcPrintTree.RecursionPrintTree;

public class GenerateSortedArrayFromTwoArrays {

	private static Integer[] sourceA;
	private static Integer[] sourceB;
	private static Integer[] sourceTest;
	private static Integer[] vector;
	private static int count=0;
	
	public static void main(String[] args) {
		
		sourceA = new Integer[]  {10, 15, 25};
		sourceB = new Integer[] {1, 5, 20, 30};
		/*
		sourceTest = new Integer[] {1, 5,10,50,200,300 };
		
		int s=0;
		int e=4;
		
		int mid=((e-s)/2)+s;
		Util.printlnLine(sourceTest[s]);
		Util.printlnLine(sourceTest[mid]);
		
		Util.printlnLine(sourceTest[mid+1]);
		Util.printlnLine(sourceTest[e]);
		*/
		
		
		vector = new Integer[sourceA.length+sourceB.length];
		//util.Util.printlnLine((sourceA.length-1)/2);
		fun(0,sourceA.length-1,0,sourceB.length-1,'A',Integer.MIN_VALUE,0,0);
		Util.printlnLine(count);
		
	}
	
	
	private static void fun(int sA, int eA, int sB, int eB, char c,int prevVal,int vectorIndex,int level) {
		count++;
		RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
		//recursionPrintTree.printHeaderCall( gArrayVar("sourceA", sourceA, sA, eA),gArrayVar("sourceB", sourceB, sB, eB),gVar("c", c),gVar("prevVal", prevVal));
		
		
		
		if(c=='A') {
			
			if (sA>eA ) {
				
				recursionPrintTree.printResult(Util.printArraySliceAsString(vector, 0, vector.length-1, ", "));
				return;
			
			}
			
			if(sourceA[sA]>prevVal) {
				
				vector[vectorIndex]=sourceA[sA];
				//Not optimize fun(sA+1,eA, sB,eB, 'B', sourceA[sA], vectorIndex+1,level+1);
				if(eB>sB) {
					int midB=((eB-sB)/2)+sB;
					if (sourceB[midB]<sourceA[sA]) {
						fun(sA+1,eA, midB+1,eB, 'B', sourceA[sA], vectorIndex+1,level+1);
					} else {
						fun(sA+1,eA, sB,midB, 'B', sourceA[sA], vectorIndex+1,level+1);
					}
				} else {
					fun(sA+1,eA, sB,eB, 'B', sourceA[sA], vectorIndex+1,level+1);
				}
				
				vector[vectorIndex]=null;
				
			}
			
			
			
			fun( sA+1 , eA, sB, eB, c, prevVal,vectorIndex,level);
			
			
		} else {
			
			if (sB>eB ) {
				//recursionPrintTree.printResult(Util.printArraySliceAsString(vector, 0, vector.length-1, ", "));
				return;
			
			}
			
			if(sourceB[sB]>prevVal) {
				
				vector[vectorIndex]=sourceB[sB];
				//Not optimize fun(sA,eA, sB+1,eB,'A',sourceB[sB],vectorIndex+1,level+1);
				if (eA>sA) {
					int midA=((eA-sA)/2)+sA ;
					if (sourceA[midA]<sourceB[sB]) {
						fun(midA+1,eA, sB+1,eB,'A',sourceB[sB],vectorIndex+1,level+1);
					} else {
						fun(sA,midA, sB+1,eB,'A',sourceB[sB],vectorIndex+1,level+1);
					}
				} else {
					fun(sA,eA, sB+1,eB,'A',sourceB[sB],vectorIndex+1,level+1);
				}
				
				vector[vectorIndex]=null;
				
			}
			
			
			fun( sA , eA, sB+1, eB, c, prevVal,vectorIndex,level);
			
		}
		
		
		
		
	}


	private static void funBAK(int sA, int eA, int sB, int eB, char c,int prevVal,int vectorIndex,int level) {
		
		RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
		
		
		recursionPrintTree.printHeaderCall( gArrayVar("sourceA", sourceA, sA, eA),gArrayVar("sourceB", sourceB, sB, eB),gVar("c", c),gVar("prevVal", prevVal));
		
		if((sA>eA && c=='A' ) || (sB>eB && c=='B') ) {
			
			//Util.printArray(vector);
			vector[vectorIndex]=null;
			return;
		}
		
		
		
		if(c=='A') {
			int newPrevVal=0;
			if(sourceA[sA]>prevVal) {
				
				//Util.printlnLine(sourceA[sA]);
				vector[vectorIndex]=sourceA[sA];
				newPrevVal=sourceA[sA];
				
				
				
			}
			
			if (sB>eB ) {
				//Util.printArray(vector);
				vector[vectorIndex]=null;
				return;
			}
			/**/
			int midB=((eB-sB)/2) + sB;
			if (sourceB[midB]<prevVal) {
				for (int j=0;j<(eB-sB);j++ ) {
				fun(sA+1,eA, (midB+1)+j ,eB,'B',newPrevVal,vectorIndex+1,level+1);
				}
			} else {
				for (int j=0;j<(eB-sB);j++ ) {
				fun(sA+1,eA,sB,midB-j,'B',newPrevVal,vectorIndex+1,level+1);
				}
			}
			
			if(prevVal==Integer.MIN_VALUE) {
				String debugString="";
				System.out.print("");
			}
			
			vector[vectorIndex]=null;
			
			// else {
			//vector[vectorIndex]=null;
				fun(sA+1, eA, sB, eB, 'B', prevVal,vectorIndex,level+1);
			//}
			

		} else {
			int newPrevVal=0;
			if(sourceB[sB]>prevVal) {
				
				//Util.printlnLine(sourceB[sB]);
				vector[vectorIndex]=sourceB[sB];
				newPrevVal=sourceB[sB];
	
			}
			
			
			if (sA>eA) {
				//Util.printArray(vector);
				vector[vectorIndex]=null;
				return;
			}
			/**/
			int midA=((eA-sA)/2) + sA ;
			if (sourceA[midA]<prevVal) {
				for (int j=0;j<(eA-sA);j++ ) {
				fun(midA+1+j,eA,sB+1,eB,'A',newPrevVal,vectorIndex+1,level+1);
				}
			} else {
				for (int j=0;j<(eA-sA);j++ ) {
				fun(sA,midA-j,sB+1,eB,'A',newPrevVal,vectorIndex+1,level+1);
				}
			}
			
			vector[vectorIndex]=null;
			
			//else {
			//vector[vectorIndex]=null;
				fun(sA,eA,sB+1,eB,'A',prevVal,vectorIndex,level+1);
			//}
			
		}
		
		
		
		
		
		
		
	}
	
	
	
	

}
