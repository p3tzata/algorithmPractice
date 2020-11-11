package algorithmPractice.combination;

import util.Util;
import util.funcPrintTree.RecursionPrintTree;

public class Combination {

	static String[] srcArray = new String[] {"A","B","C","D"};
	static String[] vector = new String[2];
	
	public static void main(String[] args) {


		combination(0,0,0);

	}

	static private void combination(int indx,int bound,int level) {
		
		RecursionPrintTree recursionPrintTree = new RecursionPrintTree(level);
		recursionPrintTree.printHeaderCall(indx, bound);
		
		if(indx>=vector.length) {
			
			
			//Util.printArray(vector, ",");
			String resultString=Util.printArrayAsString(vector, ",");
			recursionPrintTree.printResultBase(resultString );
			
			return;
		}
		
		
		for (int i=bound;i<srcArray.length;i++) {
			
			vector[indx]=srcArray[i];
			combination(indx+1,i+1,level+1);
			
		}
		
		
		
	}

}
