package algorithmPractice.recursion.gfg.myselfTry;

import java.util.ArrayList;
import java.util.List;

//TODO not working properly 
public class PossibleExpressions {

	private static List<Integer> listInt=new ArrayList<>();
	private static int Defaulttarget=6;
	
	
	public static void main(String[] args) {
	
		listInt.add(1);
		listInt.add(2);
		listInt.add(3);
		
		funRec("",listInt,Defaulttarget);
	
		
	}
	
	
	public static void funRec(String prefix,List<Integer> listInt, int target){
		
		if(listInt.size()==1) {
			int val=listInt.get(0);
			boolean testVal=val==target;
			
			if (testVal==true) {
				util.Util.printlnLine(prefix + "" + target );
				return;
			} else {
				return;
			}
		}
		
		
		for(int i=0;i<listInt.size();i++) {
			List<Integer> tmpList=new ArrayList<>(listInt);
			tmpList.remove(i);
			funRec(prefix+(listInt.get(i))+"+" , tmpList  , target-listInt.get(i) );
			
		}
		
		
	}
	
	/*
	private static void fun(String prefix,int startIndx, int finishIndx, int target) {
		
		
		if(finishIndx==startIndx) {
			
			if(arrayToNumber(startIndx,finishIndx)==target ) {
				
				util.Util.printlnLine(prefix+String.valueOf(target));
				return;
			} else {
				return ;
			}
			
		}
		
		int srcValue=arrayToNumber(startIndx,startIndx);

		fun(prefix+srcValue+"+",startIndx+1,finishIndx,target-srcValue );
		fun("",startIndx+1,finishIndx,Defaulttarget);
		
		
		
		
	}
	*/
/*
	private static int arrayToNumber( int startIndx, int finishIndx) {
		
		int multipleBy=1;
		int number=arrayInt[finishIndx];
		for(int i=finishIndx; i>startIndx; i--) {
			//util.Util.printlnLine(arrayInt[i]);
			multipleBy=multipleBy*10;
			number=number+(multipleBy*arrayInt[i-1]);
		}
		return number;
	}
*/
}
