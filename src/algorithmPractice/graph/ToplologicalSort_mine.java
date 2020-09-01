package algorithmPractice.graph;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import util.Edge;
import util.Util;

public class ToplologicalSort_mine {

	static private List<Edge> graphEdges;
 
	static private Deque<Integer> deque;
	
	static private boolean[] visited;	
	
	static private HashMap<Integer, List<Edge>> cacheHashMapStartNode;
	static private HashMap<Integer, List<Edge>> cacheHashMapEndNode;
	
	public static void main(String[] args) {

		
		graphEdges = new ArrayList<>();
		deque = new ArrayDeque<Integer>(); 
		
		//graphEdges.add(new Edge(1, 3, 0));
		graphEdges.add(new Edge(2, 3, 0));
		graphEdges.add(new Edge(3, 1, 0));
		graphEdges.add(new Edge(4, 1, 0));
		graphEdges.add(new Edge(4, 0, 0));
		graphEdges.add(new Edge(5, 0, 0));
		graphEdges.add(new Edge(5, 2, 0));
		cacheHashMapStartNode = new HashMap<>();
		cacheHashMapEndNode = new HashMap<>();
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		visited = new boolean[maxIndex+1];
		
		for (int i = 0; i < graphEdges.size(); i++) {
			Edge edge = graphEdges.get(i);
			
			if(!cacheHashMapStartNode.containsKey(edge.getStartNode())) {
				cacheHashMapStartNode.put(edge.getStartNode(), new ArrayList<>());
				
			}
			
			if(!cacheHashMapEndNode.containsKey(edge.getEndNode())) {
				cacheHashMapEndNode.put(edge.getEndNode(), new ArrayList<>());
				
			}
			
			cacheHashMapStartNode.get(edge.getStartNode()).add(edge);
			cacheHashMapEndNode.get(edge.getEndNode()).add(edge);
			
			
		}
		
		
		
		for(int i=0;i<visited.length;i++) {
		
		if (!visited[i]) {
			visited[i]=true;
		} else {
			continue;
		}
			
			
		List<Edge> list = cacheHashMapEndNode.get(i);
			
		if (list==null ||list.size()==0) {
		
			deque.add(i);
		}
			
		}
		
		
		
		while (!deque.isEmpty()) {
			Integer removeFirst = deque.removeFirst();
			Util.printlnLine("Node:"+ removeFirst);
			List<Edge> list = cacheHashMapStartNode.get(removeFirst);
			cacheHashMapStartNode.remove(removeFirst);
			if(list==null) {
				continue;
			}
			
			
			Iterator<Edge> iterator = list.iterator();
			
			while (iterator.hasNext()) {
				Edge edge = (Edge) iterator.next();
				iterator.remove();
				
					 Iterator<Edge> iterator2 = cacheHashMapEndNode.get(edge.getEndNode()).iterator();
				
					 while (iterator2.hasNext()) {
						Edge edge2 = (Edge) iterator2.next();
						
						if(edge2.getStartNode()==removeFirst) {
							iterator2.remove();
						}
						
						List<Edge> list2 = cacheHashMapEndNode.get(edge2.getEndNode());
						if (list2==null ||list2.size()==0) {
							cacheHashMapEndNode.remove(edge2.getEndNode());
							deque.add(edge2.getEndNode());
						}
						
						
					}
					 
				
				
				
			}
			
			
			
			
			
		}
		
		if (cacheHashMapStartNode.size()>0) {
			Util.printlnLine("No topological sorting");
		}
		String debugString = "";
		
		
		
		
		
		
		
	}

}
