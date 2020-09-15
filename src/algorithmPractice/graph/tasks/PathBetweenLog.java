package algorithmPractice.graph.tasks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import algorithmPractice.graph.DFS;
import util.Graph;
import util.Util;

public class PathBetweenLog {

	private static int[][] matrix;
	private static boolean[] visited;
	private static int[] parent;
	private static Map<Integer,Integer> connectedComponent;
	private static int curConnected=0;
	
	public static void main(String[] args) {
		connectedComponent= new HashMap<Integer, Integer>();
		List<Log> logList=new ArrayList<Log>();
		Log log1 = new Log(-10, 30, 60, 10);
		Log log2 = new Log(-50, 220, -30, -20);
		Log log3 = new Log(-35, 60, -20, 15);		
		Log log4 = new Log(-40, -10, 50, -30);
		
		
		//Log log30 = new Log(2, 3, 4, 1);		
		//Log log40 = new Log(3, 4, 5, 2);
				
				
		
		
		logList.add(log1);
		logList.add(log2);
		logList.add(log3);
		logList.add(log4);
		matrix= new int[logList.size()+1][logList.size()+1];
		visited = new boolean[logList.size()+1];
		parent  = new int[logList.size()+1];
		
		for(int i=0;i<logList.size()-1;i++) {
			
			for(int j=i+1;j<logList.size();j++) {
				Log firstLog = logList.get(i);
				Log secondLog = logList.get(j);
				
				if(checkIsInterseption(firstLog, secondLog)) {
					Graph.setUndirectedEge(matrix, i+1, j+1);
				}
				
			}
			
		}
		
		
		//if (checkRoute(2,4)) {
		//	Util.printlnLine("Yes");
		//}
		for(int i=matrix.length-1;i>0;i--) {
				parent[i]=i;
				
		}
		
		for(int i=matrix.length-1;i>0;i--) {
			if (!visited[i]) {
				curConnected++;
				DFS(i);
			}	
		}
		
		
		/*
		if (checkRouteOptimize(1,4)) {
				Util.printlnLine("Yes");
		}
		
		*/
		
		if (checkRouteOptimizeBest(2,4)) {
			Util.printlnLine("Yes");
		}
		
		
		
		
		
		
		String debugString = "debug";
		System.out.print(debugString);
		
		

	}
	
	private static boolean checkRouteOptimizeBest(int i, int j) {
		
		return connectedComponent.get(i)==connectedComponent.get(j);
	}

	private static boolean checkRouteOptimize(int startNode, int EndNode) {
		
		return checkRouteOptimizeUtil(startNode,EndNode) || checkRouteOptimizeUtil(EndNode,startNode); 
	}
	
	
	private static boolean checkRouteOptimizeUtil(int startNode, int EndNode) {
		int node=startNode;
		while(node!=parent[node]) {
			if(parent[node]==EndNode) {
				return true;
			}
			node=parent[node];
			
			
		}
		
		
		return false;
		
		
	}

	private static boolean checkRoute(int i, int j) {
	
		DFS(i);
		
		
		
		return visited[j];
		
	}
	
	
	
	

	private static void DFS(int startIndex) {

		visited[startIndex]=true;
		connectedComponent.put(startIndex, curConnected);
		for(int i=0;i<matrix.length;i++) {
			
			if(matrix[startIndex][i]==1 && visited[i]==false) {
				parent[i]=startIndex;
				
				DFS(i);
				
			}
			
			
		}
		
		
	}

	private static boolean checkIsInterseption(Log log1, Log log2) {
				
		
		
		if( log1.getRbottomX()<log2.getLtopX() || log1.getLtopX()>log2.getRbottomX() ) {  
			return false;
		}
		
				
		if ( log1.getRbottomY()>log2.getLtopY() || log2.getRbottomY()>log1.getLtopY() ) {
			return false;
		}
		
		
		
		return true;
	}

}


 class Log{
	
	private int LtopX;
	private int LtopY;
	private int RbottomX;
	private int RbottomY;
	public Log(int ltopX, int ltopY, int rbottomX, int rbottomY) {
		super();
		LtopX = ltopX;
		LtopY = ltopY;
		RbottomX = rbottomX;
		RbottomY = rbottomY;
	}
	
	public int getLtopX() {
		return LtopX;
	}
	public void setLtopX(int ltopX) {
		LtopX = ltopX;
	}
	public int getLtopY() {
		return LtopY;
	}
	public void setLtopY(int ltopY) {
		LtopY = ltopY;
	}
	public int getRbottomX() {
		return RbottomX;
	}
	public void setRbottomX(int rbottomX) {
		RbottomX = rbottomX;
	}
	public int getRbottomY() {
		return RbottomY;
	}
	public void setRbottomY(int rbottomY) {
		RbottomY = rbottomY;
	}
	
	
	
	
}
