package algorithmPractice.graph.training;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import util.Util;

import java.util.Stack;

public class StronglyConnectedComponent {

	static HashMap<Integer, List<Integer>> graph;
	static HashMap<Integer, List<Integer>> reversGraph;
	static boolean[] visited;
	static boolean[] visited_inOut;
	static Stack<Integer> stack;
	static List<List<Integer>> SCCList;
	static HashMap<Integer, HashSet<Integer>> wrappGraph;
	static HashMap<Integer, Integer> wrappGraphMap;
	static ArrayList<Integer> inNeededNodeList;
	static ArrayList<Integer> outNeededNodeList;
	
	static int[] inDegrees;
	static int[] outDegrees;
	
	
	
	public static void main(String[] args) {

		graph = new HashMap<>();
		stack = new Stack<>();
		SCCList = new ArrayList<>();
		wrappGraph = new HashMap<>();
		wrappGraphMap = new HashMap<>();
		/*
		 * graph.put(0, new ArrayList<>(Arrays.asList(2,3))); graph.put(1, new
		 * ArrayList<>(Arrays.asList(0))); graph.put(2, new
		 * ArrayList<>(Arrays.asList(1))); graph.put(3, new
		 * ArrayList<>(Arrays.asList(4))); graph.put(4, new
		 * ArrayList<>(Arrays.asList()));
		 */

		
		  graph.put(0, new ArrayList<>(Arrays.asList(1,13,11))); graph.put(1, new
		  ArrayList<>(Arrays.asList(6))); graph.put(2, new
		  ArrayList<>(Arrays.asList(0))); graph.put(3, new
		  ArrayList<>(Arrays.asList(4))); graph.put(4, new
		  ArrayList<>(Arrays.asList(3,6)));
		  
		  graph.put(5, new ArrayList<>(Arrays.asList(13))); 
		  graph.put(6, new ArrayList<>(Arrays.asList(0,11))); 
		  graph.put(7, new ArrayList<>(Arrays.asList(12))); 
		  graph.put(8, new ArrayList<>(Arrays.asList(11,6))); 
		  graph.put(9, new ArrayList<>(Arrays.asList(0))); 
		  graph.put(10, new ArrayList<>(Arrays.asList(6,4,10))); 
		  graph.put(11, new ArrayList<>(Arrays.asList())); 
		  graph.put(12, new ArrayList<>(Arrays.asList(7))); 
		  graph.put(13, new ArrayList<>(Arrays.asList(2,9)));
		 

		/*
		 * graph.put(0, new ArrayList<>(Arrays.asList(1))); graph.put(1, new
		 * ArrayList<>(Arrays.asList(0))); graph.put(2, new
		 * ArrayList<>(Arrays.asList(1,3,4))); graph.put(3, new
		 * ArrayList<>(Arrays.asList(0))); graph.put(4, new
		 * ArrayList<>(Arrays.asList(3)));
		 */

		visited = new boolean[graph.size()];
		reversGraph = new HashMap<>();
		for (Entry<Integer, List<Integer>> el : graph.entrySet()) {

			reversGraph.put(el.getKey(), new ArrayList<>());
		}

		for (Entry<Integer, List<Integer>> el : graph.entrySet()) {

			Integer parent = el.getKey();
			List<Integer> child = el.getValue();

			for (Iterator iterator = child.iterator(); iterator.hasNext();) {
				Integer child_ = (Integer) iterator.next();

				reversGraph.get(child_).add(parent);

			}

		}

		for (Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			Integer v = entry.getKey();
			if (!visited[v]) {
				DFS(v);
			}
		}

		visited = new boolean[graph.size()];

		while (!stack.isEmpty()) {
			Integer v = stack.pop();
			if (!visited[v]) {
				// Util.printlnLine("==");
				SCCList.add(new ArrayList<>());
				DFSReverse(v);
			}

		}

		for (Iterator iterator = SCCList.iterator(); iterator.hasNext();) {
			List<Integer> list = (List<Integer>) iterator.next();
			Util.printlnLine(list);
		}

		
		for(int i=0;i<SCCList.size();i++) {
			
			List<Integer> parentList = SCCList.get(i);
			
			
			for(int j=0;j<parentList.size();j++) {
				
				wrappGraphMap.put(parentList.get(j), i);
				
				
			}
			
		}
		
		
		for(int i=0;i<SCCList.size();i++) {
			
			List<Integer> parentList = SCCList.get(i);
			
			
			
			for(int j=0;j<parentList.size();j++) {
				
				Integer curNode = parentList.get(j);
				List<Integer> listOfOrgGraph = graph.get(curNode);
				
				Integer curMappedNode = wrappGraphMap.get(curNode);
				
				if (!wrappGraph.containsKey(curMappedNode)) {
				wrappGraph.put(curMappedNode, new HashSet<>());
				}
				
				
				
				for (Iterator iterator = listOfOrgGraph.iterator(); iterator.hasNext();) {
					Integer integer = (Integer) iterator.next();
					
					if(wrappGraphMap.get(integer)!=curMappedNode) {
						Integer integer2 = wrappGraphMap.get(integer);
						
							wrappGraph.get(curMappedNode).add(integer2);
						
						
						
					}
					
				}
				
				
				
				
			}
			
		}
		
		
		
		
		visited_inOut=new boolean[wrappGraph.size()];
		inDegrees = new int[wrappGraph.size()];
		outDegrees= new int[wrappGraph.size()];
		for(int k=0;k<visited_inOut.length;k++) {
			if(!visited_inOut[k]) {
			DFS_inOut(k);
			}
		}
		
		inNeededNodeList  = new ArrayList<>();
		outNeededNodeList  = new ArrayList<>();
		
		int inCnt=0;
		int outCnt=0;
		
		for(int k=0; k<inDegrees.length;k++) {
			if(inDegrees[k]==0) {
				
				inCnt++;
			}
			inNeededNodeList.add(k);
			
			
		}
		
		for(int k=0; k<outDegrees.length;k++) {
			if(outDegrees[k]==0) {
				outCnt++;
			}
			outNeededNodeList.add(k);
			
		}
		Comparator<Object> comparatorIn = Comparator.comparing(
				(el) -> {if(inDegrees[(int) el]==0 && outDegrees[(int) el]==0) {return 0;} else {return 1;} }  
		).thenComparing((el) -> {if(inDegrees[(int) el]==0) {return 0;} else {return 1;} }  );
		
		Comparator<Object> comparatorOut = Comparator.comparing(
				(el) -> {if(inDegrees[(int) el]==0 && outDegrees[(int) el]==0) {return 0;} else {return 1;} }  
		).thenComparing((el) -> {if(outDegrees[(int) el]==0) {return 0;} else {return 1;} }  );
		
		inNeededNodeList.sort(comparatorIn);
		outNeededNodeList.sort(comparatorOut);
		
		
		
		
		
		if (inCnt>outCnt) {
			
		
			for(int i=0;i<inNeededNodeList.size();i++) {
				Integer nodeNeedToInner = inNeededNodeList.get(i);
				if (inDegrees[nodeNeedToInner]!=0) {
					
					break;
					
				}
				
				for(int j=0;j<outNeededNodeList.size();j++) {
					
					int nodeToOutter=outNeededNodeList.get(j);
					if (nodeNeedToInner==nodeToOutter) {
						continue;
					}
					
					
					
					
					Util.printlnLine(SCCList.get(nodeToOutter).get(0) + "->" + SCCList.get(nodeNeedToInner).get(0));
					outNeededNodeList.remove(j);
					break;
					
				}
										
			}
			
		} else {
			
			//Just Opposite;
			
		}
		
		
		
		
		/*
		 * stack.add(1); stack.add(2); stack.add(3); stack.pop();
		 */

		String debugString = "debug";
		System.out.print(debugString);

	}

	private static Integer findNonStackedNode(Integer nodeMustInned, Integer nodeMustOutted) {
		for (int i=0;i<outDegrees.length;i++) {
			
			if (nodeMustInned!=i ) {
				nodeMustOutted=i;
				break;
			}
			
		}
		return nodeMustOutted;
	}

	private static void DFS_inOut(int v) {
		
		if(!visited_inOut[v]) {
			visited_inOut[v]=true;
			for (int child : wrappGraph.get(v)) {
				
				outDegrees[v]++;
				inDegrees[child]++;
				DFS_inOut(child);
				
				
			}
			
			
		}
		
		
	}
	
	
	
	private static void DFSReverse(Integer v) {

		if (!visited[v]) {
			// Util.printlnLine(v);
			SCCList.get(SCCList.size() - 1).add(v);

			visited[v] = true;
			List<Integer> listOfAdjacent = reversGraph.get(v);
			if (listOfAdjacent != null) {
				Iterator<Integer> iteratorOfAdjacent = listOfAdjacent.iterator();
				while (iteratorOfAdjacent.hasNext()) {
					Integer child = (Integer) iteratorOfAdjacent.next();

					DFSReverse(child);

				}
			}

		}

	}

	static void DFS(int v) {

		if (!visited[v]) {

			visited[v] = true;
			List<Integer> listOfAdjacent = graph.get(v);
			Iterator<Integer> iteratorOfAdjacent = listOfAdjacent.iterator();
			while (iteratorOfAdjacent.hasNext()) {
				Integer child = (Integer) iteratorOfAdjacent.next();
				if (child == 13) {
					String debugString = "debug";
					System.out.print(debugString);
				}
				DFS(child);

			}

			stack.add(v);
		}

	}

}
