package algorithmPractice.dynamicProgramming;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;



import util.Util;

public class ZigZagMaxSum {

	
	static int[][] matrix;
	static Integer[][] result;
	static HashMap<Integer, Integer> resultPath;
	
	
	public static void main(String[] args) {
		resultPath = new HashMap<>();
		matrix = new int[][] {
			{714,52,415,740},
			{102,321,549,697},
			{44,830,171,952},
			{414,58,309,16},
			{956,596,667,526},
			{711,691,776,214},
			{617,919,924,536},
			{102,637,758,360},
			{446,315,243,132},
			{856,313,794,920},
			{732,566,376,314},
			{891,869,999,456},
			{363,869,471,137},
			{650,108,393,24},
			{277,201,124,184},
			{397,13,596,408},
			{73,811,506,100}
		};
		
		
		result = new Integer [matrix.length][matrix[0].length];
		
		for(int i=0;i<result.length;i++) {
			
			for(int j=0;j<result[0].length;j++) {
				
				result[i][j]=0;
				
			}
			
		}
		
		
		for(int i=1;i<matrix.length;i++) {
			
			result[i][0] = matrix[i][0];
			
		}
		
		
		for(int c=0;c<matrix[0].length-1;c++) {
			
			
				
				for(int r=0;r<matrix.length;r++) {
					if(result[r][c]!=0) {
						if(c%2==0) {
							calc_max_resultUpper(r,c);
						} else {
							calc_max_resultDown(r,c);
						}
					}	
				
				}
				
				
			
			
			
		}
		
		Util.printMatrix(result, 2);
		
		Integer Sum =0;
		for (Entry<Integer, Integer> entry : resultPath.entrySet()) {
			
			Util.printlnLine(entry.getValue());
			
			
		}
		
		int col1 = resultPath.get(1);
		int targetIndex=0;
		for (int i=0;i<matrix.length;i++) {
			int j = matrix[i][1];
			if(col1==j) {
				targetIndex=i;
			}
			
		}
		Integer targetValueInteger=0;
		for (int i=targetIndex+1;i<matrix.length;i++) {
			
			if (targetValueInteger<matrix[i][0]) {
				targetValueInteger=matrix[i][0];
			}
			
		}
		
		
		Util.printlnLine(targetValueInteger);
		
		
		String debugString = "debug";
		System.out.print(debugString);
			
			

	}


	private static void calc_max_resultDown(int r, int c) {
		
		for(int i=r+1;i<matrix.length;i++) {
			
			if(result[i][c+1] < (result[r][c] + matrix[i][c+1] ) ) {
				result[i][c+1] = (result[r][c] + matrix[i][c+1]);
				 				
				 int j = matrix[i][c+1];
				 
				 if (resultPath.containsKey(c+1)) {
					 if (resultPath.get(c+1)<j) {
						 resultPath.put(c+1, j);
						 
					 } 
					 
				 } else {
					 resultPath.put(c+1, j);
					 
					 
				 }
				 
				
			}
		
		}
		
		
	}


	private static void calc_max_resultUpper(int r, int c) {

		for(int i=0;i<=r-1;i++) {
			
			if( result[i][c+1] < (result[r][c] + matrix[i][c+1] ) ) {
				
				result[i][c+1] = (result[r][c] + matrix[i][c+1]);
				 int j = matrix[i][c+1];
				 if (resultPath.containsKey(c+1)) {
					 if (resultPath.get(c+1)<j) {
						 resultPath.put(c+1, j); 
						 
					 } 
				 } else {
					 resultPath.put(c+1, j);
					 
				 }
				
			}
			
		}
		
		
	}

}
