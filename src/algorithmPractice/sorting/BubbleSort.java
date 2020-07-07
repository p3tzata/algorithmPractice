package algorithmPractice.sorting;

import util.Util;

public class BubbleSort {

	private static Integer[] elements;
	private static Integer tmpInteger;
	
	
	public static void main(String[] args) {


		elements = new Integer[] {6,9,3,4,1};
		
		Util.printArray(elements, " ");

		for(int i=0;i<elements.length;i++) {
			
			for(int j=0;j<elements.length-1;j++) {
				
				if(elements[j+1]<elements[j]) {
					tmpInteger=elements[j];
					elements[j]=elements[j+1];
					elements[j+1]=tmpInteger;
				}
				
			}

			
			
			
		}
		
		
		
		Util.printArray(elements, " ");
		
	}

}
