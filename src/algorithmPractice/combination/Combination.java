package algorithmPractice.combination;

import util.Util;

public class Combination {

	static String[] srcArray = new String[] {"A","B","C"};
	static String[] vector = new String[2];
	
	public static void main(String[] args) {


		combination(0,0);

	}

	static private void combination(int indx,int bound) {
		
		if(indx>=vector.length) {
			Util.printArray(vector, ",");
			return;
		}
		
		
		for (int i=bound;i<srcArray.length;i++) {
			
			vector[indx]=srcArray[i];
			combination(indx+1,i+1);
			
		}
		
		
		
	}

}
