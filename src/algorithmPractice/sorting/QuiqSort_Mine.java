package algorithmPractice.sorting;

import util.Util;

public class QuiqSort_Mine {
	
	static Integer[] elements = new Integer[] { 3,1,34,31,64,31,39,78,8,97,5};
//	static Integer[] elements = new Integer[] { 1,5,9,2,6};
//	static Integer[] elements = new Integer[] { 1,5,6,2,9};
	
	public static void main(String[] args) {
	
		Util.printArray(elements, ", ");
		
		
		quickSort(0,elements.length-1);
		
		
		Util.printArray(elements, ", ");
		
		
		
	}

	private static void quickSort(int a, int b) {
		
		if(a==b || a>b) {
			return;
		}
		
		int j=a;
		int pivot=b;
		int m=pivot;
		
		
		
		
		while(j<m) {
			
			if (elements[j]<=elements[pivot]) {
				j++;				
			} else {
				m--;
				Util.swap(elements, j, m);
			}
			
			
			
		}
		//Util.printlnLine(m);
		Util.swap(elements, pivot, m);
		quickSort(a, m-1);
		quickSort(m+1,b);
		
		
		
	}
}
