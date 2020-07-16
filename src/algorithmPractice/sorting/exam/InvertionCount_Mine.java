
package algorithmPractice.sorting.exam;

import util.Util;

public class InvertionCount_Mine {
	
	static Integer[] elements = new Integer[] { 10,4,3,2,1};
	static int countInvertion=0;
	public static void main(String[] args) {
		
		
		Util.printArray(elements, ", ");

		
		
		
		for (int i=0;i<elements.length-1;i++) {
			
			for(int j=i+1;j<elements.length;j++) {
				
				if (elements[i]>elements[j]) {
					countInvertion++;
					Util.printlnLine(elements[i]+"-"+elements[j]);
				}
				
			}
			
		}
		Util.printlnLine(countInvertion);
		
	}
}
	

	


		
		
		