package algorithmPractice.graph.tasks;

import java.util.Stack;


import util.Graph;
import util.Util;

public class ShortestPath {

	static private int[][] matrix;
	static private int[] dist;
	static private int[] path;
	static private Stack<Integer> queue;
	static private int startNode=0;
	static private int INF=Integer.MAX_VALUE;
	static private int preFinishNode=-1;
	static private int preFinishPath=Integer.MAX_VALUE;
	
	public static void main(String[] args) {
	
		
		matrix=new int[7][7];
		dist=new int[7];
		path=new int[7];
		queue = new Stack<>();
		
		Graph.setDirectedEge(matrix, 0, 2);
		Graph.setDirectedEge(matrix, 2, 1);
		Graph.setDirectedEge(matrix, 1, 0);
		Graph.setDirectedEge(matrix, 3, 0);
		Graph.setDirectedEge(matrix, 3, 1);
		Graph.setDirectedEge(matrix, 2, 4);
		Graph.setDirectedEge(matrix, 3, 4);
		Graph.setDirectedEge(matrix, 4, 5);
		Graph.setDirectedEge(matrix, 5, 6);
		Graph.setDirectedEge(matrix, 6, 3);
		
		for (int i = 0; i < matrix.length; i++) {
			dist[i]=INF;
		}
		
		queue.add(startNode);
		dist[startNode]=0;
		
		
		while(!queue.isEmpty()) {
			Integer node = queue.pop();
			
			for(int i=0;i<matrix.length;i++) {
				
				if(matrix[node][i]==1) {
					
					if(dist[i]==INF) {
						dist[i]=dist[node]+1;
						path[i]=node;
						queue.add(i);
					} else {						
						
						if (i==startNode) {
							
							//Util.printlnLine(dist[node]+1);
							if((dist[node]+1)<preFinishPath) {
								preFinishPath=(dist[node]+1);
								preFinishNode=node;
											
								
							}
							
							
						} else {
							
							if (dist[i]>(dist[node]+1)) {
								
								dist[i]=dist[node]+1;
								path[i]=node;
							}
							
							
						}
						
					}
					
					
					
					
					
					
				}
				
				
				
			}
			
			
			
			
		}
		
		Util.printlnLine(preFinishPath);

	}

}
