package algorithmPractice.graph.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;


import util.Edge;

public class Salary {
	
	
	static private List<Edge> graphEdges;
	static private Deque<Integer> deque;
	static private boolean[] visted;
	static private int[] result;
	static private HashMap<Integer, List<Edge>> cacheHashMapStartNode;
	static private HashMap<Integer, List<Edge>> cacheHashMapEndNode;
	//static private HashMap<Integer, List<Edge>> cacheHashMap; 
	
	
	public static void main(String[] args) {
		graphEdges = new ArrayList<>();
		deque = new ArrayDeque<Integer>(); 
		
		graphEdges.add(new Edge(1, 0, 0));
		graphEdges.add(new Edge(1, 2, 0));
		graphEdges.add(new Edge(1, 5, 0));
		graphEdges.add(new Edge(2, 0, 0));
		graphEdges.add(new Edge(2, 5, 0));
		graphEdges.add(new Edge(4, 0, 0));
		graphEdges.add(new Edge(4, 2, 0));
		graphEdges.add(new Edge(5, 0, 0));
		graphEdges.add(new Edge(5, 3, 0));
		
		cacheHashMapStartNode = new HashMap<>();
		cacheHashMapEndNode = new HashMap<>();
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		visted = new boolean[maxIndex+1];
		result = new int[maxIndex+1];
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
		
		for(int i=0;i<result.length;i++) {
			
			if(!cacheHashMapStartNode.containsKey(i)) {
				result[i]=1;
				deque.add(i);
			} 
			
		}
		
		
		while (!deque.isEmpty()) {
			Integer childNode = deque.removeFirst();
			
			List<Edge> parentListNode = cacheHashMapEndNode.get(childNode);
			ArrayList<Edge> parentListNodeClone=null;
			if (parentListNode!=null) {
			parentListNodeClone = new ArrayList<>(parentListNode);
			}
			
			if(parentListNodeClone!=null) {
				Iterator<Edge> parentListNodeCloneIterator = parentListNodeClone.iterator();
				while(parentListNodeCloneIterator.hasNext()) {
					Edge parentEdge = parentListNodeCloneIterator.next();
					int parentNode = parentEdge.getStartNode();
					
					
					clearEdge(childNode, parentNode);
					
					List<Edge> list = cacheHashMapStartNode.get(parentNode);
					
					if(list==null || list.size()==0) {
						
						deque.add(parentNode);
					}
					
					result[parentNode]+=result[childNode];
					
					
				}
				
				
			}
		}
		
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
		
		
		
		
		
		
		
		
		
	}
	
	
	private static void clearEdge(int child, int parent) {
		//cacheHashMap.remove(node);
		List<Edge> list = cacheHashMapEndNode.get(child);
		if (list!=null) {
			
			Iterator<Edge> iterator = list.iterator();
			while(iterator.hasNext()) {
				Edge edge = iterator.next();
				int prevNode = util.Graph.getAdjacentNode(child, edge);
				if (prevNode==parent) {
					iterator.remove();
				}
				
			}
		}
		
		
		
		
		
		List<Edge> list2 = cacheHashMapStartNode.get(parent);
		if (list2!=null) {
			Iterator<Edge> iterator = list2.iterator();
			while (iterator.hasNext()) {
				Edge edge = (Edge) iterator.next();
				int prevNode = util.Graph.getAdjacentNode(parent, edge);
				if (prevNode==child) {
					iterator.remove();
				}
				
			}
		}
	}
	
	

}
