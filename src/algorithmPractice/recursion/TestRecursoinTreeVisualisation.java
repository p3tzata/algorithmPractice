package algorithmPractice.recursion;


import util.funcPrintTree.RecursionPrintTree;

import static util.funcPrintTree.StrBuilder.*;


public class TestRecursoinTreeVisualisation {
	
	
	static int fnc(int n, int k, int level) {
	    
		RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
		recursionPrintTree.printHeaderCall(gVar("n", n)  , gVar("n", n));
		
		recursionPrintTree.printPreRecursion("Pree");
		
	    int result;
	    	    
	    if ((n <= 1) || (k <= 1)) {
	        result = n + k;
	        
	    } else {
	   
	        result = fnc(n - 1, k, level + 1) + fnc(n, k - 1, level + 1);
	    }
	    
	    recursionPrintTree.printPostRecursion("post");
	   
	    recursionPrintTree.printResult( result);
	    
	    
	    
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
	    		 	.then_().exp("stock", 33,"i", 45).const_(45).endExp()
	    		 	.else_().exp("wrongResult", num/2).var_("num", num).opr("/").const_(2).endExp()
	    		 ._if().build()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.comment_("test comment").build()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.exp("foo", 20/2).var_("bar", 20).opr("/").const_(2).endExp()
	     );
	     
	     
	     System.out.println(
	    		 tree.strBuilder.exp("foo", 20/2).var_("bar", 20).opr("/").const_(2).andExp("arrVar", 100/2, "i",4).var_("num", 100).opr("/").const_(2).endExp()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.for_().exp("i", "").const_(0).andExp().var_("i", 0).opr("<").const_(10).andExp("i++", "").endExp()._for()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.while_().exp("tst", 20<100).var_("num", 20).opr("<").const_(100).endExp()._while()
	     );
	    
	}
	

}
