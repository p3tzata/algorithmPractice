package algorithmPractice.recursion.gfg.myselfTry;


import util.Util;

public class RecursionLinkedNode {
	static LinkedNode aNode,bNode=null;
	
	public static void main(String[] args) {
		//LinkedNode aNode = null,bNode=null;
		
		LinkedNode linkedNode = new LinkedNode(100, null);
		
		LinkedNode linkedNode2 = new LinkedNode(90, linkedNode);
		
		LinkedNode linkedNode3 = new LinkedNode(80, linkedNode2);
		LinkedNode  linkedNode4 = new LinkedNode(70, linkedNode3);
		LinkedNode linkedNode5 = new LinkedNode(60, linkedNode4);
		LinkedNode linkedNode6 = new LinkedNode(50, linkedNode5);
		LinkedNode linkedNode7 = new LinkedNode(40, linkedNode6);
		LinkedNode linkedNode8 = new LinkedNode(30, linkedNode7);
		LinkedNode linkedNode9 = new LinkedNode(20, linkedNode8);
		LinkedNode linkedNode10 = new LinkedNode(10, linkedNode9);
		
		
		//linkedNode10.printLinkedNode();
		//fun_findMiddle(linkedNode10,0);
		
		
		//funUtil_split(linkedNode10);
		//aNode.printLinkedNode();
		//bNode.printLinkedNode();
		//fun_printAlternate(linkedNode10,true);

	}
	
	

	private static int fun_findMiddle(LinkedNode node, int i) {
		
		if(node.getNextNode()==null) {
			return i;
		}
		
		
		int total = fun_findMiddle(node.getNextNode(),i+1);
		
		if(total/2==i) {
			Util.printlnLine(node.getData());
		}
		
		return total;
		
	}



	private static void funUtil_split(LinkedNode node) {
		aNode=node;
		
		
		bNode=node.getNextNode();
		LinkedNode findNextNode =bNode.getNextNode();
		
		bNode.setNextNode(null);
		aNode.setNextNode(null);
		
		fun_split(aNode,bNode,true,findNextNode);
		
		
	}

	
	
	


	private static void fun_split(LinkedNode aNode,LinkedNode bNode,Boolean isSetToaNode, LinkedNode nextNode) {
		
		if (nextNode==null) {
			return;
		}
		
		if (isSetToaNode) {
			
			aNode.setNextNode(nextNode);
			LinkedNode findNextNode=nextNode.getNextNode();
			nextNode.setNextNode(null);
			fun_split(nextNode, bNode, !isSetToaNode, findNextNode);
			
			
		} else {
			
			bNode.setNextNode(nextNode);
			LinkedNode findNextNode=nextNode.getNextNode();
			nextNode.setNextNode(null);
			fun_split(aNode, nextNode, !isSetToaNode, findNextNode);
			
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
