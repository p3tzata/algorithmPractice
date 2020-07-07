package algorithmPractice.recursion.room1;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;

import util.Util;

public class Labyrinth {

	private static int xDemension;
	private static int yDemension;
	private static String[][] matrix;
	private static String noPassSymbol="O";
	private static String finalSymbol="F";
	private static String stepSymbol="-";
	
	public static void main(String[] args) throws Exception {
		xDemension=5;
		yDemension=7;
		
		matrix = new String[xDemension][yDemension];
		
		matrix[1][1]=noPassSymbol;
		matrix[1][2]=noPassSymbol;
		matrix[1][3]=noPassSymbol;
		matrix[1][4]=noPassSymbol;
		matrix[1][5]=noPassSymbol;
		
		matrix[3][3]=noPassSymbol;
		matrix[2][3]=noPassSymbol;
		matrix[3][4]=noPassSymbol;
		matrix[2][3]=noPassSymbol;
		matrix[4][1]=noPassSymbol;
		
		matrix[3][6]=finalSymbol;
		
		recursion(0,0);
		
		
		//Print.printMatrix(matrix, 1);
		
	}
	
	
	
	public static void recursion(int x, int y) throws Exception {
		
		if (checkIfFreeForStep(x, y)) {
			if (matrix[x][y]==finalSymbol) {
				Util.printlnLine("Win");
				Util.printMatrix(matrix, 1);
				return;
			} else {
			
			stepOn(x,y);
			}
		} else {
			return;
		}
		
		
		//clearScreen() ;
		//Print.printMatrix(matrix, 1);
		recursion(x+1, y);
		recursion(x-1, y);
		recursion(x, y+1);
		recursion(x, y-1);
		
		stepOf(x,y);
		//clearScreen() ;
		//Print.printMatrix(matrix, 1);
		
		
	}
	
	
	private static void stepOn(int x, int y) {
		matrix[x][y]=stepSymbol;
	}
	
	private static void stepOf(int x, int y) throws Exception {
		if (matrix[x][y]==stepSymbol) {
			matrix[x][y]="";	
			
		} else {
			throw new Exception("Somting wrong");
		}
		
		
		
	}
	
	
	
	private static boolean checkIfFreeForStep(int x,int y) {
		
		if (x<0 || x>=xDemension || y<0|| y>=yDemension || matrix[x][y]==noPassSymbol || matrix[x][y]==stepSymbol) {
			return false;
			
			
		}
		
		return true;
	}
	
	
	public static void clearScreen() throws IOException {  
		
		final String ESC = "\033[";
		System.out.print(ESC + "2J");  
	   }
	
	
	
	
	
	
	
	
}
