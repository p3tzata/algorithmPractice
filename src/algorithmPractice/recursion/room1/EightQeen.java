package algorithmPractice.recursion.room1;


import util.Util;

public class EightQeen {

	private static String[][] matrix;
	private static int demension;
	private static String queen="Q";
	//private static String fPoint="o";
	private static int queenPlaced=0;
	private static int queenTarget=0;
	private static int cnt=0;
	
	public static void main(String[] args) {
		demension=3;
		queenTarget=2;
		matrix = new String[demension][demension];
		
				
		
		//recursionPlaceQueen(0);
		recursionPlaceQueen(0,0,0);
		Util.printlnLine(cnt);
		
		//Print.printMatrix(matrix, 1);
		
	}
	
	
	
//	private static void recursionPlaceQueen(int x, int y,int depth) {
	private static void recursionPlaceQueen(int x,int y,int depth) {
		cnt++;
		if (queenPlaced==queenTarget) {
			Util.printlnLine("WIN");
			Util.printMatrix(matrix, 1);
			return;
		}
		
		
		for (int i=x;i<matrix.length;i++) {
			
		
			for(int j=0;j<matrix[i].length;j++) {
				//Print.printlnLine(String.format("x:%d y:%d depth:%d", i,j,depth));
				
				if (placeQueen(i,j)) {
					//Print.printMatrix(matrix, 1);
					   queenPlaced++;
				} else {
					continue;
				}
				
//				recursionPlaceQueen(i,j,depth+1);
				recursionPlaceQueen(i,j,depth+1);
				
							
				
				
				   if (removeQueen(i,j)) {
					 //  Print.printMatrix(matrix, 1);
					   queenPlaced--;
				   }
				
				
				
			}
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	private static void recursionPlaceQueen(int indx) {
		
		//Print.printMatrix(matrix, 1);
		

		
		if (queenPlaced==queenTarget) {
			Util.printlnLine("WIN");
			Util.printMatrix(matrix, 1);
			return;
		}
		

		
		
	   for(int i=indx; i<(demension*demension);i++){

			if (placeQueen(i)) {
				//Print.printMatrix(matrix, 1);
				   queenPlaced++;
			} else {
				continue;
			}
		   
		   recursionPlaceQueen(i+1);
		   
		   if (removeQueen(i)) {
			 //  Print.printMatrix(matrix, 1);
			   queenPlaced--;
		   }
		   
		   
	   }
		
		
		
	}























	private static boolean placeQueen(int indx) {
		return placeQueen(indx/(demension),indx%(demension));
	}




	private static boolean placeQueen(int x,int y) {
		
		
		
		if (!checkForbiddenPoint(x, y)) {
			matrix[x][y]="Q";
			return true;
		}
		return false;
		
		
	}
	
	private static boolean removeQueen(int indx) {
		return removeQueen(indx/(demension), indx%(demension));

	}
	
	
	private static boolean removeQueen(int x,int y) {
			
		if (matrix[x][y]==queen) {
			matrix[x][y]="";
			return true;
		} else {
			return false;
		}
			
	
	}
	
	
	
	
	
	private static boolean checkForbiddenPoint(int x, int y) {
		
		
		
		try {
			
			if (matrix[x][y]==queen) {
				throw new forbbidenPoint();
			}
			
			
		
		//Up
		if (x>0) {
		for(int i=x-1;i>=0;i--) {
			  // if(matrix[i][y]==null) { 
				   //matrix[i][y]=fPoint;
				   if (matrix[i][y]==queen) {
					   throw new forbbidenPoint();
				   }
				   
			  // }
		}
		}
		
		//Down
		if (x<demension-1) {
		 for(int i=x+1;i<demension;i++) {
		   //if(matrix[i][y]==null) { 
			   //matrix[i][y]=fPoint;
			 if (matrix[i][y]==queen) {
				   throw new forbbidenPoint();
			   }
			   
			   
		   //}
		}
		}
		
		
		//left
		if (y>0) {
			for(int i=y-1;i>=0;i--) {
				   //if(matrix[x][i]==null) { 
					   //matrix[x][i]=fPoint;
				if (matrix[x][i]==queen) {
					   throw new forbbidenPoint();
				   } 
					   
					   
				   //}
		}
		}
		
		//Right
		if (y<demension-1) {
				 for(int i=y+1;i<demension;i++) {
				  // if(matrix[x][i]==null) { 
					 //  matrix[x][i]=fPoint;
					 
					 if (matrix[x][i]==queen) {
						   throw new forbbidenPoint();
					   } 
					 
					 
				   //}
				}
		}
		
		
		
		for(int i=1;i<demension;i++) {
			
			//leftUp
			if (!(x-i<0 ||y-i<0)) {
				//matrix[x-i][y-i]=fPoint;
				if (matrix[x-i][y-i]==queen) {
					throw new forbbidenPoint();
				}
				
				
			}
			
			//RightDown
			if (!(x+i>=demension || y+i>=demension)) {
				//matrix[x+i][y+i]=fPoint;
				if (matrix[x+i][y+i]==queen) {
					throw new forbbidenPoint();
				}
				
			}
			
			//RightUp
			if (!(x-i<0 || y+i>=demension)) {
				//matrix[x-i][y+i]=fPoint;
				if (matrix[x-i][y+i]==queen) {
					throw new forbbidenPoint();
				}
			}
			
			//leftDown
			if (!(x+i>=demension || y-i<0 )) {
				//matrix[x+i][y-i]=fPoint;
				if (matrix[x+i][y-i]==queen) {
					throw new forbbidenPoint();
				}
				
			}
			
			
		
			
			
			
		}
		
		} catch (forbbidenPoint e) {
			return true;
		}
		
		return false;
		
		
		
		
		
		
		
	
		
		
	}
	
	
	

	
	
	

}

class forbbidenPoint extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public forbbidenPoint() {
		super("Forbbiden point");

	}

	
	
	
}

