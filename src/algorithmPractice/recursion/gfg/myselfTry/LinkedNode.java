package algorithmPractice.recursion.gfg.myselfTry;

import util.Util;

public class LinkedNode {

	
	private int data;
	
	private LinkedNode nextNode;

	public LinkedNode(Integer data, LinkedNode nextNode) {
		super();
		this.data = data;
		this.nextNode = nextNode;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public LinkedNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(LinkedNode nextNode) {
		this.nextNode = nextNode;
	}
	
	public void printLinkedNode() {
		LinkedNode curNode = this;
		
		while(curNode!=null) {
			
			Util.printlnLine(curNode.getData());
			curNode=curNode.getNextNode();
		}
		
	}
	
	
	
	
	
	
}
