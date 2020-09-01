package algorithmPractice.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import util.Edge;
import util.Graph;

public class BFS {

	static private List<Edge> graphEdges;
	static private boolean[] visited;
	static private HashMap<Integer, List<Edge>> cacheHashMap; 
	static private Deque<Integer> deque ; 
	
	public static void main(String[] args) {
		
		graphEdges = new ArrayList<>();
		cacheHashMap = new HashMap<>();
		deque = new ArrayDeque<Integer>(); 
		
		
		graphEdges.add(new Edge(1, 2, 0));
		graphEdges.add(new Edge(1, 3, 0));
		graphEdges.add(new Edge(2, 4, 0));
		graphEdges.add(new Edge(2, 5, 0));
		graphEdges.add(new Edge(3, 6, 0));
		graphEdges.add(new Edge(3, 7, 0));
		graphEdges.add(new Edge(7, 1, 0));
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		visited = new boolean[maxIndex+1];
		
		
		
		for (int i = 0; i < graphEdges.size(); i++) {
			Edge edge = graphEdges.get(i);
			
			if(!cacheHashMap.containsKey(edge.getStartNode())) {
				cacheHashMap.put(edge.getStartNode(), new ArrayList<>());
				
			}
			
			if(!cacheHashMap.containsKey(edge.getEndNode())) {
				cacheHashMap.put(edge.getEndNode(), new ArrayList<>());
				
			}
			
			cacheHashMap.get(edge.getStartNode()).add(edge);
			cacheHashMap.get(edge.getEndNode()).add(edge);
			
			
		}
		
		
		BFSearch(1);
		
		
	
	}

	private static void BFSearch(int startNode) {

		
		deque.add(startNode);
		visited[startNode]=true;
		while (!deque.isEmpty()) {
						
			Integer node = deque.removeFirst();
			
			List<Edge> list = cacheHashMap.get(node);
			util.Util.printlnLine("Node:" + node);
			
			for (Edge edge : list) {
				
				Integer adjacentNode = Graph.getAdjacentNode(node,edge);
				
				
				if (!visited[adjacentNode]) {
					deque.add(adjacentNode);
					visited[adjacentNode]=true;
				}
				
				
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

}
