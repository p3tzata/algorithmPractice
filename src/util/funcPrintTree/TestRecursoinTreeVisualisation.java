package util.funcPrintTree;


<<<<<<< HEAD:src/util/funcPrintTree/TestRecursoinTreeVisualisation.java
import static util.funcPrintTree.RecursionPrintTree.*;
=======
import static util.funcPrintTree.StrBuilder.*;
>>>>>>> 46f73fc614270b6c6ff699612af649d3995ce79b:src/algorithmPractice/recursion/TestRecursoinTreeVisualisation.java


public class TestRecursoinTreeVisualisation {
	
	
	static int fnc(int n, int k, int level) {
	    
		RecursionPrintTree recursionPrintTree=new RecursionPrintTree(level);
<<<<<<< HEAD:src/util/funcPrintTree/TestRecursoinTreeVisualisation.java
		recursionPrintTree.printFuncCall(gVar("n", n)  , gVar("n", n));
=======
		Integer[] intArray = new Integer[] {0,1,2,3,4,5,6,7};
		
		recursionPrintTree.printHeaderCall(gVar("n", n)  , gVar("n", n), gArrayVar("intArray", intArray, 2, 4));
>>>>>>> 46f73fc614270b6c6ff699612af649d3995ce79b:src/algorithmPractice/recursion/TestRecursoinTreeVisualisation.java
		
		recursionPrintTree.printPreRecursion("Pre");
		
	    int result;
	    	    
	    if ((n <= 1) || (k <= 1)) {
	        result = n + k;
	        
	    } else {
	   
	        result = fnc(n - 1, k, level + 1) + fnc(n, k - 1, level + 1);
	    }
	    
	    recursionPrintTree.printPostRecursion("post");
	   
	    recursionPrintTree.printResult(result);
	    
	    
	    
	    return result;
	}

	

	public static void main(String[] args) {
		int num=10;
		RecursionPrintTree tree=new RecursionPrintTree(0);
<<<<<<< HEAD:src/util/funcPrintTree/TestRecursoinTreeVisualisation.java
	    fnc(2, 2, 0);
	    System.out.println(System.lineSeparator()+ 	"==========" +System.lineSeparator()  );	    
=======
	    fnc(3, 3, 0);
	    	    
>>>>>>> 46f73fc614270b6c6ff699612af649d3995ce79b:src/algorithmPractice/recursion/TestRecursoinTreeVisualisation.java
	     
	     System.out.println(
	    		 tree.strBuilder.var_("num", num).build()
	     );
	    
	     System.out.println(
	    		 tree.strBuilder.if_().exp().var_("test", num%2==1).eq().C().var_("num", num).opr("%").const_(2).D().opr("==").const_(1).endExp()
	    		 	.then_().exp().var_(gVar("stock", 33),gVar("i", 45)).eq().const_(45).endExp()
	    		 	.else_().exp().var_("wrongResult", num/2).eq().var_("num", num).opr("/").const_(2).endExp()
	    		 ._if().build()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.comment_("test comment").build()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.exp().var_("foo", 20/2).eq().var_("bar", 20).opr("/").const_(2).endExp()
	     );
	     
	     
	     System.out.println(
	    		// tree.strBuilder.exp().var_("foo", 20/2).eq().var_("bar", 20).opr("/").const_(2).and().var_("arrVar", 100/2, "i",4).eq().var_("num", 100).opr("/").const_(2).endExp()
	    		 tree.strBuilder.exp().var_("foo", 20/2).eq().var_("bar", 20).opr("/").const_(2).and().var_(gVar("arrVar", 100/2), gVar("i", 4)).eq().var_("num", 100).opr("/").const_(2).endExp()
	     ); 
	     
	     System.out.println(
	    		 tree.strBuilder.for_().exp().var_("i", "").eq().const_(0).and().var_("i", 0).opr("<").const_(10).and().var_("i++", "").endExp()._for()
	     );
	     
	     System.out.println(
	    		 tree.strBuilder.while_().exp().var_("tst", 20<100).eq().var_("num", 20).opr("<").const_(100).endExp()._while()
	     );
	     
	}
	

}
