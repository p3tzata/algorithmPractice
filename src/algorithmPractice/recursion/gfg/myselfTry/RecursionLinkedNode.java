package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class RecursionLinkedNode {
	static LinkedNode aNode,bNode=null;
	
	public static void main(String[] args) {
		//LinkedNode aNode = null,bNode=null;
		
		LinkedNode linkedNode = new LinkedNode(10, null);
		
		LinkedNode linkedNode2 = new LinkedNode(9, linkedNode);
		
		LinkedNode linkedNode3 = new LinkedNode(8, linkedNode2);
		LinkedNode linkedNode4 = new LinkedNode(7, linkedNode3);
		LinkedNode linkedNode5 = new LinkedNode(6, linkedNode4);
		LinkedNode linkedNode6 = new LinkedNode(5, linkedNode5);
		LinkedNode linkedNode7 = new LinkedNode(4, linkedNode6);
		LinkedNode linkedNode8 = new LinkedNode(3, linkedNode7);
		LinkedNode linkedNode9 = new LinkedNode(2, linkedNode8);
		LinkedNode linkedNode10 = new LinkedNode(1, linkedNode9);
		
		
		//linkedNode10.printLinkedNode();
		
		
		
		funUtil(linkedNode10);
		aNode.printLinkedNode();
		bNode.printLinkedNode();
		//fun_printAlternate(linkedNode10,true);

	}
	
	

	private static void funUtil(LinkedNode node) {
		aNode=node;
		
		
		bNode=node.getNextNode();
		LinkedNode findNextNode =bNode.getNextNode();
		
		bNode.setNextNode(null);
		aNode.setNextNode(null);
		
		fun(aNode,bNode,true,findNextNode);
		
		
	}

	
	
	


	private static void fun(LinkedNode aNode,LinkedNode bNode,Boolean isSetToaNode, LinkedNode nextNode) {
		
		if (nextNode==null) {
			return;
		}
		
		if (isSetToaNode) {
			
			aNode.setNextNode(nextNode);
			LinkedNode findNextNode=nextNode.getNextNode();
			nextNode.setNextNode(null);
			fun(nextNode, bNode, !isSetToaNode, findNextNode);
			
			
		} else {
			
			bNode.setNextNode(nextNode);
			LinkedNode findNextNode=nextNode.getNextNode();
			nextNode.setNextNode(null);
			fun(aNode, nextNode, !isSetToaNode, findNextNode);
			
		}
		
		

		
	}



	private static void fun_printAlternate(LinkedNode linkedNode,boolean isNeedPrint) {
		
		if(isNeedPrint) {
			Util.printlnLine(linkedNode.getData());
		}
		
		if(linkedNode.getNextNode()==null) {
			return;
		}
		
		fun_printAlternate(linkedNode.getNextNode(),!isNeedPrint);
		
	}

}
