package algorithmPractice.combination;




import util.Util;

public class Permutation {
	
	static String[] srcArray = new String[] {"A","B","C"};
	static String[] vector = new String[srcArray.length];
	static Integer[] used = new Integer[srcArray.length];

	public static void main(String[] args) {
		
		
		//Util.printArray(srcArray, ",");
		
		//permutation(0);
		//permutation_iteration();
		//permutation_swap(0);
		//heapPermutation(srcArray.length);
		
		
		Util.printlnLine(2 % 2);
		

	}
	
	
	static void heapPermutation(int size) 
    { 
        // if size becomes 1 then prints the obtained 
        // permutation 
        if (size == 1) {
            Util.printArray(srcArray, ",");
        }
        
        
        for (int i=0; i<size; i++) 
        { 
            heapPermutation(size-1); 
  
            // if size is odd, swap first and last 
            // element 
            if (size % 2 == 1) 
            { 
                String temp = srcArray[0]; 
                srcArray[0] = srcArray[size-1]; 
                srcArray[size-1] = temp; 
            } 
  
            // If size is even, swap ith and last 
            // element 
            else
            { 
            	String temp = srcArray[i]; 
                srcArray[i] = srcArray[size-1]; 
                srcArray[size-1] = temp; 
            } 
        } 
    } 
	
	
	

	private static void permutation_swap(int depth) {
		
		if(depth==srcArray.length) {
			Util.printArray(srcArray, ",");
			return;
		}
		permutation_swap(depth+1);
		
		for(int i=depth+1;i<srcArray.length;i++) {
			
			Util.swap(srcArray, depth,i);
			permutation_swap(depth+1);
			Util.swap(srcArray, depth,i);
			
			
		}
		
		
		
		
		
		
	}

	private static void permutation_iteration() {
		
		for (int i=0;i<srcArray.length;i++) {
			if(used[i]==null) {
			vector[0]=srcArray[i];
			used[i]=1;
			for (int ii=0;ii<srcArray.length;ii++) {
				if(used[ii]==null) {
				vector[1]=srcArray[ii];
				used[ii]=1;
				for (int iii=0;iii<srcArray.length;iii++) {
					if(used[iii]==null) {
					vector[2]=srcArray[iii];
					used[iii]=1;
					Util.printArray(vector, ",");
					used[iii]=null;
					}
					
					
				}
				used[ii]=null;
				}
				
			}
			used[i]=null;
			}
			
			
		}
		
		
	}

	private static void permutation(int depth) {
		
		if (depth>=vector.length) {
			Util.printArray(vector, ",");
			return;
		}
		
		
		
		for (int i=0;i<srcArray.length;i++) {
			if(used[i]==null) {
			vector[depth] = srcArray[i];
			used[i]=1;
			permutation(depth + 1);
			used[i]=null;
			}
		}
		
		
		
		
	}

}



/*
 
 ABC
 ACB
 CAB
 CBA
 BCA
 
 
 
 
 */