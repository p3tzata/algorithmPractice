package algorithmPractice.graph.tasks;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;



import util.Edge;
import util.Graph;
import util.Util;

public class RoadBuildDestroy {

	
	private static int[][] road;
	private static Character[][] build;
	private static Character[][] destroy;
	private static int[] parent;
	private static List<Edge> listEdges;
	private static List<Edge> listBuldEdges;
	private static int amount=0;
	private static HashSet<Integer> roadedNode;
	
	
	public static void main(String[] args) {
		
				
		/*
		road = new int[5][5];
		Graph.setUndirectedEge( road, 0, 1);
		Graph.setUndirectedEge( road, 1, 3);
		Graph.setUndirectedEge( road, 1, 2);
		Graph.setUndirectedEge( road, 1, 4);
		Graph.setUndirectedEge( road, 3, 2);
		Graph.setUndirectedEge( road, 3, 4);
		
		build = new Character[][] {
			{'A','B','D','E','F'},
			{'B','A','C','E','F'},
			{'D','C','A','E','F'},
			{'E','C','D','A','F'},
			{'F','C','D','E','A'},
			
		};
		
		destroy = new Character[][] {
			{'A','B','D','E','F'},
			{'B','A','C','E','F'},
			{'D','C','A','E','F'},
			{'E','C','D','A','F'},
			{'F','C','D','E','A'},	
		};
		
		
		*/
		
		road = new int[][] {
			{0,1,1,0,0,0},
			{1,0,1,0,0,0},
			{1,1,0,0,0,0},
			{0,0,0,0,1,1},
			{0,0,0,1,0,1},
			{0,0,0,1,1,0}
			
		};
	
	build = new Character[][] {
		{'A','B','D','F','F','F'},
		{'B','A','C','F','F','F'},
		{'D','C','A','F','F','F'},
		{'F','F','F','A','B','D'},
		{'F','F','F','B','A','C'},
		{'F','F','F','D','C','A'}

		
	};
	
	destroy = new Character[][] {
		{'A','B','D','F','F','F'},
		{'B','A','C','F','F','F'},
		{'D','C','A','F','F','F'},
		{'F','F','F','A','B','D'},
		{'F','F','F','B','A','C'},
		{'F','F','F','D','C','A'},
	};
		
	parent = new int[road.length];
	listEdges = new ArrayList<>();	
	listBuldEdges=new ArrayList<>();
	roadedNode = new HashSet<>();
		for (int i=0;i<road.length;i++) {
			
			for(int j=i+1;j<road.length;j++) {
				if(road[i][j]==1) {
				//Util.printlnLine(destroy[i][j]);
					listEdges.add(new Edge(i, j, calcExpance(destroy[i][j])));
				
				}
				
			}
		}

		Comparator<Edge> comparator = Comparator.comparing(Edge::getWeight).reversed();		
				
		listEdges.sort(comparator);

		
		
		
		for(int i=0;i<road.length;i++) {
			
			parent[i]=i;
			
		}
		
		destroyRoad(listEdges);
		
		
for (int i=0;i<road.length;i++) {
			
			for(int j=i+1;j<road.length;j++) {
				
				//Util.printlnLine(destroy[i][j]);
					listBuldEdges.add(new Edge(i, j, calcExpance(build[i][j])));
				
				
				
			}
		}
		
		listBuldEdges.sort(Comparator.comparing(Edge::getWeight));
		
		buildRoad(listBuldEdges);
		
		
		Util.printlnLine(amount);
		String debugString = "debug";
		System.out.print(debugString);		
		
		
		
		
	}

	
	
	

	




	private static void destroyRoad(List<Edge> listEdges) {
		
		
		for (int i = 0; i < listEdges.size(); i++) {
			Edge edge = listEdges.get(i);
			int rootStartNode = findRood(edge.getStartNode());
			int rootEndNode=findRood(edge.getEndNode());
			
			if(rootEndNode!=rootStartNode) {
				parent[edge.getStartNode()]=edge.getEndNode();
				
				
			} else {
				//Util.printlnLine("Delete road" + edge.toString());
				road[edge.getStartNode()][edge.getEndNode()]=0;
				road[edge.getEndNode()][edge.getStartNode()]=0;
				amount+=edge.getWeight();
			}
			
			
			
		}
		
		
		
	}
	
private static void buildRoad(List<Edge> listEdges) {
		
		
		for (int i = 0; i < listEdges.size(); i++) {
			Edge edge = listEdges.get(i);
			int rootStartNode = findRood(edge.getStartNode());
			int rootEndNode=findRood(edge.getEndNode());
			
			if(rootEndNode!=rootStartNode) {
				//
				int oldParent = parent[edge.getEndNode()];
				parent[oldParent]=edge.getEndNode();
				//
				
				
				parent[edge.getEndNode()]= edge.getStartNode();
				
				//
				
				
				//
				
				
				amount+=edge.getWeight();
				
			}
			
			
			
		}
		
		
		
	}
	
	

	
	static int findRood(int node) {
		
		while(node !=parent[node]) {
			node=parent[node];
		}
		
		
		return node;
	}




	private static int calcExpance(Character char_) {
		
		int result=0;
		if (Character.isUpperCase(char_)) {
			
			result =(int) char_ - (int) 'A' ;
			
		} else {
			result =((int) char_ - (int) 'a') +26 ;
		}
		
		
		return result;
		
	}

	
}
