package util;

public class Edge implements Comparable<Edge> {
	
	private int startNode;
	
	private int endNode;
	
	private int weight;

	public Edge(int startNode, int endNode, int weight) {
		super();
		this.startNode = startNode;
		this.endNode = endNode;
		this.weight = weight;
	}

	public int getStartNode() {
		return startNode;
	}

	public int getEndNode() {
		return endNode;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Edge [startNode=" + startNode + ", endNode=" + endNode + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Edge o) {
		
		return this.getStartNode()==o.getStartNode() && this.getEndNode()==o.getEndNode() && this.getWeight()==o.getWeight() ? 0 : -1 ;
	}

	
	
	
	
	
	
}
