package algorithmPractice.recursion.gfg.myselfTry;


public class InsertIntoLinkedList {


	private static int indx=2;
	
	public static void main(String[] args) {
		
	   Node curNode = new Node(5);
	  
	   curNode = Node.pushNode(curNode, 10);
	   curNode = Node.pushNode(curNode, 20);
	   curNode = Node.pushNode(curNode, 30);
	   curNode = Node.pushNode(curNode, 40);
	   curNode = Node.pushNode(curNode, 50);
	   Node.printLinkNode(curNode);
	   
	   curNode=fun(0,null,curNode);
	   
	   Node.printLinkNode(curNode);
	   
	}

	
	
	private static Node fun(int i,Node prevNode, Node curNode) {
		
		if(indx==0) {
			return curNode.getNextNode();
			
		}
		
		if(i==indx) {
			prevNode.nextNode=curNode.nextNode;
			return null;
		}
		
		 fun(i+1,curNode, curNode.nextNode);
		return curNode;
		
		
		
	}
	
	
	
	
	
	
	
	private  static class Node {
		
		private Node nextNode;
		private Integer data;
		public Node(int data) {
			this.data=data;
			this.nextNode=null;
			
		}
		
		public static void printLinkNode(Node node) {
			
			Node curNode=node;
			
			while(curNode!=null) {
				System.out.print(curNode.getData()+",");
				curNode=curNode.nextNode;
			}
			System.out.println();
			
		}
		
		public static Node pushNode(Node node,int data) {
			
			Node nodeNew = new Node(data);
			nodeNew.setNextNode(node);
			
			return nodeNew;
		}
		
		public Node getNextNode() {
			
			return nextNode;
		}
		public Integer getData() {
			return data;
		}

		public void setNextNode(Node nexNode) {
			this.nextNode = nexNode;
		}

		public void setData(Integer data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
		
		
		
	}
	
	
}
