package algorithmPractice.graph.tasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import util.Util;

public class FindArticulationPoints_mine {
	static Integer graph[][];
	static int vertexNumber;
	static List<Integer> adjacentNodes;
	
	public static void main(String[] args) {
		/* 
		graph =new Integer[][] {
			//0 1 2 3 4
			 {0,1,1,1,0}, 
			 {1,0,1,0,0},
			 {1,1,0,0,0},
			 {1,0,0,0,1},
			 {0,0,0,1,0}
			 
		 };
		 */
		graph =new Integer[][] {
			//0 1 2 3 4 5 6 
			 {0,1,1,0,0,0,0}, 
			 {1,0,1,1,1,0,1},
			 {1,1,0,0,0,0,0},
			 {0,1,0,0,0,1,0},
			 {0,1,0,0,0,1,0},
			 {0,0,0,1,1,0,0},
			 {0,1,0,0,0,0,0}
			 
			 
		 };
		 
		vertexNumber=graph.length;	  
			   
		for (int i=0;i<graph.length;i++) {
			
			if (isArticulationPoint(i)) {
				util.Util.printlnLine("ArticulationPoint: "+i);
			}
			//break;
		}
			   
			   
     }

	private static boolean isArticulationPoint(int v) {
		
		boolean[] visited=new boolean[vertexNumber];
		LinkedList<Integer> queue=new LinkedList<>();
		int startFrom=3;
		if (v==startFrom) {
			startFrom=1;
		}
		visited[v]=true;
		visited[startFrom]=true;
		
		//Util.printMatrix(graph, 1);
		removeAdjacentNode(v);
		
		for (int i=0;i<graph.length;i++) {
			if (graph[startFrom][i]==1) {
				queue.add(i);
				visited[i]=true;
			}
		}
		
		
		while(!queue.isEmpty()) {
			Integer u = queue.poll();
			
			for (int i=0;i<graph.length;i++) {
				if (!visited[i] && graph[u][i]==1 ) {
					queue.add(i);
					visited[i]=true;
				}
			}
			
			
		}
		boolean isArtPoint=false;
		for(int i=0;i<visited.length;i++) {
			if(!visited[i]) {
				isArtPoint=true;
				break;
			}
		}
		
		
		restoreAdjacentNode(v);
		//Util.printMatrix(graph, 1);
		
		
		return isArtPoint;
	}

	private static void restoreAdjacentNode(int v) {
		
		for(int i=0;i<adjacentNodes.size();i++) {
			graph[adjacentNodes.get(i)][v]=1;
			graph[v][adjacentNodes.get(i)]=1;
		}
		
		
		
	}

	private static void removeAdjacentNode(int v) {
		adjacentNodes = new ArrayList<>();
		
		
		
		for (int i=0;i<graph.length;i++) {
			if (graph[v][i]==1) {
				graph[v][i]=0;
				adjacentNodes.add(i);
			}
		}
		
		for(int i=0;i<adjacentNodes.size();i++) {
			graph[adjacentNodes.get(i)][v]=0;
		}
	}
	
	
	
	
	
	
	

}
