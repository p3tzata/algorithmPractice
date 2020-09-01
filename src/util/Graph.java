package util;

public class Graph {
	
	
	
	public static int getAdjacentNode(int node, Edge edge) {
		
		
		if (edge.getStartNode()==node) {
			return edge.getEndNode();
		} else {
			return edge.getStartNode();
		}
		
		
		
	}
	

}
