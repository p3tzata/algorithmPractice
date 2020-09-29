package util;

public class Graph {
	
	
	
	public static int getAdjacentNode(int node, Edge edge) {
		
		
		if (edge.getStartNode()==node) {
			return edge.getEndNode();
		} else {
			return edge.getStartNode();
		}
		
		
		
	}
	
	
	
	public static void setUndirectedEge(int[][] matrix, int u, int v) {
		
		matrix[u][v]=1;
		matrix[v][u]=1;
		
	}
	
public static void setUndirectedEge(Integer[][] matrix, int u, int v) {
		
		matrix[u][v]=1;
		matrix[v][u]=1;
		
	}
	
public static void setDirectedEge(int[][] matrix, int u, int v) {
		
		matrix[u][v]=1;
	
		
	}
	
	
	
	
	

}
