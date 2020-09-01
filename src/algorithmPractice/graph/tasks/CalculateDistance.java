package algorithmPractice.graph.tasks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

import util.Edge;

public class CalculateDistance {
	static private List<Edge> graphEdges;
	static private HashMap<Integer, List<Edge>> cacheHashMapStartNode;
	static private Integer[] result;
	static private boolean[] visited;
	static private Deque<Edge> deque;
	
	public static void main(String[] args) {
		
		cacheHashMapStartNode = new HashMap<>();
		graphEdges = new ArrayList<>();
		deque = new ArrayDeque<Edge>();
		graphEdges.add(new Edge(11, 4, 0));
		graphEdges.add(new Edge(4, 12, 0));
		graphEdges.add(new Edge(4, 1, 0));
		graphEdges.add(new Edge(1, 12, 0));
		graphEdges.add(new Edge(1, 21, 0));
		graphEdges.add(new Edge(1, 7, 0));
		graphEdges.add(new Edge(7, 21, 0));
		graphEdges.add(new Edge(12, 4, 0));
		graphEdges.add(new Edge(12, 19, 0));
		graphEdges.add(new Edge(19, 1, 0));
		graphEdges.add(new Edge(19, 21, 0));
		graphEdges.add(new Edge(21, 14, 0));
		graphEdges.add(new Edge(21, 31, 0));
		graphEdges.add(new Edge(14, 14, 0));
		graphEdges.add(new Edge(31, 0, 0));
		
		
		
		
		
		
		int maxIndex = graphEdges.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		result = new Integer[maxIndex+1];
		visited = new boolean[maxIndex+1];
		for (int i = 0; i < graphEdges.size(); i++) {
			Edge edge = graphEdges.get(i);
			
			if(!cacheHashMapStartNode.containsKey(edge.getStartNode())) {
				cacheHashMapStartNode.put(edge.getStartNode(), new ArrayList<>());
				
			}
			
			cacheHashMapStartNode.get(edge.getStartNode()).add(edge);
		
			
			
		}
		
		for(int i=0;i<result.length;i++) {
			
			result[i]=Integer.MAX_VALUE;
			
		}
		
		
		
		int startFromNode=1;
		int endToNode=11;
		
				
		startSearching(startFromNode,endToNode);
		
		
		
	
	
	}


	private static void startSearching(int startFromNode, int endToNode) {
	
		
		List<Edge> list = cacheHashMapStartNode.get(startFromNode);
		if (list!=null) {
			list.stream().forEach(el->{deque.add(el);});
		}
		visited[startFromNode]=true;
		result[startFromNode]=0;
		
		while (!deque.isEmpty()) {
			Edge currentNode = deque.removeFirst();
			
			if(result[currentNode.getEndNode()]!=Integer.MAX_VALUE) {
			//if(visited[currentNode.getEndNode()]) {
				continue;
			}
			visited[currentNode.getEndNode()]=true;
			
			result[currentNode.getEndNode()] = Math.min(result[currentNode.getStartNode()] + 1,result[currentNode.getEndNode()]);
			
			if(currentNode.getEndNode()==endToNode) {
				continue;
			}
			
			List<Edge> listInner = cacheHashMapStartNode.get(currentNode.getEndNode());
			if (listInner!=null) {
				listInner.stream().forEach(el->{deque.add(el);});
			}
			
			
			
		}
		
		String debugString = "";
		
		
		
	}

}
