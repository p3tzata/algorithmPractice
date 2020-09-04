package algorithmPractice.graph.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import algorithmPractice.graph.DFS;
import util.Util;

public class InOutDegree {
	
	static HashMap<Integer, List<Integer>> graph;
	static boolean[] visited;
	static int[] inDegrees;
	static int[] outDegrees;
	
	public static void main(String[] args) {
		graph = new HashMap<>();
		graph.put(0, new ArrayList<>(Arrays.asList(1,2)));
		graph.put(1, new ArrayList<>(Arrays.asList(3)));
		graph.put(2, new ArrayList<>(Arrays.asList(0,5,6)));
		graph.put(3, new ArrayList<>(Arrays.asList(1,4)));
		graph.put(4, new ArrayList<>(Arrays.asList(2,3)));
		
		graph.put(5, new ArrayList<>(Arrays.asList(4,6)));
		graph.put(6, new ArrayList<>(Arrays.asList(5)));
		
		
		visited = new boolean[graph.size()];
		inDegrees = new int[graph.size()];
	    outDegrees = new int[graph.size()];
		
	
	    DFS(0);
	    Util.printlnLine("in" + Arrays.asList(inDegrees));
	}

	private static void DFS(int v) {
		
		if(!visited[v]) {
			visited[v]=true;
			for (int child : graph.get(v)) {
				
				outDegrees[v]++;
				inDegrees[child]++;
				DFS(child);
				
				
			}
			
			
		}
		
		
	}

}
