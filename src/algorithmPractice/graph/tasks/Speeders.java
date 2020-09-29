package algorithmPractice.graph.tasks;

//A Java program for Floyd Warshall All Pairs Shortest 
//Path algorithm. 
import java.util.*;
import static java.time.temporal.ChronoUnit.SECONDS;



import util.Graph;
import util.Util;

import java.lang.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*; 


class Speeders 
{ 
	static Double dist[][];
	static Double graph[][];
	static String mapper[];
	
  static double INF = Integer.MAX_VALUE, V=0; 

 void floydWarshall() 
 { 
	 V=graph.length;
	 dist = new Double[(int) V][(int) V]; 
     int i, j, k; 

     /* Initialize the solution matrix same as input graph matrix. 
        Or we can say the initial values of shortest distances 
        are based on shortest paths considering no intermediate 
        vertex. */
     for (i = 0; i < V; i++) 
         for (j = 0; j < V; j++) 
             dist[i][j] = graph[i][j]; 

     /* Add all vertices one by one to the set of intermediate 
        vertices. 
       ---> Before start of an iteration, we have shortest 
            distances between all pairs of vertices such that 
            the shortest distances consider only the vertices in 
            set {0, 1, 2, .. k-1} as intermediate vertices. 
       ----> After the end of an iteration, vertex no. k is added 
             to the set of intermediate vertices and the set 
             becomes {0, 1, 2, .. k} */
     for (k = 0; k < V; k++) 
     { 
         // Pick all vertices as source one by one 
         for (i = 0; i < V; i++) 
         { 
             // Pick all vertices as destination for the 
             // above picked source 
             for (j = 0; j < V; j++) 
             { 
                 // If vertex k is on the shortest path from 
                 // i to j, then update the value of dist[i][j] 
            	 double dist_i_k=dist[i][k];
            	 double dist_i_j=dist[i][j];
            	 double dist_k_j=dist[k][j];
            	 
            	 if(dist_i_k == INF || dist_k_j==INF) {
            		 continue;
            	 }
            	 
                 if (dist_i_k + dist_k_j < dist_i_j) 
                     dist[i][j] = dist_i_k + dist_k_j; 
             } 
         } 
     } 

     // Print the shortest distance matrix 
    // printSolution(dist); 
 } 

 void printSolution(int dist[][]) 
 { 
     System.out.println("The following matrix shows the shortest "+ 
                      "distances between every pair of vertices"); 
     for (int i=0; i<V; ++i) 
     { 
         for (int j=0; j<V; ++j) 
         { 
             if (dist[i][j]==INF) 
                 System.out.print("INF "); 
             else
                 System.out.print(dist[i][j]+"   "); 
         } 
         System.out.println(); 
     } 
 } 

 // Driver program to test above function 
 public static void main (String[] args) 
 { 
     /* Let us create the following weighted graph 
        10 
     (0)------->(3) 
     |         /|\ 
     5 |          | 
     |          | 1 
     \|/         | 
     (1)------->(2) 
        3           */
	 
	 /*
      graph = new Double[][] { {0d,   5d,  INF, 10d}, 
                       {INF, 0d,   3d, INF}, 
                       {INF, INF, 0d,   1d}, 
                       {INF, INF, INF, 0d} 
                     }; 
     Sofia Plovdiv 145.4 90
	 Plovdiv Varna 361.4 120.5
	 Varna Burgas 114.95 30
	 Burgas Plovdiv 252.9 42
     *
     */
	 graph = new Double[4][4];
	 mapper = new String[] {"Sofiq","Plovdiv","Varna","Burgas"};
	 
	 for(int i=0;i<graph.length;i++) {
		 
		 for(int j=0;j<graph.length;j++) {
			 graph[i][j]=(double) Integer.MAX_VALUE;
		 }
		 
	 }
	 
	 graph[0][1]=145.4/90;
	 graph[1][0]=145.4/90;
	 graph[0][0]=0d;
	 
	 graph[1][2]=361.4/120.5;
	 graph[2][1]=361.4/120.5;
	 graph[1][1]=0d;
	 
	 graph[2][3]=114.95/30;
	 graph[3][2]=114.95/30;
	 graph[2][2]=0d;
	 
	 graph[1][3]=252.9/42;
	 graph[3][1]=252.9/42;
	 graph[3][3]=0d;
	 
     Speeders a = new Speeders(); 

     
     
     
     
     // Print the solution 
     a.floydWarshall();
     
     LocalTime startTime = LocalTime.of(02,24,18);
     LocalTime endTime = LocalTime.of(04,32,51);
     double until = (double) startTime.until(endTime, SECONDS);
     
     
     double permitedTime=dist[0][2]/3600d;
     
     if(permitedTime<until) {
    	 Util.printlnLine("you was drove with over limited speed");
     }
     
     
     
     Util.printMatrix(dist, 15);
 } 
} 

//Contributed by Aakash Hasija 
