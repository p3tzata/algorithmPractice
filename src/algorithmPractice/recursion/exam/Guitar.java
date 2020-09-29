package algorithmPractice.recursion.exam;

import util.Util;

public class Guitar {

	static Integer[] path;
	static Integer[] resut;
	static int startLevel=40;
	static int maxLevel=243;
	static int maxResult=0;
	
	public static void main(String[] args) {


		
		path = new Integer[] {startLevel,74, 39, 127, 95, 63, 140,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,88,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8, 99, 96, 154, 18, 137, 162, 14, 88 };
		resut= new Integer[path.length];
		resut[0]=path[0];
		
		
		gen(0,startLevel);
		Util.printlnLine(maxResult);
		
	}

	private static void gen(int indx, int curMaxSound) {


		if(curMaxSound>maxLevel || curMaxSound<0) {
			return;
		}
		
		resut[indx]=curMaxSound;
		
		if(indx==resut.length-1) {
			//Util.printArray(resut, ",");
			if(maxResult<resut[resut.length-1]) {
				maxResult=resut[resut.length-1];
			}
			return;
		}
		
		
		
		gen(indx+1,curMaxSound + path[indx+1]);
		
		gen(indx+1,curMaxSound - path[indx+1]);
		
		
		
		
		
		
		
		
	}

}
