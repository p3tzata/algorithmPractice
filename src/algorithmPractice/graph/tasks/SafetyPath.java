package algorithmPractice.graph.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import util.Edge;

public class SafetyPath {
	
	static private List<Edge> graphEdges;
	static private HashMap<Integer, List<Edge>> cacheHashMap;
	static private Double[] resultNode;
	static private Integer[] tracker;
	static private PriorityQueue<Integer> queueEdges;
	
	public static void main(String[] args) {
		
		graphEdges= new ArrayList<>();
		
		graphEdges.add(new Edge(0, 3, 85));
		graphEdges.add(new Edge(0, 4, 88));
				
		graphEdges.add(new Edge(1, 3, 95));
		graphEdges.add(new Edge(1, 5, 5));
		graphEdges.add(new Edge(1, 6, 100));
		
		graphEdges.add(new Edge(2, 4, 14));
		graphEdges.add(new Edge(2, 6, 95));
		
		graphEdges.add(new Edge(3, 5, 98));
		graphEdges.add(new Edge(4, 5, 99));

		graphEdges.add(new Edge(5, 6, 90));
		
		
		refillCache();
		int from=0;
		int to=6;
		
		
		
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();	
		resultNode = new Double[maxIndex+1];
		tracker = new Integer[maxIndex+1];
		queueEdges = new PriorityQueue<>(Comparator.comparing( (e1) -> {return resultNode[(int) e1];}   ).reversed());
		for(int i=0;i<resultNode.length;i++) {
			resultNode[i]=-1d;
		}
		CalculateDistance(from,to);
	}
	
	
	
	private static void CalculateDistance(int from, int to) {
		
		resultNode[from]=100d;
		tracker[from]=from;
		
		List<Edge> list = cacheHashMap.get(from);
		if (list!=null) {
			Iterator<Edge> iterator = list.iterator();
			while (iterator.hasNext()) {
				Edge edge = (Edge) iterator.next();
				int adjacentNode = util.Graph.getAdjacentNode(from, edge);
				resultNode[adjacentNode]=resultNode[from] * edge.getWeight()/100;
				tracker[adjacentNode]=from;
				queueEdges.add(adjacentNode);
				
			}
		}
		
		while (!queueEdges.isEmpty()) {
			
			Integer headNode = queueEdges.remove();
			if (headNode==to) {
				break;
			}
			
			List<Edge> list2 = cacheHashMap.get(headNode);
			if (list2!=null) {
				Iterator<Edge> iterator = list2.iterator();
				while (iterator.hasNext()) {
					Edge edge = (Edge) iterator.next();
					int adjacentNode = util.Graph.getAdjacentNode(headNode, edge);
					if (resultNode[adjacentNode]==-1) {
						queueEdges.add(adjacentNode);
					}
					if (resultNode[headNode] * edge.getWeight()/100 > resultNode[adjacentNode]) {
						
						resultNode[adjacentNode]=resultNode[headNode] * edge.getWeight()/100;
						tracker[adjacentNode]=headNode;
						//ReOrderQueue();
					}
					
					
				}
				
				
			}
			
			
			
		}
			
		String debugString = "debug";
		System.out.print(debugString);
		
		
	}
	
	


	private static void ReOrderQueue() {
		PriorityQueue<Integer>queueEdgesNew =  new PriorityQueue<>(Comparator.comparing( (e1) -> {return resultNode[(int) e1];}   ).reversed());
		queueEdgesNew.addAll(queueEdges);
		queueEdges=queueEdgesNew;
		
	}



	private static void refillCache() {
		cacheHashMap = new HashMap<>();
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
	}
	
	private static void clearEdge(int node, int nextNode) {
		//cacheHashMap.remove(node);
		List<Edge> list = cacheHashMap.get(node);
		if (list!=null) {
			
			Iterator<Edge> iterator = list.iterator();
			while(iterator.hasNext()) {
				Edge edge = iterator.next();
				int prevNode = util.Graph.getAdjacentNode(node, edge);
				if (prevNode==nextNode) {
					iterator.remove();
				}
				
			}
		}
		
		
		
		
		
		List<Edge> list2 = cacheHashMap.get(nextNode);
		if (list2!=null) {
			Iterator<Edge> iterator = list2.iterator();
			while (iterator.hasNext()) {
				Edge edge = (Edge) iterator.next();
				int prevNode = util.Graph.getAdjacentNode(nextNode, edge);
				if (prevNode==node) {
					iterator.remove();
				}
				
			}
		}
	}
	
	
	
	

}
