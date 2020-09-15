package algorithmPractice.combination.exam;

import util.Util;

public class Permutation_election {

	static String[] elements_;
	static String[] permutation;
	static boolean[] visited;
	
	public static void main(String[] args) {
		
		
		elements_ = new String[] {"A","B","C"};
		permutation = new String[elements_.length];
		visited = new boolean[elements_.length];
		
		
		setPermutation(0);
		
	}
	
	
	static void setPermutation(int indx) {
		
		if (indx==permutation.length) {
			Util.printArray(permutation, ",");
			return;
		}
		
		
		
		for (int i=0;i<permutation.length;i++) {
			
			if(!visited[i]) {
				
			visited[i]=true;
			permutation[indx]=elements_[i];
			setPermutation(indx +1);
			permutation[indx]=null;
			visited[i]=false;
			
			}
					
						
		}
		
		
		
		
		
	}
	

}
