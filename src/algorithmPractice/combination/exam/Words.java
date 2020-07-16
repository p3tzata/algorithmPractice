package algorithmPractice.combination.exam;

import java.util.HashSet;

import util.Util;

public class Words {

	//static String[] srcArray = new String[] {"A","H","A","H","A","H","A"};
	//static String[] srcArray = new String[] {"A","A","H","H","H","A","A",};
	static String[] srcArray = new String[] {"A","A","B","C"};
	static Integer cnt=0;
	
public static void main(String[] args) {
		
		
		//Util.printArray(srcArray, ",");
		
		
	//remutation_rep_withOutRestriction(0);
	remutation_rep(0);
		Util.printlnLine(cnt);
		

	}

public static void remutation_rep(int index) {
	  if (index >= srcArray.length) {
		  int n=0;
			boolean isOk=true;
			while (n<=srcArray.length-2) {
				String str1=srcArray[n];
				String str2=srcArray[n+1];
				if(str1.equals(str2)) {
					isOk=false;
					break;
				}
				n++;
				
			}
			if(isOk) {
				Util.printArray(srcArray, ",");
			}
	    cnt++;
	    return;
	  }
	else {
		HashSet<String> swapped = new HashSet<>();
	
	    for (int i = index; i < srcArray.length; i++) {
	      if (!swapped.contains(srcArray[i])) {
	        Util.swap(srcArray,index, i);
	        remutation_rep(index + 1);
	        Util.swap(srcArray,index, i);
	        swapped.add(srcArray[i]);
	      }
	    }
	    
	}
	}



public static void remutation_rep_withOutRestriction(int index) {
	  if (index >= srcArray.length) {
		  
				Util.printArray(srcArray, ",");
			
	    cnt++;
	    return;
	  }
	else {
		HashSet<String> swapped = new HashSet<>();
	
	    for (int i = index; i < srcArray.length; i++) {
	      if (!swapped.contains(srcArray[i])) {
	        
	    	Util.swap(srcArray,index, i);
	    	remutation_rep_withOutRestriction(index + 1);
	        Util.swap(srcArray,index, i);
	        swapped.add(srcArray[i]);
	        
	      }
	    }
	    
	}
	}



	
private static void permutation_swap(int depth) {
		
		
	
	
		if(depth==srcArray.length) {
			
			
			int n=0;
			boolean isOk=true;
			while (n<=srcArray.length-2) {
				String str1=srcArray[n];
				String str2=srcArray[n+1];
				if(str1.equals(str2)) {
					isOk=false;
					break;
				}
				n++;
				
			}
			if(isOk) {
				Util.printArray(srcArray, ",");
			}
			cnt++;
			return;
		}
		
	
		permutation_swap(depth+1);
		
		
		
		for(int i=depth+1;i<srcArray.length;i++) {
			
			if (srcArray[depth]!=srcArray[i]) {
			
			Util.swap(srcArray, depth,i);
			permutation_swap(depth+1);
			Util.swap(srcArray, depth,i);
			
			}
			
			
		}
		
		
		
		
		
		
	}

	
}
