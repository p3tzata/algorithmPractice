package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class RecursionGraphNode {
	
	public static void main(String[] args) {
		
		GraphNode node1=new GraphNode(1);
		GraphNode node2=new GraphNode(2);
		GraphNode node3=new GraphNode(3);
		GraphNode node4=new GraphNode(4);
		GraphNode node5=new GraphNode(5);
		GraphNode node6=new GraphNode(6);
		GraphNode node7=new GraphNode(7);
		GraphNode node8=new GraphNode(8);
		GraphNode node9=new GraphNode(9);
		GraphNode node10=new GraphNode(10);
		
		
		node1.addChild(node2);node1.addChild(node3);
		node2.addChild(node4);
		node3.addChild(node5);node3.addChild(node8);
		node5.addChild(node6);node5.addChild(node7);
		node8.addChild(node9);node8.addChild(node10);
		
		
		fun(node1);
		
	}

	private static void fun(GraphNode node) {
		
		if(node.getChilds().size()==0) {
			Util.printlnLine(node.getData());
			return;
		}
		
		
		for(int i=0;i<node.getChilds().size();i++) {
			
			fun(node.getChilds().get(i));
		}
		
		
	}
}
