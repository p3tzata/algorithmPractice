package algorithmPractice.combination;

import util.Util;
import util.funcPrintTree.RecursionPrintTree;
import static util.funcPrintTree.StrBuilder.*;

public class Combination {

	static String[] srcArray = new String[] {"A","B","C","D"};
	static String[] vector = new String[2];
	
	public static void main(String[] args) {


		combination(0,0,0);

	}

	static private void combination(int indx,int bound,int level) {
		
		RecursionPrintTree tree = new RecursionPrintTree(level);
		//tree.printHeaderCall("indx:"+indx,"bound:"+ bound);
		tree.printHeaderCall(gVar("indx",indx),gVar("bound", bound));
		
		if(indx>=vector.length) {
			
			
			//Util.printArray(vector, ",");
			String resultString=Util.printArrayAsString(vector, ",");
			tree.printResultBase(resultString );
			
			return;
		}
		
		tree.printPreRecursion(tree.strBuilder.for_().exp("i", bound).var_("bound", bound).andExp().var_("i", "").opr("<").var_("srcArray.lenght", srcArray.length).andExp().var_("i++", "").endExp()._for());
		for (int i=bound;i<srcArray.length;i++) {
			tree.printPreRecursion(tree.strBuilder.exp("vector", srcArray[i], "indx",indx).var_("srcArray",srcArray[i] ,"i",i).andExp("bound", i+1).var_("i", i).opr("+").const_(1).endExp()  );
			
			vector[indx]=srcArray[i];
			combination(indx+1,i+1,level+1);
			
		}
		
		
		
	}

}
