package algorithmPractice.recursion.room1;



import util.Print;

public class SumOfArray {

	
	static Integer intArray[] = { 1, 2, 3, 4, 5 };
		
	public static void main(String[] args) {
		
			
		
		Print.printArray(intArray," ");
		Print.printlnLine( sumRecursion(0));
				

	}
	
	
	private static Integer sumRecursion(int index) {
		
		if (index==intArray.length-1) {
			
			return intArray[intArray.length-1];
			
		} else {
		
			Integer curSumInteger = intArray[index] + sumRecursion(index  + 1);
			Print.printlnLine( curSumInteger);
		return curSumInteger;
		
		}
		
	}
	
	
	
	

}
