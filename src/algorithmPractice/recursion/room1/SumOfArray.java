package algorithmPractice.recursion.room1;



import util.Util;

public class SumOfArray {

	
	static Integer intArray[] = { 1, 2, 3, 4, 5 };
		
	public static void main(String[] args) {
		
			
		
		Util.printArray(intArray," ");
		Util.printlnLine( sumRecursion(0));
				

	}
	
	
	private static Integer sumRecursion(int index) {
		
		if (index==intArray.length-1) {
			
			return intArray[intArray.length-1];
			
		} else {
		
			Integer curSumInteger = intArray[index] + sumRecursion(index  + 1);
			Util.printlnLine( curSumInteger);
		return curSumInteger;
		
		}
		
	}
	
	
	
	

}
