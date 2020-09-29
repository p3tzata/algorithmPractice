package algorithmPractice.graph.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;


import util.Edge;

public class ThunderStruck {

	private static int[][] matrix;
	private static List<Edge> queueEdges;
	
	
	private static int[] demageTotal;
	
	
	public static void main(String[] args) {

		
		
		matrix=new int[5][5];
		
		demageTotal= new int[5];
		
		
		
		matrix[0][1]=10;
		matrix[1][0]=10;
		
		matrix[0][3]=50;
		matrix[3][0]=50;
		
		matrix[0][2]=35;
		matrix[2][0]=35;
		
		matrix[1][4]=20;
		matrix[4][1]=20;
		
		matrix[4][2]=30;
		matrix[2][4]=30;
		
		
		 strike(0, 40);
		 strike(4, 20);
		
		
		
String debugString = "debug";
System.out.print(debugString);
	}
	
	
	
	static private void strike(int nodeToStart, int power) {
		
	 int[] demage =new int[matrix.length];
	 boolean[] visited = new boolean[matrix.length];;	
	 queueEdges = new ArrayList<>();
	 
	 visited[nodeToStart]=true;
	 demage[nodeToStart]=power;
	 
		for(int i=0;i<matrix.length;i++) {
			
			if(matrix[nodeToStart][i]>0) {
				queueEdges.add(new Edge(nodeToStart, i, matrix[nodeToStart][i]));
			}
			
		}
		
		Comparator<Edge> comparing = Comparator.comparing(Edge::getWeight);
	
		queueEdges.sort(comparing);
	
		
		
		while (queueEdges.size()>0) {
			queueEdges.sort(comparing);
			
			Edge edge = queueEdges.get(0);
			queueEdges.remove(0);
			
			int nextPower=demage[edge.getStartNode()]/2;
			if(!visited[edge.getEndNode()] && nextPower>0) {
				
				demage[edge.getEndNode()]=nextPower;
				visited[edge.getEndNode()]=true;
				for(int i=0;i<matrix.length;i++) {
					
					if(matrix[edge.getEndNode()][i]>0 && !visited[i]) {
						queueEdges.add(new Edge(edge.getEndNode(), i, matrix[edge.getEndNode()][i]));
					}
					
				}
				
				
				
			}
			
			
			
			
			
		}
		
		
		for(int i=0;i<matrix.length;i++) {
			
			demageTotal[i]+=demage[i];
			
		}
		
		
		
	}
	

}
