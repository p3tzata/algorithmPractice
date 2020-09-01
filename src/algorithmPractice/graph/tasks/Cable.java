package algorithmPractice.graph.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import util.Edge;

public class Cable {

	
	static private List<Edge> graphEdges;
	static private List<Edge> graphEdgesPlanning;
	
	static private PriorityQueue<Edge> queueEdges;
	static private Integer[] resutlTreeForest; 
	
	static private HashMap<Integer, List<Edge>> cacheHashMap;
	static private Integer curVolume=0;
	
	public static void main(String[] args) {

		graphEdges= new ArrayList<>();
		//graphEdges.add(new Edge(1, 2, 1));
		graphEdges.add(new Edge(0, 3, 9));
		graphEdges.add(new Edge(0, 8, 5));
		graphEdges.add(new Edge(0, 4, 6));
		graphEdges.add(new Edge(3, 2, 14));
		
		graphEdgesPlanning= new ArrayList<>();
		graphEdgesPlanning.add(new Edge(0, 5, 4));
		graphEdgesPlanning.add(new Edge(1, 4, 8));
		graphEdgesPlanning.add(new Edge(1, 7, 7));
		graphEdgesPlanning.add(new Edge(2, 6, 12));
		graphEdgesPlanning.add(new Edge(3, 5, 2));
		graphEdgesPlanning.add(new Edge(4, 7, 10));
		graphEdgesPlanning.add(new Edge(4, 8, 3));
		graphEdgesPlanning.add(new Edge(6, 8, 9));
		graphEdgesPlanning.add(new Edge(7, 8, 4));
		
		/*
		graphEdgesPlanning.add(new Edge(4, 2, 6));
		graphEdgesPlanning.add(new Edge(3, 1, 3));
		graphEdgesPlanning.add(new Edge(4, 3, 2));
		*/
		
		
		int maxIndex = graphEdgesPlanning.stream().mapToInt( x-> { return Math.max(x.getStartNode(),x.getEndNode()); } ).max().getAsInt();
		resutlTreeForest=new Integer[maxIndex+1];
		refillCache();
		for(int i=0;i<resutlTreeForest.length;i++) {
			resutlTreeForest[i]=i;			
		}
		Comparator<Edge> comparingEdge = Comparator.comparing(Edge::getWeight);
		queueEdges = new PriorityQueue<>(comparingEdge);
		for (int i=0;i<graphEdges.size();i++) {
			Edge edge = graphEdges.get(i);
			resutlTreeForest[edge.getEndNode()]=edge.getStartNode();
						
		}
		
		
		for(int i=0;i<graphEdges.size();i++) {
			Edge edge = graphEdges.get(i);
			List<Edge> listOfStartedNodeEdges = cacheHashMap.get(edge.getStartNode());
			List<Edge> listOfEndedNodeEdges = cacheHashMap.get(edge.getEndNode());
			
			if (listOfEndedNodeEdges!=null) {
				queueEdges.addAll(listOfEndedNodeEdges);
			}
			
			if (listOfStartedNodeEdges!=null) {
				queueEdges.addAll(listOfStartedNodeEdges);
			}
			
		}
		
				
		
		
		
	
		int maxVolume=13;
		
		calculate(maxVolume);
		
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
		
		
		
	}

	private static void calculate(int maxVolume) {
		
		
		while (!queueEdges.isEmpty()) {
			Edge pollFirst = queueEdges.remove();
			
			
			int foundRootOfStartedNode = findRoot(pollFirst.getStartNode());
			int foundRootOfEndedNode = findRoot(pollFirst.getEndNode());
			clearEdge(pollFirst.getStartNode(), pollFirst.getEndNode());
			if (foundRootOfStartedNode==foundRootOfEndedNode) {
				continue;
			}
			
			
			if((curVolume + pollFirst.getWeight())<= maxVolume) {
				
				curVolume+=pollFirst.getWeight();
				util.Util.printlnLine("adding:"+pollFirst.toString() );
				resutlTreeForest[pollFirst.getEndNode()]=pollFirst.getStartNode();
				List<Edge> list = cacheHashMap.get(pollFirst.getEndNode());
				List<Edge> list2 = cacheHashMap.get(pollFirst.getStartNode());
				if(list!=null) {
					queueEdges.addAll(list);
				}
				if(list2!=null) {
					queueEdges.addAll(list2);
				}
				
				
				
			} else {
				break;
				
			}
			
			String debugString = "";
			System.out.print(debugString);
		}
		
		
		
	}
	
	
	private static int findRoot(int node) {

		while (node!=resutlTreeForest[node]) {
			node=resutlTreeForest[node];
		}
		return node;
	}

	private static void refillCache() {
		cacheHashMap = new HashMap<>();
		for (int i = 0; i < graphEdgesPlanning.size(); i++) {
			Edge edge = graphEdgesPlanning.get(i);
			
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
