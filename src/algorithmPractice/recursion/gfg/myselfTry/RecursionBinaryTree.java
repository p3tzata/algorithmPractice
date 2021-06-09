package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class RecursionBinaryTree {
	
	//static int[] tree = new int[] {890, 325, 290, 530, 965};
	//static int[] tree = new int[] {3,2,4};
	static int[] tree = new int[] {5,2,3,6};
	public static void main(String[] args) {
		
		
		fun(0,Integer.MAX_VALUE);
		
		
	}


	private static int fun(int i,int parrentValue) {
		int curVal=tree[i];
		
		if(i==tree.length-1) {
			Util.printlnLine(curVal);
			return 0;
			
		}
		
		
		
		int left=0;
		
		
		
		if(tree[i]>tree[i+1]) {
			int leftVal=tree[i+1];
			left=fun(i+1,tree[i])+1;
			Util.printlnLine(curVal+" left:"+leftVal);
		}
		
		int right=i+left+1;
		
		if( tree[i]<tree[right] && parrentValue> tree[right] ) {
			int rightVal=tree[right];
			right=fun(right, tree[i])+1;
			Util.printlnLine(curVal+" right:"+rightVal);
			
		} else {
			right=0;
		}
		
	    
		if(left==0 && right==0) {
		
		Util.printlnLine(curVal);
		}
		
		return left+right;
		
		
	}
	
	
	
	
	
	
}
