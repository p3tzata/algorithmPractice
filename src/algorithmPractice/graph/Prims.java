package algorithmPractice.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import util.Edge;
import util.Util;

public class Prims {

	static private List<Edge> graphEdges;
	static private TreeSet<Edge> queueEdges;
	static private Integer[] resutlTreeForest; 
	static private HashMap<Integer, List<Edge>> cacheHashMap; 
	
	public static void main(String[] args) {
		
		
		graphEdges = new ArrayList<>();
		queueEdges = new TreeSet<>(Comparator.comparing(Edge::getWeight));
		cacheHashMap = new HashMap<>();
		
		graphEdges.add(new Edge(1, 3, 3));
		graphEdges.add(new Edge(3, 2, 10));
		graphEdges.add(new Edge(3, 4, 2));
		graphEdges.add(new Edge(3, 5, 6));
		graphEdges.add(new Edge(2, 4, 4));
		graphEdges.add(new Edge(4, 5, 1));
		
		
		queueEdges.addAll(graphEdges);
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();

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
		
		resutlTreeForest = new Integer[maxIndex+1];
		for (int i=1;i<graphEdges.size();i++) {
			if (resutlTreeForest[i]==null) {
				prim(i);
			}
			
		}
		
		
		
		
		String debug="";
		
	}

	private static void prim(int i) {
		
		resutlTreeForest[i]=i;
		
		queueEdges.addAll(cacheHashMap.get(i));
		
		while(!queueEdges.isEmpty()) {
			Edge edge = queueEdges.first();
			queueEdges.remove(edge);
			
			if (resutlTreeForest[edge.getStartNode()]!=null 
					&& resutlTreeForest[edge.getEndNode()] ==null ) {
				
				resutlTreeForest[edge.getEndNode()]=edge.getStartNode();
				Util.printlnLine(edge);
				queueEdges.addAll(cacheHashMap.get(edge.getEndNode()));
				
			}
			
			if (resutlTreeForest[edge.getEndNode()]!=null 
					&& resutlTreeForest[edge.getStartNode()] ==null ) {
				
				resutlTreeForest[edge.getStartNode()]=edge.getEndNode();
				Util.printlnLine(edge);
				queueEdges.addAll(cacheHashMap.get(edge.getStartNode()));
				
			}
			
			
			
			
		}
		
		
	}

}
