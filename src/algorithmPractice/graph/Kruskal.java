package algorithmPractice.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;



import util.Edge;
import util.Util;

public class Kruskal {

	static private List<Edge> graphEdges;
	static private TreeSet<Edge> queueEdges;
	static private Integer[] resutlTreeForest; 
	
	
	public static void main(String[] args) {
		
		graphEdges = new ArrayList<>();
		queueEdges = new TreeSet<>(Comparator.comparing(Edge::getWeight));
		
		
		graphEdges.add(new Edge(1, 2, 1));
		graphEdges.add(new Edge(2, 3, 3));
		graphEdges.add(new Edge(3, 4, 4));
		graphEdges.add(new Edge(3, 1, 7));
		graphEdges.add(new Edge(4, 1, 10));
		graphEdges.add(new Edge(4, 5, 2));
		graphEdges.add(new Edge(5, 1, 5));
		
		queueEdges.addAll(graphEdges);
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();

		resutlTreeForest = new Integer[maxIndex+1];
		
		for (int i = 0; i < resutlTreeForest.length; i++) {
			resutlTreeForest[i]=i;
		}
		
		
		
		while (!queueEdges.isEmpty()) {
			Edge edge = queueEdges.first();
			queueEdges.remove(edge);
			
			int findRootNodeOfStartNode = findRootNode(edge.getStartNode());
			int findRootNodeOfEndNode = findRootNode(edge.getEndNode());
			
			
			if(findRootNodeOfEndNode==findRootNodeOfStartNode) {
				continue;
			}
			
			
			Util.printlnLine(edge);
			
			resutlTreeForest[edge.getEndNode()]=edge.getStartNode();
			
			
			
		}
		
		
		
		String debug="";

	}
	
	
	static int findRootNode(int node) {
		
		while (resutlTreeForest[node]!=node) {
			node=resutlTreeForest[node];
		}
		
		
		return node;
	}
			
			
	

}
