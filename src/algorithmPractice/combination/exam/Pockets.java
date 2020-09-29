package algorithmPractice.combination.exam;

import util.Util;

public class Pockets {

	
	static private Integer[] pockets=new Integer[15];
	static private int balls=30;
	static private int maxBallInPocket=15;
	
	
	public static void main(String[] args) {

		for(int i=0;i<pockets.length;i++) {
			pockets[i]=0;
			
		}

		
		
		
		//Not optimize...
		//genUtil2(0);
		
		genUtilNew(0);
		
		
		//generateUtil(0,balls);
		
		

	}



	private static void generateUtil(int indx,int ballLeft) {
		
		if(indx==pockets.length  ) {
			if(ballLeft==0) {
			Util.printArray(pockets, ", ");
			}return;
		}
		
		
		int max = 0;
		int posibleValue=ballLeft-(pockets.length-(indx+1));
		max= Math.min(maxBallInPocket ,posibleValue);
		
		if((ballLeft+max)<balls) {
			//return;
		}
		
		/*
		pockets[indx]=0;
		int calcTotal = calcTotal(indx);
		int posibleValue=( balls - ( (pockets.length-(indx+1)) + calcTotal));
		int max = Math.min(maxBallInPocket ,posibleValue);
		*/
		
		while (max>0) {
			pockets[indx]=max;
			generateUtil(indx+1,ballLeft-max);
			max--;
			
		}
		
		
		
	}



	private static void genUtilNew(int indx) {
		if(indx==pockets.length) {
			
			//Util.printArray(pockets, ", ");
			
			return;
		}
		
		
		for(int p=1;p<=pockets.length;p++) {
			
			
			
			pockets[indx]=p;
			
			int calcTotal = calcTotal(indx);
			
			if(calcTotal + (pockets.length-indx-1)>balls) {
				continue;
			}
			int check=(calcTotal+((pockets.length-(indx+1))*maxBallInPocket));
			if ( check < balls) {
				continue;
			}
				
		
			
			genUtilNew(indx+1);
			
			
		}
		
	}



	private static void genUtil2(int indx) {
		if(indx==pockets.length) {
			if(calcTotal(indx-1)==balls) {
			Util.printArray(pockets, ", ");
			}
			return;
		}
		
		
		
			//for(int i=indx;i<pockets.length;i++) {
				
			for(int j=1;j<=maxBallInPocket;j++) {
				
				
				
				pockets[indx] = j;
				genUtil2(indx+1);
				
			}
			
			
		//}
		
		
	}

	private static void genUtilBack(int indx,int curBallinPocket) {
		
		
		if(indx==pockets.length-1) {
			Util.printArray(pockets, " ,");
		}
		
		if(curBallinPocket>=maxBallInPocket) {
			return;
		}
		
		
		
		
		
		for(int i=indx;i<pockets.length;i++) {
			
			for(int j=1;j<maxBallInPocket;j++) {
				
				int calcTotal = calcTotal(i);
				
				if(calcTotal + (pockets.length-i-1)>balls) {
					break;
				}
				
			pockets[i]=curBallinPocket+j;
			genUtilBack(i, curBallinPocket+j);
			
			}
			
		}
		
		
		
	}

	private static int calcTotal(int indx) {
		int result=0;
		for(int i=0;i<=indx;i++) {
			result=result+pockets[i];
		}
		return result;
	}

}
