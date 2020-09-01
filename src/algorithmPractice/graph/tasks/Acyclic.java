package algorithmPractice.graph.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

import algorithmPractice.graph.BFS;
import util.Edge;

public class Acyclic {
	
	static private List<Edge> graphEdges;
	static private Deque<Integer> queueNode;
	static private Integer[] resutlTreeForest; 
	static private HashMap<Integer, List<Edge>> cacheHashMap; 
	static private boolean[] visited;
	
	public static void main(String[] args) {
		
		graphEdges = new ArrayList<>();
		queueNode = new ArrayDeque<>();
		cacheHashMap = new HashMap<>();
		
		graphEdges.add(new Edge(1, 2, 0));
		graphEdges.add(new Edge(2, 3, 0));
		graphEdges.add(new Edge(4, 2, 0));
		graphEdges.add(new Edge(4, 5, 0));
		graphEdges.add(new Edge(3, 5, 0));
		
		
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
		
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		
		visited = new boolean[maxIndex+1];
		
		
		BFS(1);
		
		
		
	}

	private static void BFS(int node) {
		
		visited[0]=true;
		List<Edge> list = cacheHashMap.get(node);
		if (list!=null) {
			//list.stream().forEach(el->{ queueNode.add(util.Graph.getAdjacentNode(i, el)) ;  });
			for (int i=0;i<list.size();i++) {//1-2,1-3
				int nextNode = util.Graph.getAdjacentNode(node, list.get(i));
				queueNode.add(nextNode);
				
				
				clearEdge(node, nextNode);
				
				
			}
			
			
		}
		
		
		while (!queueNode.isEmpty()) {
			Integer removeFirst = queueNode.removeFirst();
			
			if(visited[removeFirst]) {
				util.Util.printlnLine("there is cycle");
				break;
			}
			visited[removeFirst]=true;
			List<Edge> list2 = cacheHashMap.get(removeFirst);
			if (list2!=null) {
				list2.stream().forEach(el->{ 
					int nextNode = util.Graph.getAdjacentNode(removeFirst, el);
					queueNode.add(nextNode);  
					clearEdge(removeFirst, nextNode);
					});
			}
			
			
			
			
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
