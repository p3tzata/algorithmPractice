package algorithmPractice.recursion.room1;



import util.Util;

public class Vector01 {

	
	static Integer intArray[] = {5,5,5 };
	
	public static void main(String[] args) {
		
		draw(0);
	
	}
	
	private static void draw(int index) {
		
		if (index==intArray.length) {
			
			Util.printArray(intArray," ");
			
			
		} else {
			
			intArray[index]=0;
			draw(index+1);
			
			intArray[index]=1;
			draw(index+1);
			
			
		}
		
	
		
		
			
			
		
			
			
			
			//intArray[index]=var;
		//	Print.printArray(intArray);
		
			
			
}
		
		
		
	
			
	
	
}
