package algorithmPractice.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;


import util.Edge;
import util.Util;

public class Dikstra_mineImp {

	static private List<Edge> graphEdges;
	static private TreeSet<Integer> queueNode;
	static private Integer[] resutlTreeForest; 
	static private Integer[] resutlTreeTrackForest; 
	static private HashMap<Integer, List<Edge>> cacheHashMap; 
	static private PriorityQueue<Integer> priortyQueue;
	static private Set<Integer> visitedNode;
	
	public static void main(String[] args) {
		graphEdges = new ArrayList<>();
		visitedNode=new HashSet<>();
		cacheHashMap = new HashMap<>();
		priortyQueue = new PriorityQueue<>(Comparator.comparing( (e1) -> {return resutlTreeForest[e1];}   ));
	
		graphEdges.add(new Edge(0, 1, 4));
		graphEdges.add(new Edge(0, 7, 8));
		graphEdges.add(new Edge(1, 2, 8));
		graphEdges.add(new Edge(1, 7, 11));
		graphEdges.add(new Edge(2, 3, 7));
		graphEdges.add(new Edge(2, 5, 4));
		graphEdges.add(new Edge(2, 8, 2));
		graphEdges.add(new Edge(3, 4, 9));
		graphEdges.add(new Edge(3, 5, 14));
		graphEdges.add(new Edge(4, 5, 10));
		graphEdges.add(new Edge(5, 6, 2));
		graphEdges.add(new Edge(6, 7, 1));
		graphEdges.add(new Edge(6, 8, 6));

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
		resutlTreeTrackForest = new Integer[maxIndex+1];
		for (int i=0;i<resutlTreeForest.length;i++) {
			
			resutlTreeForest[i]=Integer.MAX_VALUE;
			
		}
		
		resutlTreeForest[0]=0;
		resutlTreeTrackForest[0]=0;
		priortyQueue.add(0);
		
		
		
		while(!priortyQueue.isEmpty()) {
			Integer node = priortyQueue.poll();
			
			
			
			visitedNode.add(node);
			
			List<Edge> listOfAdjacent  = cacheHashMap.get(node);
			
			for(int i=0;i<listOfAdjacent.size();i++) {
				Integer adjacentNode=-1;
				
				if (listOfAdjacent.get(i).getStartNode()==node) {
					
					adjacentNode=listOfAdjacent.get(i).getEndNode();
				
				}
				
				if (listOfAdjacent.get(i).getEndNode()==node) {
					adjacentNode=listOfAdjacent.get(i).getStartNode();
				}
				/*
				resutlTreeForest[adjacentNode]=
						Math.min(resutlTreeForest[adjacentNode],resutlTreeForest[node] + listOfAdjacent.get(i).getWeight());
				
				*/
				
				if (visitedNode.contains(adjacentNode)) {
					//priortyQueue.add(adjacentNode);
					continue;
				}
				
				
				priortyQueue.add(adjacentNode);
				if (resutlTreeForest[adjacentNode]>resutlTreeForest[node] + listOfAdjacent.get(i).getWeight()) {
					resutlTreeForest[adjacentNode]=resutlTreeForest[node] + listOfAdjacent.get(i).getWeight();
					resutlTreeTrackForest[adjacentNode]=node;
				}
				
				
				
				
				
			}
			
			
			
			
			
		}
		
		
		int findPathTo=4;
		
		while(resutlTreeTrackForest[findPathTo]!=findPathTo) {
			Util.printlnLine(findPathTo);
			findPathTo=resutlTreeTrackForest[findPathTo];
			
			
		}
		
		
		String debug="";
		
	}

}
