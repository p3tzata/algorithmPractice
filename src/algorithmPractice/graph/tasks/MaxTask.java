package algorithmPractice.graph.tasks;
//Java program for implementation of Ford Fulkerson algorithm 
import java.util.*; 
import java.lang.*; 
import java.io.*; 
import java.util.LinkedList; 

class MaxTask 
{ 
 static final int V = 10;    //Number of vertices in graph 
 static Integer rGraph[][];
 static Character alias[];
 /* Returns true if there is a path from source 's' to sink 
   't' in residual graph. Also fills parent[] to store the 
   path */
 boolean bfs(Integer rGraph[][], int s, int t, int parent[]) 
 { 
     // Create a visited array and mark all vertices as not 
     // visited 
     boolean visited[] = new boolean[V]; 
    // for(int i=0; i<V; ++i) 
     //    visited[i]=false; 

     // Create a queue, enqueue source vertex and mark 
     // source vertex as visited 
     LinkedList<Integer> queue = new LinkedList<Integer>(); 
     queue.add(s); 
     visited[s] = true; 
     parent[s]=-1; 

     // Standard BFS Loop 
     while (queue.size()!=0) 
     { 
         int u = queue.poll(); 
    	 //int u = queue.pop();
         for (int v=0; v<V; v++) 
         //for (int v=V-1; v>=0; v--)
         { 
             if (visited[v]==false && rGraph[u][v] > 0) 
             { 
                 queue.add(v); 
                 parent[v] = u; 
                 visited[v] = true; 
             } 
         } 
     } 

     // If we reached sink in BFS starting from source, then 
     // return true, else false 
     return (visited[t] == true); 
 } 

 // Returns tne maximum flow from s to t in the given graph 
 int fordFulkerson(Integer graph[][], int s, int t) 
 { 
     int u, v; 

     // Create a residual graph and fill the residual graph 
     // with given capacities in the original graph as 
     // residual capacities in residual graph 

     // Residual graph where rGraph[i][j] indicates 
     // residual capacity of edge from i to j (if there 
     // is an edge. If rGraph[i][j] is 0, then there is 
     // not) 
     rGraph = new Integer[V][V]; 

     for (u = 0; u < V; u++) 
         for (v = 0; v < V; v++) 
             rGraph[u][v] = graph[u][v]; 

     // This array is filled by BFS and to store path 
     int parent[] = new int[V]; 

     int max_flow = 0;  // There is no flow initially 

     // Augment the flow while tere is path from source 
     // to sink 
     while (bfs(rGraph, s, t, parent)) 
     { 
         // Find minimum residual capacity of the edhes 
         // along the path filled by BFS. Or we can say 
         // find the maximum flow through the path found. 
         int path_flow = Integer.MAX_VALUE; 
         for (v=t; v!=s; v=parent[v]) 
         { 
             u = parent[v]; 
             int capacity=rGraph[u][v];
             path_flow = Math.min(path_flow, capacity); 
         } 

         // update residual capacities of the edges and 
         // reverse edges along the path 
         for (v=t; v != s; v=parent[v]) 
         { 
             u = parent[v]; 
             rGraph[u][v] -= path_flow; 
             rGraph[v][u] += path_flow; 
         } 

         // Add path flow to overall flow 
         max_flow += path_flow; 
     } 

     
     
     // Return the overall flow 
     return max_flow; 
 } 

 // Driver program to test above functions 
 public static void main (String[] args) throws java.lang.Exception 
 { 
     // Let us create a graph shown in the above example 
    /*
	 							  //  1 2 3 4 5 6 	
	 Integer graph[][] =new Integer[][] { 
		 						   
		 						   {0,1,1,1,0,0,0,0},
		  						   {0,0,0,0,1,0,1,0},
	     						   {0,0,0,0,0,1,1,0},
		 						   {0,0,0,0,1,1,0,0},
		 						   {0,0,0,0,0,0,0,1},
		 						   {0,0,0,0,0,0,0,1},
		 						   {0,0,0,0,0,0,0,1},
		 						   {0,0,0,0,0,0,0,0}
       };
*/
       Integer graph[][] =new Integer[][] { 
			   // A B C D 1 2 3 4 
			   {0,1,1,1,1,0,0,0,0,0},
			   {0,0,0,0,0,1,0,1,0,0}, //A
			   {0,0,0,0,0,0,1,0,0,0}, //B
			   {0,0,0,0,0,1,1,1,0,0}, //C
			   {0,0,0,0,0,0,0,1,1,0}, //D
			   {0,0,0,0,0,0,0,0,0,1},
			   {0,0,0,0,0,0,0,0,0,1},
			   {0,0,0,0,0,0,0,0,0,1},
			   {0,0,0,0,0,0,0,0,0,1},
			   {0,0,0,0,0,0,0,0,0,0},
       };
       
       
       
	 
     alias = new Character[] {null,'A','B','C','D'};
      
     MaxTask m = new MaxTask(); 
     
     System.out.println("The maximum possible flow is " + 
                        m.fordFulkerson(graph, 0, 9));
     
     for (int i=1;i<alias.length;i++) {
    	 
    	 for (int j=alias.length;j<graph.length-1;j++) {
    		 if (!graph[i][j].equals( rGraph[i][j]) ) {
    			 util.Util.printlnLine(alias[i] + "-"+ (j-(alias.length-1)));
    		 }
    	 }
    	 
     }
     
     util.Util.printMatrix(rGraph, 1);
 } 
} 