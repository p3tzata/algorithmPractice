
package algorithmPractice.sorting;

import util.Util;

public class MergeSort_Mine {
	
	static Integer[] elements = new Integer[] { 1000,4,1,6,9,8,58,44,26,5,444,59,78};
	
	public static void main(String[] args) {
		
		
		Util.printArray(elements, ", ");
		int a=0;
		
		int b=(elements.length-1);
		
		recursionMerge(a,b);
		
		Util.printArray(elements, ", ");
	//prepare();
		
		
		
		
	}
	
	
	static void recursionMerge(int a, int b) {
		
		//Print.printArraySlice(elements, a, b, ",");
		if(a==b || a>b) {
			return;
		}
		
		int c=(b-a)/2;
		recursionMerge(c+1+a, b);
		recursionMerge(a, c+a);
		
			
		afterRecursion(a, c+a,c+1+a, b);		
		//Print.printArraySlice(elements, a, b, ",");
		
	}
	
	
	
	
	static void afterRecursion(int a, int b,int m,int n) {
		Integer[] tmpElements = new Integer[a+n+1];
		int tmpIndex=0;
		int i=a;
		int j=m;
		
		while (i<=b && j<=n) {

			if (elements[i]>elements[j]) {
				tmpElements[tmpIndex]=elements[j];
				j++;
				tmpIndex++;
				continue;
			}
			
			if (elements[i]<=elements[j]) {
				tmpElements[tmpIndex]=elements[i];
				i++;
				tmpIndex++;
				continue;
			}
						
		}
		
		if (i<=b) {
			while(i<=b) {
				tmpElements[tmpIndex]=elements[i];
				tmpIndex++;
				i++;
			}
		}
		
		if (j<=n) {
			while(j<=n) {
				tmpElements[tmpIndex]=elements[j];
				tmpIndex++;
				j++;
			}
		}
		
		tmpIndex=0;
		//while(tmpIndex<tmpElements.length) {
		for (int h=a;h<=n;h++) {
			elements[h]=tmpElements[tmpIndex];
			tmpIndex++;
		}
		//}
		
		
	}
	


	private static void prepare() {

		
		
		
		
		//Integer[] elements = new Integer[] { 1 , 3 , 5, 7, 4, 6,8  };
		Integer[] elements = new Integer[] { 1  };
		Integer[] tmpElements = new Integer[elements.length];
				
		Util.printArray(elements, " ");
		int tmpIndex=0;
		
		int a=0;
		int i=0;
		int b=(elements.length-1)/2;
		
		int m=((elements.length-1)/2) + 1;
		int j=((elements.length-1)/2) + 1;
		int n=(elements.length-1);
			
	
		
		while (i<=b && j<=n) {

			if (elements[i]>elements[j]) {
				tmpElements[tmpIndex]=elements[j];
				j++;
				tmpIndex++;
				continue;
			}
			
			if (elements[i]<=elements[j]) {
				tmpElements[tmpIndex]=elements[i];
				i++;
				tmpIndex++;
				continue;
			}
						
		}
		
		if (i<=b) {
			while(i<=b) {
				tmpElements[tmpIndex]=elements[i];
				tmpIndex++;
				i++;
			}
		}
		
		if (j<=n) {
			while(j<=n) {
				tmpElements[tmpIndex]=elements[j];
				tmpIndex++;
				j++;
			}
		}
		tmpIndex=0;
		while(tmpIndex<tmpElements.length) {
			elements[tmpIndex]=tmpElements[tmpIndex];
			tmpIndex++;
		}
		
		Util.printArray(elements, ", ");
		
		
		
		//int middleIndex = (elements.length-1)/2;
		
		//Print.printArraySlice(elements, 0, middleIndex, " ");
		//Print.printArraySlice(elements, middleIndex+1, elements.length-1, " ");
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	

}
