package algorithmPractice.misc;



public class Stan {

	public static void main(String[] args) {
		Integer[] input = new Integer[] {1,1,0,0,0,-1,1,1,1};
		int[] result =new int[3];
		
			
		
		for (int i=0;i<input.length;i++) {
			
			result[ input[i] + 1 ]++;
			
			
		}
		
		
		for (int i=0;i<result.length;i++) {
			
			System.out.println("Result from "+ (i-1) +" is "+ result[i]);
			
			
		}		
		
		
		
		
	}

}
