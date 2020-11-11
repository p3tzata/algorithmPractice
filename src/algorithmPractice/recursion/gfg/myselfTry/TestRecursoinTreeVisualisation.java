package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;
import util.funcPrintTree.ElseIf_;
import util.funcPrintTree.IStrBuilder;
import util.funcPrintTree.RecursionPrintTree;
import util.funcPrintTree.StrBuilder;
import util.funcPrintTree.ThenIf_;

public class TestRecursoinTreeVisualisation {
	
	
	static int fnc(int n, int k, int level) {
	    //System.out.println(String.format("%sfnc(%d, %d)", pad(level), n, k));
		RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
		recursionPrintTree.printHeaderCall( n , k);
		
		recursionPrintTree.printPreRecursion("Pree");
		
	    int result;
	    	    
	    if ((n <= 1) || (k <= 1)) {
	        result = n + k;
	        
	    } else {
	   
	        result = fnc(n - 1, k, level + 1) + fnc(n, k - 1, level + 1);
	    }
	    
	    recursionPrintTree.printPostRecursion("post");
	   
	    recursionPrintTree.printResult( result);
	    //System.out.println(String.format("%s<== %d", pad(level), result));
	    
	    
	    return result;
	}

	

	public static void main(String[] args) {
		int num=10;
		RecursionPrintTree tree=new RecursionPrintTree(0);
	    //fnc(3, 3, 0);
	    	    
	     
	     System.out.println(
	    		 tree.strBuilder.var_("num", num).build()
	     );
	    
	     System.out.println(
	    		 tree.strBuilder.if_().exp("test", num%2==1).C().var_("num", num).opr("%").const_(2).D().opr("==").const_(1).endExp()
	    		 	.then_().exp("stock", 33, 45).const_(45).endExp()
	    		 	.else_().exp("wrongResult", num/2).var_("num", num).opr("/").const_(2).endExp()
	    		 ._if().build()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.comment_("test comment").build()
	     );
	     
	     
	     
	    
	}
	

}
