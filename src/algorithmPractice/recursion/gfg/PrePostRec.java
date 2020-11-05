package algorithmPractice.recursion.gfg;


public class PrePostRec { 
    static void printFun(int test) 
    { 
        if (test < 1) 
            return; 
        else { 
            System.out.printf("S%d ", test); 
            printFun(test - 1); // statement 2 
            System.out.printf("F%d ", test); 
            //return; 
        } 
    } 
  
    public static void main(String[] args) 
    { 
        int test = 3; 
        printFun(test); 
    } 
}