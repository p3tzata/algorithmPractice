package algorithmPractice.combination.exam;

import java.lang.reflect.InaccessibleObjectException;
import java.util.HashSet;

import util.Util;

public class Shooting {

	private static Integer[] target;
	private static Integer[] perm;
	private static boolean[] visited;
	private static int targetSum=10;
	
	public static void main(String[] args) {
		
		
		target = new Integer[] {1,2,3,4,5};
		perm = new Integer[target.length];
		visited= new boolean[target.length] ;
		
		
		
		//genPerm(0,0);
		
		genSwap(0,0);
		
	}


	private static void genPerm(int depth,int sum) {
		
		if(depth==perm.length || targetSum==sum) {
			if (sum==targetSum) {
			Util.printArraySlice(perm, 0, depth-1	, ", ");
			}
			return;
		}
		
		
		for(int i=0;i<target.length;i++) {
			if(!visited[i]) {
			
			perm[depth]=target[i];
			int curSum=target[i]*(depth+1);
			visited[i] = true;
			genPerm(depth+1,sum+curSum);
			
			
			visited[i] = false;
			
			}
			
			
		}
		
		
	}


	public static void genSwap(int depth,int sum) {
		
	  if (depth >= perm.length) {
		  //Util.printArraySlice(target, 0, depth-1	, ", ");
		  return;
	  }
	    else {
	    
	    int curSum=target[depth]*(depth+1);	
	    if ((curSum+sum)==targetSum) {
	    	Util.printArraySlice(target, 0, depth	, ", ");
			  return;
	    }
	    genSwap(depth + 1,sum+curSum);
	    
	    	HashSet<Integer> swapped = new HashSet<Integer>();
	    	
	    for (int i = depth + 1; i < perm.length; i++)
	    {
	    if (!swapped.contains(target[i])) {
	      Swap(depth, i);
	      curSum=target[depth]*(depth+1);	
	      if ((curSum+sum)==targetSum) {
		    	Util.printArraySlice(target, 0, depth	, ", ");
		    	Swap(depth, i);
				  return;
		    }
	      genSwap(depth + 1,sum+curSum);
	      Swap(depth, i);
	    }
	    }
	    
	}
  }


	private static void Swap(int depth, int i) {

		int tmp=target[depth];
		target[depth]=target[i];
		target[i]=tmp;
		
	}



}
