package util;

public class EdgeFlow {

	private int startNode;
	
	private int endNode;
	
	private int flow;
	
	private int capacity;

	public EdgeFlow(int startNode, int endNode, int flow, int capacity) {
		super();
		this.startNode = startNode;
		this.endNode = endNode;
		this.flow = flow;
		this.capacity = capacity;
	}

	
	
	
	public void setFlow(int flow) {
		this.flow = flow;
	}

	public int getStartNode() {
		return startNode;
	}

	public int getEndNode() {
		return endNode;
	}

	public int getFlow() {
		return flow;
	}

	public int getCapacity() {
		return capacity;
	}
	
	
	
	
}
