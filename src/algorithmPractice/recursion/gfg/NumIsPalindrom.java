package algorithmPractice.recursion.gfg;


import static util.funcPrintTree.StrBuilder.*;
import util.Util;
import util.funcPrintTree.RecursionPrintTree;

public class NumIsPalindrom {
	
	 static int IniNum=1331;
	
	public static void main(String[] args) {
	
	
  	try {
		isPalUtil(IniNum,0);
		Util.printlnLine("YES");
	} catch (Exception e) {
		Util.printlnLine("NO");
	}
  	
  	

	}	
	
	
	
	public static int isPalUtil (int num,int level) throws Exception { 
   
		RecursionPrintTree tree = new RecursionPrintTree(level);
		tree.printFuncCall(gVar("num:",num));
        // base condition to return once we  
        // move past first digit 
		int dupNum;
        if (num == 0) { 
        	tree.printResult(tree.strBuilder.var_("dupNum", IniNum));
            return IniNum; 
        } else { 
        	int preOperationResult=num / 10;
        	//tree.printPreRecursion(frmStr_buildExp("num", preOperationResult, frmStr_var("num", num) + frmStr_operator("/") + frmStr_const(10)  ));
        	tree.printPreRecursion(tree.strBuilder.exp().Cc().var_("num", num/10).eq().var_("num", num).opr("/").const_(10).Dc().endExp().build() );
        	
            dupNum = isPalUtil(preOperationResult,level+1); 
        } 
        
        // Check for equality of first digit of 
        // num and dupNum
        
        tree.printPostRecursion(
        		
        		/*
        		tree.strBuilder.if_().exp("tst", (num % 10 == dupNum % 10)).C().var_("num", num).opr("%").const_(10).D()
        																	.opr("==")
        																	.C().var_("dupNum", dupNum).opr("%").const_(10).D().endExp()
        						.then_().exp("dupNum", dupNum/10).var_("dupNum", dupNum).opr("/").const_(10).endExp()
        						.else_().exp("throw Exception", "").endExp()
        						._if()        						
        		*/
        		tree.strBuilder.if_().exp().var_("tst", (num % 10 == dupNum % 10)).eq().C().var_("num", num).opr("%").const_(10).D().opr("==")
				.C().var_("dupNum", dupNum).opr("%").const_(10).D().endExp()
				.then_().exp().var_("dupNum", dupNum/10).eq().var_("dupNum", dupNum).opr("/").const_(10).endExp()
				.else_().exp().var_("throw Exception", "").eq().endExp()._if()
        		
        		
        );
        
        if (num % 10 == dupNum % 10) { 
            // if first digit values of num and  
            // dupNum are equal divide dupNum 
            // value by 10 to keep moving in sync 
            // with num. 
        	int result=dupNum / 10;
        	tree.printResult(tree.strBuilder.var_("dupNum", result));
            return result; 
        } else { 
            // At position values are not  
            // matching throw exception and exit.  
            // no need to proceed further. 
            throw new Exception(); 
        } 
   
    }
	
	
	
	

}
