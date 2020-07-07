package algorithmPractice.sorting;



import util.Util;

public class SelectionSort {

	
	private static Integer[] elements;
	private static Integer tmpInteger;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		elements = new Integer[] {6,9,3,4,1};
		
		Util.printArray(elements, " ");
		
		for (int i=0;i<elements.length-1;i++) {
			
			for (int j=i+1;j<elements.length;j++) {
				
				if(elements[j]<elements[i]) {
					tmpInteger=elements[i];
					elements[i]=elements[j];
					elements[j]=tmpInteger;
				}
				
			}
						
		}
		
		Util.printArray(elements, " ");
		
		
		
	}

}
