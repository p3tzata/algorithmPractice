package algorithmPractice.graph.tasks;

import util.Graph;
import util.Util;

public class SplitGraph {

	
	private static int[][] graph;
	
	private static boolean[] visited;
	
	private static int startNode=1;
	
	private static int cnt=0;
	private static int curSum=0;
	private static int max=0;;
	private static int[] sumResult;
	private static int[] cntResult;
	
	
	
	public static void main(String[] args) {

		graph = new int[11][11];
		visited = new boolean[11];
		sumResult=new int[11];
		cntResult=new int[11];
		
		Graph.setUndirectedEge(graph, 1, 3);
		Graph.setUndirectedEge(graph, 1, 2);
		Graph.setUndirectedEge(graph, 1, 6);
		Graph.setUndirectedEge(graph, 2, 5);
		Graph.setUndirectedEge(graph, 2, 7);
		Graph.setUndirectedEge(graph, 3, 4);
		Graph.setUndirectedEge(graph, 6, 8);
		Graph.setUndirectedEge(graph, 8, 9);
		Graph.setUndirectedEge(graph, 8, 10);
		
		
		
		DFSUtil(startNode);
		
		for(int i=1;i<graph.length;i++) {
			if(startNode!=i && cntResult[i]%2==1 ) {
				if(max<sumResult[i]) {
					max=sumResult[i];
				}
			}
		}
		
		
		
		Util.printlnLine(max);
		

	}

	private static int DFSUtil(int i) {
		
		visited[i]=true;
		cnt=0;
		sumResult[i]=i;
				
				
		for(int j=1;j<graph.length;j++) {
			
			if(graph[i][j]==1 && !visited[j]) {
				cnt++;
				cnt+=DFSUtil(j);
				sumResult[i]+=sumResult[j];
			}
		}
		
		cntResult[i]=cnt;
		
		
		//Util.printlnLine("Node "+i+"="+ cnt);
		
		
		return cnt;
		
		
	}
	
	


}
