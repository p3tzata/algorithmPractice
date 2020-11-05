package algorithmPractice.recursion.gfg;

import util.Util;

public class FactAggr {

	public static void main(String[] args) {
		int fact = fact(5);
		Util.printlnLine(fact);
		
	}
	
	static int factTR(int n, int a) 
    { 
        if (n == 0)  
            return a; 
      
        return factTR(n - 1, n * a); 
    } 
      
    // A wrapper over factTR 
    static int fact(int n) 
    { 
        return factTR(n, 1); 
    } 
	

}
