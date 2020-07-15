package algorithmPractice.combination;



import util.Util;

public class Variation {

	static String[] srcArray = new String[] {"A","B","C"};
	static String[] vector = new String[2];
	static Integer[] used = new Integer[srcArray.length];
	
	public static void main(String[] args) {
		
		variation(0);
		
		
	}

	private static void variation(int indx) {


		if(indx>=vector.length) {
			Util.printArray(vector, ",");
			return;
		}
		
		for(int i=0;i<srcArray.length;i++) {
			if(used[i]==null) {
			vector[indx] = srcArray[i];
			used[i]=1;
			variation(indx+1);
			used[i]=null;
			
			}
			
		}
		
		
		
	}

}
