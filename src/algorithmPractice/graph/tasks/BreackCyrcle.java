package algorithmPractice.graph.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import util.Edge;
import util.Graph;
import util.Util;

public class BreackCyrcle {
	
	
	static private List<Edge> graphEdges;
	static private Deque<Integer> deque;
	static private boolean[] visted;
	static private int[] result;
	//static private HashMap<Integer, List<Edge>> cacheHashMapStartNode;
	//static private HashMap<Integer, List<Edge>> cacheHashMapEndNode;
	static private HashMap<Integer, List<Edge>> cacheHashMap; 
	static private PriorityQueue<Edge> orderedEdges;
	static int maxIndex;
	static Comparator<Edge> edgeOrdered=null;
	public static void main(String[] args) {
		graphEdges = new ArrayList<>();
		deque = new ArrayDeque<Integer>(); 
		
		graphEdges.add(new Edge(1, 2, 0));
		graphEdges.add(new Edge(1, 3, 0));
		graphEdges.add(new Edge(1, 7, 0));
		graphEdges.add(new Edge(2, 4, 0));
		graphEdges.add(new Edge(3, 4, 0));
		graphEdges.add(new Edge(3, 5, 0));
		graphEdges.add(new Edge(3, 8, 0));
		graphEdges.add(new Edge(4, 6, 0));
		graphEdges.add(new Edge(5, 6, 0));
		graphEdges.add(new Edge(7, 8, 0));
		
		graphEdges.add(new Edge(9, 10, 0));
		graphEdges.add(new Edge(9, 10, 0));
		graphEdges.add(new Edge(9, 10, 0));
		
		graphEdges.add(new Edge(11, 12, 0));
		graphEdges.add(new Edge(11, 13, 0));
		graphEdges.add(new Edge(11, 14, 0));
		graphEdges.add(new Edge(12, 14, 0));
		graphEdges.add(new Edge(13, 14, 0));
		
	
		
		/*
		graphEdges.add(new Edge(1, 5, 0));
		graphEdges.add(new Edge(1, 2, 0));
		graphEdges.add(new Edge(1, 4, 0));
		graphEdges.add(new Edge(3, 5, 0));
		graphEdges.add(new Edge(2, 3, 0));
				
		graphEdges.add(new Edge(6, 7, 0));
		graphEdges.add(new Edge(6, 8, 0));
		graphEdges.add(new Edge(7, 8, 0));
		
		*/
		
		
		
		
		
		maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		visted = new boolean[maxIndex+1];
		Comparator<Edge> edgeOrdered
	      = Comparator.comparing(Edge::getStartNode)
	        .thenComparing(Edge::getEndNode);
		
		orderedEdges=new PriorityQueue<>(edgeOrdered);  
		orderedEdges.addAll(graphEdges);
		
		
		while (!orderedEdges.isEmpty()) {
			Edge edge = orderedEdges.poll();
			
			checkCyrcle(edge.getStartNode(),edge.getEndNode());
				
		}
		
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
	}

	private static void checkCyrcle(int startNode, int endNode) {
		
		refillCache();
		visted=new boolean[maxIndex+1];
		
		visted[startNode]=true;
		visted[endNode]=true;
		clearEdge(startNode, endNode);
		List<Edge> listChildNode = cacheHashMap.get(endNode);
		Set<Edge> listChildNodeClone=null;
		if (listChildNode!=null) {
			listChildNodeClone = new TreeSet<>(edgeOrdered);
			listChildNodeClone.addAll(listChildNode);
		}
		
		if(listChildNodeClone!=null && listChildNodeClone.size()!=0) {
			Iterator<Edge> iterator = listChildNodeClone.iterator();
			while(iterator.hasNext()) {
				Edge childEdge = iterator.next();
				int adjacentNode = util.Graph.getAdjacentNode(endNode,childEdge );
				deque.add(adjacentNode);
				clearEdge(endNode, adjacentNode);
			}
		}
		
		
		while(!deque.isEmpty()) {
			Integer childNode = deque.removeFirst();
			
			if (childNode==startNode) {
				Util.printlnLine("Break cyrcle:" + startNode +"-"+endNode);
				Iterator<Edge> iterator = graphEdges.iterator();
				while (iterator.hasNext()) {
					Edge edge = (Edge) iterator.next();
					if (startNode==edge.getStartNode() && endNode==edge.getEndNode()) {
						iterator.remove();
						break;
					}
					
				}
				
				break;
			}
			
			visted[childNode]=true;
			
			List<Edge> childList = cacheHashMap.get(childNode);
			Set<Edge> childListClone=null;
			if (childList!=null) {
				childListClone=new TreeSet<>(edgeOrdered);
				childListClone.addAll(childList) ;
			}
			
			
			Iterator<Edge> iterator = childListClone.iterator();
			while (iterator.hasNext()) {
				Edge edge = (Edge) iterator.next();
				int adjacentNode = Graph.getAdjacentNode(childNode, edge);
				deque.add(adjacentNode);
				clearEdge(childNode, adjacentNode);
				
			}
			
			
			
			
			
		}
		
		
		
		
		
		
		
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
					break;
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
					break;
				}
				
			}
		}
	}
	

}
