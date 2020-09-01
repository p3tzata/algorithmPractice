package algorithmPractice.graph.training;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

import util.Util;

public class PrePostTiming {
	
	static int graph[][];
	static boolean visited[];
	static int preTime[];
	static int postTime[];
	static int parent[];
	static int vertexNumber;
	static int time=0;
	static Stack<Integer> queue;
	
	
	public static void main(String[] args) {
		graph =new int[7][7];
		visited = new boolean[7];
		preTime =new int[7];
		postTime =new int[7];
		parent =new int[7];
		queue=new Stack<Integer>();
		
		
		graph[1][2]=1;
		graph[2][1]=1;
		
		graph[1][3]=1;
		graph[3][1]=1;
		
		graph[2][4]=1;
		graph[4][2]=1;
		
		graph[3][4]=1;
		graph[4][3]=1;
		
		graph[3][5]=1;
		graph[5][3]=1;
		
		graph[6][5]=1;
		graph[5][6]=1;
		
		prePostTime_recursion(1);

		String debugString = "debug";
		System.out.print(debugString);
		
	}





	private static void prePostTime_recursion(int i) {
		
		
		DFS(i);
		
		
		
	}


	private static void DFS(int v) {
		
		preTime[v]=++time;
		visited[v]=true;
		for(int i=0; i<graph[0].length;i++) {
			
			if (graph[v][i]==1 && visited[i]==false) {
				parent[i]=v;
				DFS(i);
				
			}
			
		}
		postTime[v]=++time;
		Util.printlnLine("Node:"+v);
		
		
	}
	
	
	
	
	

}
