package algorithmPractice.dynamicProgramming;



import util.Util;

public class LargestSumPath {

	static Integer[][] source;
	static Integer[][] sourcePath;
	
	public static void main(String[] args) {
		
		source = new Integer[][] {{3, 6, 99},
								  {2, 4, 8},
								  {30,5,10}};

		sourcePath = new Integer[source.length][source.length];						  
								  
		
		sourcePath[0][0]=source[0][0];
		
		
		for (int i=1;i<source.length;i++) {
			
			sourcePath[0][i] = source[0][i]+source[0][i-1];
		}
		
		
		for (int i=1;i<source.length;i++) {
			
			for (int j=0;j<source.length;j++) {
				int upper=getValue(sourcePath,i-1,j);
				int left=getValue(sourcePath, i, j-1);
				sourcePath[i][j] = source[i][j] + Math.max( upper  , left );
			}
		}
		
	
		
		int x=sourcePath.length-1;
		int y=sourcePath.length-1;
		Util.printMatrix(source, 2);
		Util.printMatrix(sourcePath, 2);
		Util.printlnLine(source[x][y]);
		while(x>0 || y>0) {
			
		
			if (getValue(sourcePath, x, y-1)> getValue(sourcePath,x-1,y)) {
				Util.printlnLine(source[x][y-1]);
				y=y-1;
				continue;
			} 
			
			if (getValue(sourcePath, x, y-1)<= getValue(sourcePath,x-1,y)) {
				Util.printlnLine(source[x-1][y]);
				x=x-1;
				continue;
			}
			
			
			
		}
		Util.printlnLine(source[0][0]);
		
		String degugString="";
		
								  
	}
	
	
	static Integer  getValue(Integer[][] source , int  x, int y) {
		
		if (x<0 || y<0 || x>=source.length || y>=source.length) {
			return 0;
		}
		
		
		
		return source[x][y] ==null ? 0 : source[x][y] ; 
		
		
	}
	
	
	

}
