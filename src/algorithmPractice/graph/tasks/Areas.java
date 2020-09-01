package algorithmPractice.graph.tasks;


import java.util.HashMap;
import java.util.Map;

public class Areas {

	static char[][] matrix;
	static boolean[][] visited;
	static Map<Character, Integer> resutl;
	
	public static void main(String[] args) {
		resutl =new HashMap<Character, Integer>();
		matrix= new char[][] {
			/*{'a','a','c','c','c','a','a','c'},
			{'b','a','a','a','a','c','c','c'},
			{'b','a','a','b','a','c','c','c'},
			{'b','b','d','a','a','c','c','c'},
			{'c','c','d','c','c','c','c','c'},
			{'c','c','d','c','c','c','c','c'}*/ 
			{'a','s','s','s','a','a','d','a','s'},
			{'a','d','s','d','a','s','d','a','d'},
			{'s','d','s','d','a','d','s','a','s'},
			{'s','d','a','s','d','s','d','s','a'},
			{'s','s','s','s','a','s','d','d','d'}
			
		};
		
			visited=new boolean[matrix.length][matrix[0].length];
			
		
		for (int i=0;i<matrix.length;i++) {	
		for (int j=0;j<matrix[0].length;j++) {	
		if (!visited[i][j]) {
			recursionSearch(i,j,matrix[i][j]);
			if(!resutl.containsKey(matrix[i][j])) {
				resutl.put(matrix[i][j], 1);
			} else {
				resutl.put(matrix[i][j], resutl.get(matrix[i][j]) + 1);
			}
		}
		
		}}
			
		String debugString = "";	
	}

	private static void recursionSearch(int i, int j, char c) {
 
		
		
		try {
			if(visited[i][j]) {
				return;
			}
			
			if(matrix[i][j]==c) {
				visited[i][j]=true;
				recursionSearch(i+1, j, c);
				recursionSearch(i-1, j, c);
				recursionSearch(i, j+1, c);
				recursionSearch(i, j-1, c);
			}
		}
		catch(ArrayIndexOutOfBoundsException exception) {
		    return;
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
