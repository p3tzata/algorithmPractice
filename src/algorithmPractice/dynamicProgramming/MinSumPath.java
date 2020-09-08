package algorithmPractice.dynamicProgramming;

import java.util.Currency;
import java.util.HashMap;

import util.Util;


public class MinSumPath {

	
	static int[][] matrix;
	static Integer[][] result;
	static HashMap<Integer, Integer> resultPath;
	
	
	public static void main(String[] args) {
		resultPath = new HashMap<>();
		matrix = new int[][] {
			{4, 1, 1, 1},
			{8, 6, 4, 1},
			{1, 1, 1, 1},
			{1, 4, 6, 8},
			{1, 1, 1, 13}
		};
		
		
		result = new Integer [matrix.length][matrix[0].length];
		
		for(int i=0;i<result.length;i++) {
			
			for(int j=0;j<result[0].length;j++) {
				
				result[i][j]=Integer.MAX_VALUE;
				
			}
			
		}
		
		result[0][0]=matrix[0][0];
		
		for(int col=1;col<matrix[0].length;col++) {
			
			result[0][col] = matrix[0][col] + result[0][col-1];
			
		}
		
		
		for(int row=1;row<matrix.length;row++) {
			
			for (int col=0;col<matrix[0].length;col++) {
				/*
				if (row==2) {
					String debugString = "debug";
					System.out.print(debugString);
				}
				*/
				
				calc_first_minSum(row,col);
				
				refresh_minSumUtil(row,col);
				
				
			}
			
			
			
		}
		int row=result.length-1;
		int col=result[0].length-1;
		
		Util.printlnLine(matrix[row][col]);
		
		while( !(col==0 && row==0) ) {
			
			int curMinSum=Integer.MAX_VALUE;
			int curMinCol=-1;
			int curMinRow=-1;
			try {
				int checkValue=result[row][col-1];
			if(checkValue<curMinSum) {
				curMinSum=result[row][col-1];
				curMinCol=col-1;
				curMinRow=row;
			} 
			} catch(ArrayIndexOutOfBoundsException ex) {
				;;
			}
			
			
			try {
				int checkValue=result[row][col+1];
			if(checkValue<curMinSum) {
				curMinSum=result[row][col+1];
				curMinCol=col+1;
				curMinRow=row;
			}}
			catch(ArrayIndexOutOfBoundsException ex) {
				;
			}
			
			try {
				int checkValue=result[row-1][col];
			if(checkValue<curMinSum) {
				curMinSum=result[row-1][col];
				curMinCol=col;
				curMinRow=row-1;
			}}
			
			catch(ArrayIndexOutOfBoundsException ex) {
				;
			}
			
			try {
				int checkValue=result[row+1][col];
			if(checkValue<curMinSum) {
				curMinSum=result[row+1][col];
				curMinCol=col;
				curMinRow=row+1;
			}
			}
			catch(ArrayIndexOutOfBoundsException ex) {
				;
			}
			Util.printlnLine(matrix[curMinRow][curMinCol]);
			col=curMinCol;
			row=curMinRow;
			
			
		}
		
		
		
		
	
		String debugString = "debug";
		System.out.print(debugString);
		
		
	}


	private static void refresh_minSum(int row, int col) {
	
		
		refresh_minSumUtil(row, col-1);//left
		refresh_minSumUtil(row, col+1);//Right;
		
		refresh_minSumUtil(row-1, col);//Up
		refresh_minSumUtil(row+1, col);//Down
		
			
		
	}


	private static void refresh_minSumUtil(int row, int col) {
		
		
		try {
		
			//Left
			if(result[row][col-1] > result[row][col] + matrix[row][col-1] && result[row][col]!=Integer.MAX_VALUE ) {
				result[row][col-1]=result[row][col] + matrix[row][col-1];
				refresh_minSumUtil(row,col-1);
			}
			
		} catch(ArrayIndexOutOfBoundsException ex) {
			return;
		}		
			
		try {	
			//Right
			if(result[row][col+1] > result[row][col] + matrix[row][col+1] && result[row][col]!=Integer.MAX_VALUE ) {
				result[row][col+1]=result[row][col] + matrix[row][col+1];
				refresh_minSumUtil(row,col+1);
			}
		} catch(ArrayIndexOutOfBoundsException ex) {
		return;
		}	
			
	try {		
			//Up
			if(result[row-1][col] > result[row][col] + matrix[row-1][col] && result[row][col]!=Integer.MAX_VALUE ) {
				result[row-1][col]=result[row][col] + matrix[row-1][col];
				refresh_minSumUtil(row-1,col);
			}
	} catch(ArrayIndexOutOfBoundsException ex) {
		return;
	}
	
	try {
			//Down
			if(result[row+1][col] > result[row][col] + matrix[row+1][col] && result[row][col]!=Integer.MAX_VALUE ) {
				result[row+1][col]=result[row][col] + matrix[row+1][col];
				refresh_minSum(row+1,col);
			}
	} catch(ArrayIndexOutOfBoundsException ex) {
		return;
	}
			
			
			
		
		
	
		
		
		
	}


	private static void calc_first_minSum(int row, int col) {
	
		
		if(col==0) {
			result[row][col]=matrix[row][col]+result[row-1][col];
		
		} else {
		
		int LeftResult=result[row][col-1];
		int UpperResutl=result[row-1][col];
		int curMatrix=matrix[row][col];
		if(UpperResutl<LeftResult) {
			
			result[row][col] = UpperResutl+curMatrix;
			
			
		} else {
			result[row][col] = LeftResult+curMatrix;
			
		}
		}
		
			
		
		
	}
	

	
}
