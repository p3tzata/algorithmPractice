package algorithmPractice.combination;

import util.Util;
import util.funcPrintTree.RecursionPrintTree;

import static util.funcPrintTree.StrBuilder.*;

public class Combination {

	static String[] srcArray = new String[] {"A","B","C"};
	static String[] vector = new String[2];
	
	public static void main(String[] args) {


		combination(0,0,0);

	}

	static private void combination(int indx,int bound,int level) {
		
		RecursionPrintTree tree = new RecursionPrintTree(level);
		tree.setIsEmptyLine(false);
		//tree.printHeaderCall("indx:"+indx,"bound:"+ bound);
		tree.printFuncCall(gVar("indx",indx),gVar("bound", bound));
		
		if(indx>=vector.length) {
			tree.printPreRecursion(tree.strBuilder.
					if_().exp().var_("tst", indx>=vector.length).eq().var_("indx", indx).opr(">=").var_("vector.length", vector.length).endExp()
					.then_().exp().return_().endExp()._if()
			);
			
			//Util.printArray(vector, ",");
			String resultString=Util.printArrayAsString(vector, ",");
			tree.printResultBase(resultString );
			
			return;
		}
		
		tree.printPreRecursion(tree.strBuilder.for_().exp().var_("i", bound).eq().var_("bound", bound).and().var_("i", "").opr("<").var_("srcArray.lenght", srcArray.length).and().var_("i++", "").endExp()._for());
		for (int i=bound;i<srcArray.length;i++) {
			tree.printPreRecursion(tree.strBuilder.exp()
					.Cc()
						.var_("indx",indx+1).eq().var_("indx", indx).opr("+").const_(1).and().var_("bound", i+1).eq().var_("i", i).opr("+").const_(1)
					.Dc().newLine()
						.var_(gVar("vector", srcArray[i]), gVar("indx",indx)).eq().var_(gVar("srcArray",srcArray[i]) ,gVar("i",i)).and()
					
					.endExp()  
					
					);
			
			vector[indx]=srcArray[i];
			combination(indx+1,i+1,level+1);
			
		}
		
		
		
	}

}
