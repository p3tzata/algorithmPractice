package algorithmPractice.combination.training;

import util.Util;

public class Permutation_ {

	static String[] elements_;
	static Integer[] seats;
	static String[] permutation;
	static boolean[] visited;
	static int Kseats=10;
	
	public static void main(String[] args) {
		
		
		elements_ = new String[] {"A","B","C"};
		seats = new Integer[] {10,4,2};
		
		
		for (int i=0;i<=elements_.length;i++) {
		permutation = new String[i];
		visited = new boolean[elements_.length];
		setPermutation(0,0,0);
		}
		
		
		
		
	}
	
	
	static void setPermutation(int indx,int border,int sum) {
		
		if (indx==permutation.length) {
			if(Kseats<=sum) {
			Util.printArray(permutation, ",");
			Util.printlnLine("Sum:" + sum);
			}
			
			return;
		}
		
		
		
		for (int i=border;i<elements_.length;i++) {
			
			//if(!visited[i]) {
				
			//visited[i]=true;
			permutation[indx]=elements_[i];
			setPermutation(indx +1, i+1, sum+seats[i]);
			permutation[indx]=null;
			//visited[i]=false;
			
			//}
					
						
		}
		
		
		
		
		
	}
	

}
