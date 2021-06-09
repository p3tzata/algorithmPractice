package algorithmPractice.recursion.gfg.myselfTry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeNode {
	
	int data;
	BinaryTreeNode leftChild=null;
	BinaryTreeNode rightChild=null;
	
	public BinaryTreeNode(int data) {
		super();
		this.data = data;
		
	}
	
	public void addChild(BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
		
		this.leftChild=leftChild;
		this.rightChild=rightChild;

	}
	


	public int getData() {
		return data;
	}
	
	
	
	
	
}
