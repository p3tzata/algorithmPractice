package algorithmPractice.recursion.gfg.myselfTry;


import util.Util;
import util.funcPrintTree.RecursionPrintTree;


import static util.funcPrintTree.StrBuilder.*;

public class ConvertStringToInteger {

	private static String[] string;
	
	
	public static void main(String[] args) {
	
		
		string= new String[] { "1","2","3","4"};
		//string= new String[] { "10"};
		String str = "s23";
		
		Util.printlnLine(funcUtil(0));
		//Util.printlnLine(str.charAt(0)-'0');
		
	}

	private static int funcUtil(int indx) {
		
		try { 
			//return funcReverse(indx);
			return func(0,0,0) ;
			
			
		} catch (Exception e) {
			return 0;
		}
		
	}
	

	
	private static int func(int indx,int result,int level) {
		RecursionPrintTree recursionPrintTree = new RecursionPrintTree(level);
		recursionPrintTree.printFuncCall(gVar("indx", indx));
		
		
		if(indx==string.length) {
			recursionPrintTree.printResultBase(result);
			return result;
		}
		
		Integer posInt = Integer.valueOf(string[indx]);
		
		int newResult = result * 10 + posInt;
		recursionPrintTree.printPreRecursion(recursionPrintTree.strBuilder.exp().var_("newResult", newResult).eq().var_("result", result).opr("*").const_(10).opr("+").var_("posInt", posInt).endExp());
		int res = func(indx+1, newResult ,level+1 );
		recursionPrintTree.printResult(res);
		return res ;
		
		
		
		
		
	}
	
	
	private static int funcReverse(int indx) {
		
		if(indx==string.length-1) {
			
			return Integer.valueOf(string[indx]) ;
		}
		
		int result = funcReverse(indx+1);
		
		
		
		Integer posInt = Integer.valueOf(string[indx]);
		
		return (int) ((posInt*Math.pow(10, string.length-indx-1)) + result);
		
		
		
		
		
	}
	
	
}
